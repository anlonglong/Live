package cyou.bike.com.live.module.main.video.module;/**
 * Created by anlonglong on 2017/12/29.
 */

import android.content.Context;
import android.support.annotation.NonNull;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.video.bean.RecVideoList;
import cyou.bike.com.live.module.main.video.contract.VideoDetailContract;
import cyou.bike.com.live.module.main.video.presenter.VideoDetailPresenter;
import cyou.bike.com.live.net.api.home.VideoApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.IDYRequest;
import cyou.bike.com.live.net.http.RequestWrapper;
import io.vov.vitamio.provider.MediaStore;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/29 at 16:25
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoDetailModule implements VideoDetailContract.Module {
    private Context mContext = LiveApplication.getLiveApplication();

    @Override
    public VideoDetailContract.View getView() {
        return null;
    }

    @Override
    public void getRecVideoList(String cd1, String cd2, int offset, int limit, @NonNull final VideoDetailPresenter.onRecVideoListListener listListener) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.getSystemType());
        wrapper.putParams("aid",SystemType.ANDROID.getSystemType().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.putParams("cid1",cd1);
        wrapper.putParams("cid2",cd2);
        wrapper.putParams("offset",offset);
        wrapper.putParams("limit",limit);
        wrapper.setUrl(VideoApi.GET_REC_VIDEO_LIST);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<RecVideoList>() {
            @Override
            public void onFailure(Call call, IOException e) {
                listListener.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, RecVideoList data) throws IOException {
                listListener.onRecVideoList(data);
            }
        });
    }
}
