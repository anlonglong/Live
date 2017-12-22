package cyou.bike.com.live.module.main.home.presenter;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.annotation.DefSystemType;
import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.bean.CateListBean;
import cyou.bike.com.live.module.main.home.contract.HomeContract;
import cyou.bike.com.live.module.main.home.module.HomeModule;
import cyou.bike.com.live.net.api.home.HomeApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/10/31 23:13
 * Email: anlonglong0721@gmail.com
 */

public class HomePresenter implements HomeContract.Presenter {


    private HomeContract.View mView;
    private BaseModule mModule;
    private Context mContext = LiveApplication.getLiveApplication();

    public HomePresenter() {

    }


    @Override
    public HomeContract.View getView() {
        return mView;
    }

    @Override
    public HomeModule getModule() {
        return null;
    }

    @Override
    public void attach(HomeContract.View view) {
        this.mView = view;
    }

    @Override
    public void detattch() {
        this.mView = null;
    }

    @Override
    public boolean isAttach() {
        return mView != null;
    }

    @Override
    public void getCateList(int limit, @DefSystemType SystemType sysType, int offset) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.setUrl(HomeApi.CATELIST_URL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<CateListBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                HttpFail(e);
            }

            @Override
            public void onResponse(Call call, Response response, CateListBean data) throws IOException {
                if (isAttach()) {
                    //Toast.makeText(LiveApplication.getLiveApplication(), data.toString(), Toast.LENGTH_SHORT).show();
                    mView.onSuccess();
                    mView.onCateListSuccess(data);
                }
            }
        });

    }

    private void HttpFail(IOException e) {
        if (isAttach()) {
            mView.onErro(e.getMessage());
        }
    }

}
