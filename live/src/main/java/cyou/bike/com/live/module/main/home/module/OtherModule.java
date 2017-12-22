package cyou.bike.com.live.module.main.home.module;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.bean.CateListBean;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.module.main.home.contract.OtherContract;
import cyou.bike.com.live.module.main.home.fragment.OtherFragemnt;
import cyou.bike.com.live.net.api.home.HomeApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/12/8 09:50
 * Email: anlonglong0721@gmail.com
 */

public class OtherModule implements OtherContract.Module {


    private Context mContext  = LiveApplication.getLiveApplication();

    @Override
    public OtherContract.View getView() {
        return (OtherContract.View) InstanceProxy.getInstance().getPresenter(OtherFragemnt.class).getView();
    }

    @Override
    public void getOtherList(String identification) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("|"));
        wrapper.putParams("time",String.valueOf(System.currentTimeMillis()));
        wrapper.putParams("identification",identification);
        wrapper.setUrl(HomeApi.OTHER_URL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<HotCateBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
              getView().onErro(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, HotCateBean data) throws IOException {
                getView().onSuccess();
                getView().onOtherList(data);
            }
        });
    }
}
