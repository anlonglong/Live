package cyou.bike.com.live.net.contract;/**
 * Created by anlonglong on 2017/12/20.
 */

import java.util.Map;

import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import okhttp3.MediaType;
import okhttp3.Request;

/**
 * Created by anlonglong
 * <p>
 * on 2017/12/20
 * <p>
 * desc: http请求和响应的一些信息
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public interface IHttpContracts {
    public interface HttpRequest {

        void addHeader(String key, String value);

        void setContentType(MediaType contentType);

        String getRequestParamsWithUrl();

        void setUrl(String url);

        String getBaseUrl();

        HttpMethod getHttpMehtod();

        void setParams(Map<String,String> params);

        void putParams(String key,int value);

        void putParams(String key,String value);

        Map<String,String> getParams();

    }

    public interface HttpReponse {

        String getReponseOrigianlData();

        void setReponseOrigianlData(String data);

        MediaType getContentType();

        Map<String, String> getHeader();
    }

    void doRequest(HttpMethod method, Request request, HttpListener listener);
}
