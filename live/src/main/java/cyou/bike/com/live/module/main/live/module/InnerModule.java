package cyou.bike.com.live.module.main.live.module;

import android.content.Context;

import com.vondear.rxtools.view.RxToast;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.live.bean.InnerColumnDetailBean;
import cyou.bike.com.live.module.main.live.contract.InnerLiveListContract;
import cyou.bike.com.live.module.main.live.presenter.InnerPresenter;
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
 * on 2017/12/17 11:43
 * Email: anlonglong0721@gmail.com
 */

public class InnerModule implements InnerLiveListContract.Module {

    private Context mContext = LiveApplication.getLiveApplication();
    InnerLiveListContract.View mView;

    public InnerModule(InnerLiveListContract.View view) {
        mView = view;
    }

    @Override
    public InnerLiveListContract.View getView() {
        return (InnerLiveListContract.View) InstanceProxy.getInstance().getPresenter(InnerPresenter.class).getView();
    }

    @Override
    public void getColumnDetail(String shortName) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.putParams("shortName",shortName);
        wrapper.setUrl(HomeApi.LIVE_COLUMN_LIST_DETAIL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<InnerColumnDetailBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                getView().onErro(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, InnerColumnDetailBean data) throws IOException {
                InnerLiveListContract.View view = mView;
                if (null != view) {
                    view.onSuccess();
                    view.onColumnDetail(data);
                } else {
                    RxToast.error(getClass().getName() + "is null");
                    LogUtil.i("InnerModule", getClass().getName() + "is null");
                }
            }
        });
    }
}
