package cyou.bike.com.live.net.http;

import java.io.IOException;

import cyou.bike.com.live.utils.LogUtil;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/10/23 16:35
 * Email: anlonglong0721@gmail.com
 */

public class DYInterceptor implements Interceptor {



    public static final String TAG = DYInterceptor.class.getSimpleName();

    private  IDYRequest mRequest;

    public DYInterceptor(IDYRequest request) {
        this.mRequest = request;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        LogUtil.i(TAG,"mehtod = "+request.method());
        LogUtil.i(TAG,"url = "+request.url().toString());
        Response proceed = chain.proceed(request);
        String string = proceed.body().string();
        MediaType contentType = proceed.body().contentType();
        mRequest.setReponseOrigianlData(string);
        mRequest.setContentType(contentType);
        return proceed;
    }
}
