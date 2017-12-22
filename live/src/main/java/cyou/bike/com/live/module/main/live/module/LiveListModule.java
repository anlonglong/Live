package cyou.bike.com.live.module.main.live.module;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.live.bean.ColumnListIndicatorBean;
import cyou.bike.com.live.module.main.live.contract.LiveListIndicatorContract;
import cyou.bike.com.live.module.main.live.presenter.LiveListPresenter;
import cyou.bike.com.live.net.api.home.HomeApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/12/16 15:25
 * Email: anlonglong0721@gmail.com
 */

public class LiveListModule implements LiveListIndicatorContract.Module {
    private Context mContext = LiveApplication.getLiveApplication();
    @Override
    public LiveListIndicatorContract.View getView() {
        return (LiveListIndicatorContract.View) InstanceProxy.getInstance().getPresenter(LiveListPresenter.class).getView();
    }

    @Override
    public void getColumnList() {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.setUrl(HomeApi.LIVE_COLUMN_LIST_URL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<ColumnListIndicatorBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                getView().onErro(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, ColumnListIndicatorBean data) throws IOException {
                getView().onSuccess();
                getView().onColumnList(data);
            }
        });
    }
}
