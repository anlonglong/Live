package cyou.bike.com.live.module.main.video.module;/**
 * Created by anlonglong on 2017/12/23.
 */

import android.content.Context;

import java.io.IOException;
import java.util.List;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.bean.VideoHomeCate;
import cyou.bike.com.live.module.main.video.callback.VideoResponseListener;
import cyou.bike.com.live.module.main.video.contract.VideoContract;
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
 * On 2017/12/23 at 15:59
 * <p>
 * Desc: ssss
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoModule implements VideoContract.Module{

    private Context mContext = LiveApplication.getLiveApplication();

    @Override
    public BaseView getView() {
        return null;
    }

    @Override
    public void getVideoHomeCate1(final VideoResponseListener.VideoHomeCate1Listener listener) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.setUrl(VideoApi.GET_VIDEO_HOME_CATE1_URL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<VideoHomeCate>() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFail(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, VideoHomeCate data) throws IOException {
                if (data.getError() == 0) {
                    List<VideoHomeCate.DataBean> list = data.getData();
                    listener.onGetVideoHomeCate1Listener(list);
                }
            }
        });
    }
}
