package cyou.bike.com.live.net.http;

import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/10/23 10:19
 * Email: anlonglong0721@gmail.com
 */

public enum HttpMethod {
    GET,
    POST;

    public static HttpMethod Method(String httpMethod) {
        HttpMethod method = null;
        try {
            method = valueOf(httpMethod);
        }catch (Exception e) {
            LogUtil.e("","not found "+httpMethod);
        }
        return method;
    }
}
