package cyou.bike.com.live.net.http;

import java.io.IOException;

import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.utils.LogUtil;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/10/23 15:44
 * Email: anlonglong0721@gmail.com
 */

public interface HttpListener<T extends BaseHttpOutput> {

    enum HttpState {
        HTTPSUCCESS(0x01),
        HTTPFAIL(0x02);

        private int code;

        HttpState(int i) {
            this.code = i;
        }

        public int getCode() {
            return code;
        }


        /**
         *
         * @param ste 把字符串state转换成对应烦人枚举
         * @return
         */
        public static HttpState state(String ste) {
            HttpState state = null;
            try {
                state = valueOf(ste);
            } catch (Exception e) {
                LogUtil.e("Unexpected HttpState", e.getMessage());
            }
            return state;
        }


        /**
         * 根据code获取对应的枚举常量
         * @param ste
         * @return
         */
        public static HttpState get(int ste) {
           if (ste ==HTTPSUCCESS.code) return HTTPSUCCESS;
           if (ste == HTTPFAIL.code ) return HTTPFAIL;
           return null;
        }

    }

     void onFailure(Call call, IOException e);
     void onResponse(Call call, Response response,T data) throws IOException;
}
