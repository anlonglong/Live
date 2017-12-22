package cyou.bike.com.live.module.main.home.module;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.bean.BannerBean;
import cyou.bike.com.live.module.main.home.bean.DigDataRoomBean;
import cyou.bike.com.live.module.main.home.bean.FaceScoreBean;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.module.main.home.contract.RecommendContract;
import cyou.bike.com.live.module.main.home.fragment.RecommendFragment;
import cyou.bike.com.live.module.main.home.presenter.RecommendPresenter;
import cyou.bike.com.live.net.api.home.HomeApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/11/2 21:20
 * Email: anlonglong0721@gmail.com
 */

public class RecommendMoudle implements RecommendContract.RecommendMoudle {

    private Context mContext = LiveApplication.getLiveApplication();


    @Override
    public void getHotRoom(String aid, String identification, String time, String auth) {

    }

    @Override
    public void getBannerList(String version) {
        RequestWrapper requestWrapper = new RequestWrapper(mContext);
        requestWrapper.putParams("version", version);
        requestWrapper.putParams("client_sys", SystemType.ANDROID.getSystemType());
        requestWrapper.setUrl(HomeApi.BANNER_URL);
        DYHttpRequest.getRequest().setRequestWrapper(requestWrapper).doRequest(HttpMethod.GET, new HttpListener<BannerBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                HttpFail(e);
            }

            @Override
            public void onResponse(Call call, Response response, BannerBean data) throws IOException {
                //Toast.makeText(mContext, data.toString(), Toast.LENGTH_SHORT).show();
                getView().onSuccess();
                getView().onBannerListSuccess(data);
            }
        });
    }

    @Override
    public void getHotCate(String aid, String time, String token, String auth) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("aid", aid);
        wrapper.putParams("time", time);
        wrapper.putParams("token", token);
        wrapper.putParams("auth", auth);
        wrapper.setUrl(HomeApi.HOt_CATE_URL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<HotCateBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                HttpFail(e);
            }

            @Override
            public void onResponse(Call call, Response response, HotCateBean data) throws IOException {
                //Toast.makeText(mContext, data.toString(), Toast.LENGTH_SHORT).show();
                getView().onSuccess();
                getView().onHotCate(data);

            }
        });
    }

    @Override
    public void getBigDataRoom(String aid, long stampTime, String token, String auth) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("aid", aid);
        wrapper.putParams("time", String.valueOf(stampTime));
        wrapper.putParams("token", token);
        wrapper.putParams("auth", auth);
        wrapper.setUrl(HomeApi.RECOMMEND_HOT_URL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<DigDataRoomBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                HttpFail(e);
            }

            @Override
            public void onResponse(Call call, Response response, DigDataRoomBean data) throws IOException {
                getView().onDigDataRoomSuccess(data);
            }
        });
    }

    @Override
    public void getFaceScoreRoom(int offset, int limit) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("offet", String.valueOf(offset));
        wrapper.putParams("limit", String.valueOf(limit));
        wrapper.setUrl(HomeApi.FACE_SCORE_URL);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<FaceScoreBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                HttpFail(e);
            }

            @Override
            public void onResponse(Call call, Response response, FaceScoreBean data) throws IOException {
                getView().onFaceScore(data);
            }
        });
    }

    @Override
    public RecommendContract.View getView() {
        return (RecommendContract.View) InstanceProxy.getInstance().getPresenter(RecommendPresenter.class).getView();
    }

    private void HttpFail(IOException e) {
        getView().onErro(e.getMessage());
    }
}
