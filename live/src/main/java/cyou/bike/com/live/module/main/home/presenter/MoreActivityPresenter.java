package cyou.bike.com.live.module.main.home.presenter;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.contract.MoreContract;
import cyou.bike.com.live.module.main.home.module.MoreActivityModule;

/**
 * Created by：anlonglong
 * on 2017/12/13 22:24
 * Email: anlonglong0721@gmail.com
 */

public class MoreActivityPresenter implements MoreContract.ActivityContract.Presenter {
    private MoreContract.ActivityContract.View mView;

    @Override
    public MoreContract.ActivityContract.View getView() {
        return mView;
    }

    @Override
    public MoreContract.ActivityContract.Module getModule() {
        return InstanceProxy.getInstance().getModule(MoreActivityModule.class);
    }

    @Override
    public void attach(MoreContract.ActivityContract.View view) {
        mView = view;
    }

    @Override
    public void detattch() {
        mView = null;
    }

    @Override
    public boolean isAttach() {
        return mView != null;
    }

    @Override
    public void getThreeCate(String tagId) {
     getModule().getThreeCate(tagId);
    }
}
