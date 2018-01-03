package cyou.bike.com.live.module.main.video.module;/**
 * Created by anlonglong on 2017/12/29.
 */

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.video.bean.VideoCate2;
import cyou.bike.com.live.module.main.video.contract.VideoInnerContract;
import cyou.bike.com.live.module.main.video.presenter.VideoInnerPresenter;
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
 * On 2017/12/29 at 14:06
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoInnerModule implements VideoInnerContract.Module {

    private Context mContext = LiveApplication.getLiveApplication();
    @Override
    public VideoInnerContract.View getView() {
        return null;
    }


    @Override
    public void getVideoCate2(String cid,final VideoInnerPresenter.VideoCate2Listener listener) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.getSystemType());
        wrapper.putParams("aid",SystemType.ANDROID.getSystemType().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.putParams("cid1",cid);
        wrapper.setUrl(VideoApi.GET_VIDEO_CATE2);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<VideoCate2>() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, VideoCate2 data) throws IOException {
                listener.onVideoCate2(data);
            }
        });
    }
}
