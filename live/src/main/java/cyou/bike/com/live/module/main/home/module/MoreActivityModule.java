package cyou.bike.com.live.module.main.home.module;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.bean.ThreeCate;
import cyou.bike.com.live.module.main.home.bean.ThreeCateData;
import cyou.bike.com.live.module.main.home.contract.MoreContract;
import cyou.bike.com.live.module.main.home.presenter.MoreActivityPresenter;
import cyou.bike.com.live.net.api.home.HomeApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/12/13 22:23
 * Email: anlonglong0721@gmail.com
 */

public class MoreActivityModule implements MoreContract.ActivityContract.Module {

    private Context mContext = LiveApplication.getLiveApplication();


    @Override
    public void getThreeCate(String tagId) {
        //http://capi.douyucdn.cn/api/v1/getThreeCate?client_sys=android&aid=android1&time=1513238996137&tag_id=229
        RequestWrapper requestWrapper = new RequestWrapper(mContext);
        requestWrapper.putParams("client_sys", SystemType.ANDROID.name());
        requestWrapper.putParams("aid", SystemType.ANDROID.name().concat("l"));
        requestWrapper.putParams("time", String.valueOf(System.currentTimeMillis()));
        requestWrapper.putParams("tag_id",tagId);
        requestWrapper.setUrl(HomeApi.THREDE_CATA_URL);
        DYHttpRequest.getRequest().setRequestWrapper(requestWrapper).doRequest(HttpMethod.GET, new HttpListener<ThreeCate>() {
            @Override
            public void onFailure(Call call, IOException e) {
                getView().onErro(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, ThreeCate data) throws IOException {
                getView().onSuccess();
                getView().onThreeCate(data);
            }
        });
    }


    @Override
    public MoreContract.ActivityContract.View getView() {
        return (MoreContract.ActivityContract.View) InstanceProxy.getInstance().getPresenter(MoreActivityPresenter.class).getView();
    }
}
