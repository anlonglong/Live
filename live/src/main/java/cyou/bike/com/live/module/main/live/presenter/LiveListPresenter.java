package cyou.bike.com.live.module.main.live.presenter;

import cyou.bike.com.live.module.main.live.contract.LiveListIndicatorContract;
import cyou.bike.com.live.module.main.live.module.LiveListModule;

/**
 * Created by：anlonglong
 * on 2017/12/16 15:25
 * Email: anlonglong0721@gmail.com
 */

public class LiveListPresenter implements LiveListIndicatorContract.Presenter {
    private LiveListIndicatorContract.View mView;

    @Override
    public LiveListIndicatorContract.View getView() {
        return this.mView;
    }

    @Override
    public LiveListIndicatorContract.Module getModule() {
        return new LiveListModule();
    }

    @Override
    public void attach(LiveListIndicatorContract.View view) {
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
    public void getColumnList() {
       getModule().getColumnList();
    }
}
