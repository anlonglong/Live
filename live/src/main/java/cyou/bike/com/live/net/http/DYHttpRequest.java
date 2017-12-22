package cyou.bike.com.live.net.http;

import java.io.IOException;

import cyou.bike.com.live.base.BaseHttpOutput;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/10/23 12:03
 * Email: anlonglong0721@gmail.com
 */

public class DYHttpRequest {


    private RequestWrapper mWrapper;
    private static final Object mlock = new Object();
    private static DYHttpRequest mRequest;
    private Call mCall;

    private DYHttpRequest() {

    }

    public DYHttpRequest setRequestWrapper(RequestWrapper wrapper) {
        mWrapper = wrapper;
        return this;
    }

    public static DYHttpRequest getRequest() {
        if (null == mRequest) {
            synchronized (mlock) {
                if (null == mRequest) {
                    mRequest = new DYHttpRequest();
                }
            }
        }
        return mRequest;
    }


    /**
     *
     * @param method
     * @param listener
     * @param <T>
     * @return  返回值可用于取消当前的请求.
     */
    public <T extends BaseHttpOutput> Call doRequest(HttpMethod method, HttpListener<T> listener) {
        if (mWrapper == null) {
            throw new NullPointerException("请求前需要调 setRequestWrapper() 方法,设置请求的参数 ");
        }
        this.mCall = mWrapper.doRequest(method, mWrapper.getRequest(), listener);
        return mCall;
    }

    public Call getCall() {
        return mCall;
    }

    public void cancelRequest() {
        if (null != mCall) {
            mCall.cancel();
        }
    }

    /**
     * http 返回的数据封装类
     * 因为okhttp的请求回调在子线程里,
     * 我们只能通过handler发送到主线程,
     * 而handler只能携带一个参数,而回调的参数有还几个,
     * 所以我们把数据封装好,统一发送.
     *
     * @param <T>
     */
    public static class Result<T> {
        private Call call;
        private IOException exception;
        private T data;
        private Response response;

        public Result() {
        }

        public Result(Call call, IOException e, T data, Response response) {
            this.call = call;
            this.exception = e;
            this.data = data;
            this.response = response;
        }

        public Call getCall() {
            return call;
        }

        public Result setCall(Call call) {
            this.call = call;
            return this;
        }


        public IOException getException() {
            return exception;
        }

        public Result setException(IOException exception) {
            this.exception = exception;
            return this;
        }

        public T getData() {
            return data;
        }

        public Result setData(T data) {
            this.data = data;
            return this;
        }

        public Response getResponse() {
            return response;
        }

        public Result setResponse(Response response) {
            this.response = response;
            return this;
        }
    }
}
