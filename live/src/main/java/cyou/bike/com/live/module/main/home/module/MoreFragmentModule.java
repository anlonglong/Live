package cyou.bike.com.live.module.main.home.module;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.bean.ThreeCateData;
import cyou.bike.com.live.module.main.home.contract.MoreContract;
import cyou.bike.com.live.module.main.home.presenter.MoreFragmentPresenter;
import cyou.bike.com.live.net.api.home.HomeApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/12/16 12:42
 * Email: anlonglong0721@gmail.com
 */

public class MoreFragmentModule implements MoreContract.fragmentContract.Module {

    private Context mContext = LiveApplication.getLiveApplication();

    @Override
    public MoreContract.fragmentContract.View getView() {
        return (MoreContract.fragmentContract.View) InstanceProxy.getInstance().getPresenter(MoreFragmentPresenter.class).getView();
    }

    @Override
    public void getThreeCateData(String tagId, int offset, int limit) {
        RequestWrapper requestWrapper = new RequestWrapper(mContext);
        requestWrapper.putParams("client_sys", SystemType.ANDROID.name());
        requestWrapper.putParams("aid", SystemType.ANDROID.name().concat("l"));
        requestWrapper.putParams("time", String.valueOf(System.currentTimeMillis()));
        requestWrapper.putParams("offset", String.valueOf(offset));
        requestWrapper.putParams("limit", String.valueOf(limit));
        requestWrapper.setUrl(HomeApi.THREDE_CATA_DATA_URL+tagId);
        DYHttpRequest.getRequest().setRequestWrapper(requestWrapper).doRequest(HttpMethod.GET, new HttpListener<ThreeCateData>() {
            @Override
            public void onFailure(Call call, IOException e) {
                getView().onErro(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, ThreeCateData data) throws IOException {
                getView().onSuccess();
                getView().onThreeCateData(data);
            }
        });
    }
}
