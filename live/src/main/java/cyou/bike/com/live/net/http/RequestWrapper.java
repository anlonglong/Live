package cyou.bike.com.live.net.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.utils.LogUtil;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by：anlonglong
 * on 2017/10/23 11:05
 * Email: anlonglong0721@gmail.com
 */

public class RequestWrapper extends DYRequest {

    private static final String TAG = "RequestWrapper";

    private WeakReference<Context> mReferenceCtx;//cache用的
    /**
     *用于创建OkHttpClient
     */
    private OkHttpClient.Builder mBuilder;
    /**
     * 请求参数的封装
     */
    private Request.Builder mRequestBuilder;
    /**
     * 网络接口的监听
     */
    private HttpListener mListener;
    /**
     * 网络请求的有一些配置
     * eg:超时时间,是否需要缓存等.
     */
    private NetWorkConfiguration mConfiguration;


    public RequestWrapper(Context context) {
        mReferenceCtx = new WeakReference<Context>(context);
        mConfiguration = new NetWorkConfiguration(mReferenceCtx.get());
        mBuilder = new OkHttpClient.Builder()
                .connectTimeout(mConfiguration.getConnectTimeOut(), TimeUnit.MILLISECONDS)
                .connectionPool(mConfiguration.getConnectionPool())
                .retryOnConnectionFailure(true);
        if (mConfiguration.getIsCache()) {
            mBuilder.cache(mConfiguration.getDiskCache());
        }
        setConfiguration(mConfiguration);
        mRequestBuilder = new Request.Builder();
        addInterceptor(new DYInterceptor(this));
    }


    public void setConfiguration(NetWorkConfiguration configuration) {
        mConfiguration = configuration;
    }

    public void addInterceptor(Interceptor interceptor) {
        if (null != interceptor) {
            mBuilder.addInterceptor(interceptor);
            mBuilder.addInterceptor(new HttpLoggingInterceptor());
        }

    }

    public void addNetworkInterceptor(Interceptor interceptor) {
        if (null != interceptor) {
            mBuilder.addNetworkInterceptor(interceptor);
        }

    }

    public Request getRequest() {
        if (mConfiguration.getIsCache()) {
            mRequestBuilder.cacheControl(CacheControl.FORCE_CACHE);
        }
        return mRequestBuilder.build();
    }

    public OkHttpClient getOkHttpClient() {
        OkHttpClient client = mBuilder.build();
        return client;
    }

    public void addHeader() {
        if (!getHeader().isEmpty()) {
            Headers headers = Headers.of(getHeader());
            mRequestBuilder.headers(headers);
        }
    }

    @Override
    public String getBaseUrl() {
        return IDYRequest.BASE_URL;
    }

    @Override
    public void setUrl(String url) {
       try {
           mRequestBuilder.url(url + getRequestParamsWithUrl());
       }catch (NullPointerException e) {
           LogUtil.i(TAG," url 不能为空!!!");
       }
    }

    @Override
    public Call doRequest(HttpMethod method, Request r, HttpListener listener) {
        Call call = null;
        if (HttpMethod.GET == method) {
           call = doGetRequest(r, listener);
        } else if (HttpMethod.POST == method) {
           call = doPostRequest();
        }
        return call;
    }

    private <T extends BaseHttpOutput> Call doGetRequest(Request request, final HttpListener<T> listener ) {
        checkNotNull(listener);
        this.mListener = listener;
        final DYHttpRequest.Result<T> tResult = new DYHttpRequest.Result<>();
        addHeader(request);
        Call call = getOkHttpClient().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                tResult.setCall(call).setException(e);
                Message message = Message.obtain();
                message.obj = tResult;
                message.what = HttpListener.HttpState.HTTPFAIL.getCode();
                mHandler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    LogUtil.i(TAG, "OrigianlData = " + getReponseOrigianlData());
                    LogUtil.i(TAG, "ContentType() = " + getContentType().toString());
                    Class clazz = getActualType(listener);
                    T data = null;
                    //BaseHttpOutput data=null;
                    // d = (T) JSONObject.parseObject(getReponseOrigianlData(), clazz);
                    //data = (BaseHttpOutput) gson.fromJson(getReponseOrigianlData(), clazz);
                    try {
                        Gson gson = new Gson();
                        data = (T) gson.fromJson(getReponseOrigianlData(), clazz);
                    } catch (Exception e) {
                        LogUtil.e(TAG, e.getMessage());
                    }
                    tResult.setCall(call).setResponse(response).setData(data);
                    Message message = Message.obtain();
                    message.obj = tResult;
                    message.what = HttpListener.HttpState.HTTPSUCCESS.getCode();
                    if (!call.isCanceled()) {
                        mHandler.sendMessage(message);
                    }
                }
            }
        });
        return call;
    }

    private Object checkNotNull(Object o) {
        if (null == o) {
            throw new NullPointerException(o.toString()+" is null ");
        }
        return o;
    }

    private <T extends BaseHttpOutput> Class getActualType(HttpListener<T> listener) {
        /**
         *传进来的泛型实际的类型必须要有父类(随便自定义一个继承就可以了,该父类可以什么都不写),
         * 因为通过下面的方法获取泛型实际类型的时候,首先要获取父类的类型,如无法找到, 返回Object.class
         * //通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class
         * **/
        Class data = null;
        Type[] types = listener.getClass().getGenericInterfaces();
        if (types != null && types.length > 0) {
            Type[] params = ((ParameterizedType) types[0]).getActualTypeArguments();
            if (params != null && params.length > 0) {
                data = (Class) params[0];
            }
        }
        return data;
    }

    private void addHeader(Request request) {
        if (!getHeader().isEmpty()) {
            Map<String, String> header = getHeader();
            Set<String> keySet = header.keySet();
            Request.Builder builder = request.newBuilder();
            for (String key : keySet) {
                builder.addHeader(key, header.get(key));
            }
        }
    }

    protected Call doPostRequest() {
        return null;
    }

    @Override
    public HttpMethod getHttpMehtod() {
        return HttpMethod.Method(mRequestBuilder.build().method());
    }


    @Override
    public String getRequestParamsWithUrl() {
        StringBuffer sb = new StringBuffer();
        if (!getParams().isEmpty()) {
            sb.append('?');
            Set<Map.Entry<String, String>> entries = getParams().entrySet();
            Iterator<Map.Entry<String, String>> iterator = entries.iterator();
            int pos = 0;
            while (iterator.hasNext()) {
                Map.Entry<String, String> next = iterator.next();
                ++pos;
                sb.append(String.format("%s=%s", next.getKey(), next.getValue()));
                if (pos < entries.size()) {
                    sb.append('&');
                }
            }
        }
        return sb.toString();
    }

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            DYHttpRequest.Result result = (DYHttpRequest.Result) msg.obj;
            switch (HttpListener.HttpState.get(msg.what)) {
                case HTTPSUCCESS:
                    try {
                        mListener.onResponse(result.getCall(), result.getResponse(), (BaseHttpOutput) result.getData());
                    } catch (Exception e) {
                        LogUtil.i(TAG, e.getMessage());
                    }
                    break;
                case HTTPFAIL:
                    mListener.onFailure(result.getCall(), result.getException());
                    break;
                default:
            }

        }
    };

}
