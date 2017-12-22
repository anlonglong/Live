package cyou.bike.com.live.module.main.home.presenter;

import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.contract.MoreContract;
import cyou.bike.com.live.module.main.home.module.MoreFragmentModule;

/**
 * Created by：anlonglong
 * on 2017/12/16 12:43
 * Email: anlonglong0721@gmail.com
 */

public class MoreFragmentPresenter implements MoreContract.fragmentContract.Presenter {
    private MoreContract.fragmentContract.View mView;

    @Override
    public MoreContract.fragmentContract.View getView() {
        return mView;
    }

    @Override
    public MoreContract.fragmentContract.Module getModule() {
        return InstanceProxy.getInstance().getModule(MoreFragmentModule.class);
    }

    @Override
    public void attach(MoreContract.fragmentContract.View view) {
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
    public void getThreeCateData(String tagId, int offset, int limit) {
        getModule().getThreeCateData(tagId, offset, limit);
    }
}
