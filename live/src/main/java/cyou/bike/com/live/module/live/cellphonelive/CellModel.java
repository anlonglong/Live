package cyou.bike.com.live.module.live.cellphonelive;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.net.api.home.HomeApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import cyou.bike.com.live.utils.LogUtil;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/12/4 10:06
 * Email: anlonglong0721@gmail.com
 */

public class CellModel implements CellPhoneContract.Model {

    public static final String TAG = "CellModel";

    private  final Context mCtx = LiveApplication.getLiveApplication();

    @Override
    public CellPhoneContract.View getView() {
        return (CellPhoneContract.View) InstanceProxy.getInstance().getPresenter(CellPresenter.class).getView();
    }

    @Override
    public void getLiveVideoInfo(String roomId) {
        RequestWrapper requestWrapper = new RequestWrapper(mCtx);
        requestWrapper.putParams("roomId",roomId);
        requestWrapper.setUrl(HomeApi.VIDEO_URL);
        DYHttpRequest.getRequest().setRequestWrapper(requestWrapper).doRequest(HttpMethod.GET, new HttpListener<LivePathBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.e(TAG,e.getMessage(),e);
            }

            @Override
            public void onResponse(Call call, Response response, LivePathBean data) throws IOException {
               getView().onLiveVideoInfoSuccess(data);
            }
        });
    }
}
