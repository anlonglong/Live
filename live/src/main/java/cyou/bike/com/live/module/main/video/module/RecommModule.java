package cyou.bike.com.live.module.main.video.module;/**
 * Created by anlonglong on 2017/12/23.
 */

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.callback.VideoResponseListener;
import cyou.bike.com.live.module.main.video.contract.RecommContract;
import cyou.bike.com.live.net.api.home.VideoApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 17:44
 * <p>
 * Desc: null
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class RecommModule implements RecommContract.Module  {

    private Context mContext = LiveApplication.getLiveApplication();

    @Override
    public RecommContract.View getView() {
        return null;
    }

    @Override
    public void getHotVideoList1(final VideoResponseListener.HotVideoList1Listener listener) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.setUrl(VideoApi.GET_HOT_VIDEO_LIST);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<HotVideoList>() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, HotVideoList data) throws IOException {
                if (data.getError() == 0) {
                    listener.onGetHotVideoList1Listener(data.getData());
                }
            }
        });
    }

    @Override
    public void getCateHotVideoList1(final VideoResponseListener.CateHotVideoList1Listener listener) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.setUrl(VideoApi.GET_CATE_HOT_VIDEO_LIST);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<CateHotVideoList>() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, CateHotVideoList data) throws IOException {
                if (data.getError() == 0) {
                    listener.onGetCateHotVideoList1Listener(data.getData());
                }
            }
        });
    }

    @Override
    public void getHotAuthors(final VideoResponseListener.HotAuthorsListener listener) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.setUrl(VideoApi.GET_HOT_AUTHORS);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<HotAuthors>() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, HotAuthors data) throws IOException {
                if (data.getError() == 0) {
                    listener.onGetHotAuthorsListener(data.getData());
                }
            }
        });
    }
}
