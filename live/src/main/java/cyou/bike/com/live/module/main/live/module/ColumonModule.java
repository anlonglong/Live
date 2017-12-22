package cyou.bike.com.live.module.main.live.module;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.live.bean.ColumonListBean;
import cyou.bike.com.live.module.main.live.contract.ColumonListContract;
import cyou.bike.com.live.module.main.live.presenter.ColumonPresenter;
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
 * on 2017/12/16 17:04
 * Email: anlonglong0721@gmail.com
 */

public class ColumonModule implements ColumonListContract.Module {

    private Context mContext = LiveApplication.getLiveApplication();

    @Override
    public ColumonListContract.View getView() {

        return (ColumonListContract.View) InstanceProxy.getInstance().getPresenter(ColumonPresenter.class).getView();
    }

    @Override
    public void getColumonList(int offset, int limit) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.putParams("offset",offset+"");
        wrapper.putParams("limit",limit+"");
        wrapper.setUrl(HomeApi.LIVE_URL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<ColumonListBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                getView().onErro(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, ColumonListBean data) throws IOException {
                ColumonListContract.View view = getView();
                if (null != view) {
                    view.onSuccess();
                    view.onColumonList(data);
                }else {
                    LogUtil.i("",getClass().getName()+"is null");
                }
            }
        });
    }
}
