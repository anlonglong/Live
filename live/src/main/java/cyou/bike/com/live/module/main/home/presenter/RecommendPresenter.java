package cyou.bike.com.live.module.main.home.presenter;

import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.contract.RecommendContract;
import cyou.bike.com.live.module.main.home.module.RecommendMoudle;

/**
 * Created by：anlonglong
 * on 2017/11/2 21:15
 * Email: anlonglong0721@gmail.com
 */

public class RecommendPresenter implements RecommendContract.Presenter {

    private RecommendContract.View mView;

    @Override
    public RecommendContract.View getView() {
        return mView;
    }

    @Override
    public RecommendMoudle getModule() {
        return InstanceProxy.getInstance().getModule(RecommendMoudle.class);
    }

    @Override
    public void attach(RecommendContract.View view) {
        this.mView = view;
    }

    @Override
    public void detattch() {
        this.mView = null;
    }


    @Override
    public boolean isAttach() {
        return this.mView != null;
    }

    @Override
    public void getHotRoom(String aid, String identification, String time, String auth) {
        getModule().getHotRoom(aid,identification,time,auth);
    }

    @Override
    public void getBannerList(String version) {
        getModule().getBannerList(version);

    }

    @Override
    public void getHotCate(String aid, String time, String token, String auth) {
        getModule().getHotCate(aid,time,token,auth);

    }

    @Override
    public void getBigDataRoom(String aid, long stampTime, String token, String auth) {
        getModule().getBigDataRoom(aid,stampTime,token,auth);
    }

    @Override
    public void getFaceScoreRoom(int offset, int limit) {
        getModule().getFaceScoreRoom(offset,limit);

    }

}
