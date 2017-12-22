package cyou.bike.com.live.module.main.live.presenter;

import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.live.contract.ColumonListContract;
import cyou.bike.com.live.module.main.live.module.ColumonModule;

/**
 * Created by：anlonglong
 * on 2017/12/16 17:05
 * Email: anlonglong0721@gmail.com
 */

public class ColumonPresenter implements ColumonListContract.Presenter {


    private ColumonListContract.View mView;

    @Override
    public ColumonListContract.View getView() {
        return mView;
    }

    @Override
    public ColumonListContract.Module getModule() {
        return InstanceProxy.getInstance().getModule(ColumonModule.class);
    }

    @Override
    public void attach(ColumonListContract.View view) {
             this.mView = view;
    }

    @Override
    public void detattch() {
        mView =null;
    }

    @Override
    public boolean isAttach() {
        return mView != null;
    }

    @Override
    public void getColumonList(int offset, int limit) {
    getModule().getColumonList(offset,limit);
    }
}
