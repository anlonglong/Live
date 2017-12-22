package cyou.bike.com.live.net.http;

import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;

/**
 * Created by：anlonglong
 * on 2017/10/23 10:21
 * Email: anlonglong0721@gmail.com
 */

public interface IDYRequest {

    String BASE_URL = "http://capi.douyucdn.cn/api/";

    void addHeader(String key, String value);

    Map<String, String> getHeader();

    void setContentType(MediaType contentType);

    MediaType getContentType();

    void setUrl(String url);

    String getBaseUrl();

    HttpMethod getHttpMehtod();

    void setParams(Map<String, String> params);

    void putParams(String key, int value);

    void putParams(String key, String value);

    Map<String, String> getParams();

    String getRequestParamsWithUrl();

    String getReponseOrigianlData();

    void setReponseOrigianlData(String data);

    Call doRequest(HttpMethod method, Request request, HttpListener listener);

}
