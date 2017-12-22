package com.team.zhuoke.net.http;

import android.content.Context;

import com.team.zhuoke.net.config.NetWorkConfiguration;
import com.team.zhuoke.net.cookie.SimpleCookieJar;
import com.team.zhuoke.net.interceptor.LogInterceptor;
import com.team.zhuoke.net.interceptor.ReponsedInterceptor;
import com.team.zhuoke.net.request.RetrofitClient;
import com.team.zhuoke.utils.L;
import com.team.zhuoke.utils.NetworkUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：   对OkHttpClient进行配置
 *  备注消息：
 *  修改时间：2016/11/18 下午2:12
 **/
public class HttpUtils {

    public static final String TAG = "HttpUtils";

//    获得HttpUtils实例
    private static HttpUtils mInstance;
//    OkHttpClient对象
    private OkHttpClient mOkHttpClient;
    private  static NetWorkConfiguration sConfiguration;
    private Context context;
    /**
     *   是否加载本地缓存数据
     *      默认为TRUE
     */
    private   boolean isLoadDiskCache = true;
    /**
     *   ---> 针对无网络情况
     *  是否加载本地缓存数据
     * @param isCache  true为加载 false不进行加载
     * @return
     */
    public  HttpUtils setLoadDiskCache(boolean isCache) {
        this.isLoadDiskCache = isCache;
        return this;
    }

    /**
     *  ---> 针对有网络情况
     *  是否加载内存缓存数据
     *   默认为False
     */
    private  boolean isLoadMemoryCache=false;

    /**
     *  是否加载内存缓存数据
     * @param isCache  true为加载 false不进行加载
     * @return
     */
    public  HttpUtils setLoadMemoryCache(boolean isCache)
    {
        this.isLoadMemoryCache=isCache;
        return this;
    }


    private HttpUtils(Context context)
    {

        //我觉得在构造函数中做了太多的事情


//创建默认 okHttpClient对象
        this.context=context;
        /**进行默认配置
         *    未配置configuration ,
         *
         */
        if(sConfiguration ==null)
        {
            sConfiguration =new NetWorkConfiguration(context);
        }
        if(sConfiguration.getIsCache())
        {
            mOkHttpClient=new OkHttpClient.Builder()
//                   网络缓存拦截器
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(interceptor)
//                    自定义网络Log显示
                    .addInterceptor(new LogInterceptor())
                    .addInterceptor(new ReponsedInterceptor())//自己加的拦截器
                    .cache(sConfiguration.getDiskCache())
                    .connectTimeout(sConfiguration.getConnectTimeOut(), TimeUnit.SECONDS)
                    .connectionPool(sConfiguration.getConnectionPool())
                    .retryOnConnectionFailure(true)
                    .build();
        }
        else
        {
            mOkHttpClient=new OkHttpClient.Builder()
                    .addInterceptor(new LogInterceptor())
                    .connectTimeout(sConfiguration.getConnectTimeOut(), TimeUnit.SECONDS)
                    .connectionPool(sConfiguration.getConnectionPool())
                    .retryOnConnectionFailure(true)
                    .build();

        }
        /**
         *
         *  判断是否在AppLication中配置Https证书
         *
         */
        if(sConfiguration.getCertificates()!=null)
        {
            mOkHttpClient = getOkHttpClient().newBuilder()
                    .sslSocketFactory(HttpsUtils.getSslSocketFactory(sConfiguration.getCertificates(), null, null))
                    .build();
        }
    }
    /**
     *  设置网络配置参数,在Application中进行了初始化
     * @param configuration
     */
    public  static void setConFiguration(NetWorkConfiguration configuration)
    {
        if(configuration == null) {
            throw new IllegalArgumentException("ImageLoader sConfiguration can not be initialized with null");
        } else {
            if(HttpUtils.sConfiguration == null) {
                L.d("Initialize NetWorkConfiguration with sConfiguration");
                HttpUtils.sConfiguration = configuration;
            } else {
                L.e("Try to initialize NetWorkConfiguration which had already been initialized before. To re-init NetWorkConfiguration with new sConfiguration ");
            }
        }
        if(configuration!=null) {
            L.i("ConFiguration" + configuration.toString());
        }
    }
    public RetrofitClient getRetofitClinet()
    {

        L.i("sConfiguration:"+ sConfiguration.toString());
        return new RetrofitClient(sConfiguration.getBaseUrl(),mOkHttpClient);
    }

    /**
     *  设置HTTPS客户端带证书访问
     * @param certificates  本地证书
     */
    public HttpUtils setCertificates(InputStream... certificates)
    {
        mOkHttpClient = getOkHttpClient().newBuilder()
                .sslSocketFactory(HttpsUtils.getSslSocketFactory(certificates, null, null))
                .build();
        return this;
    }

    /**
     *  设置是否打印网络日志
     * @param isDebug
     */
    public HttpUtils setDBugLog(boolean isDebug)
    {
         if(isDebug)
         {
             mOkHttpClient=getOkHttpClient().newBuilder()
                                    .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                                    .build();
         }
        return this;
    }

    /**
     *   设置Coolie
     * @return
     */
    public  HttpUtils addCookie()
    {
        mOkHttpClient=getOkHttpClient().newBuilder()
                             .cookieJar(new SimpleCookieJar())
                             .build();
        return this;
    }

    /**
     *  获得OkHttpClient实例
     * @return
     */
    public OkHttpClient getOkHttpClient()
    {
        return  mOkHttpClient;
    }

    /**
     *  网络拦截器
     *    进行网络操作的时候进行拦截
     */
    final Interceptor interceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            /**
             *  断网后是否加载本地缓存数据
             *
             */
            if (!NetworkUtil.isNetworkAvailable(sConfiguration.context)&&isLoadDiskCache) {
                    request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
//            加载内存缓存数据
            else if(isLoadMemoryCache)
            {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            /**
             *  加载网络数据
             */
            else
            {
                  request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            }
            Response response = chain.proceed(request);
//            有网进行内存缓存数据
            if (NetworkUtil.isNetworkAvailable(sConfiguration.context)&& sConfiguration.getIsMemoryCache()) {
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + sConfiguration.getmemoryCacheTime())
                        .removeHeader("Pragma")
                        .build();
            } else {
//              进行本地缓存数据
                if(sConfiguration.getIsDiskCache()) {
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + sConfiguration.getDiskCacheTime())
                            .removeHeader("Pragma")
                            .build();
                    //
                }
            }
            return response;
        }
    };
    /**
     *  获取请求网络实例
     * @return
     */
    public static HttpUtils getInstance(Context context)
    {
        if (mInstance == null)
        {
            synchronized (HttpUtils.class)
            {
                if (mInstance == null)
                {
                    mInstance = new HttpUtils(context);
                }
            }
        }
        return mInstance;
    }


}
