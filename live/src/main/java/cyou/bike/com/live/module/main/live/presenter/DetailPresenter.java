package cyou.bike.com.live.module.main.live.presenter;

import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.live.bean.DetailBean;
import cyou.bike.com.live.module.main.live.contract.DetailContract;
import cyou.bike.com.live.module.main.live.module.DetailModule;

/**
 * Created by：anlonglong
 * on 2017/12/17 12:33
 * Email: anlonglong0721@gmail.com
 */

public class DetailPresenter implements DetailContract.Presenter {
    private DetailContract.View mView;

    @Override
    public DetailContract.View getView() {
        return this.mView;
    }

    @Override
    public DetailContract.Module getModule() {
        return new DetailModule(mView);
    }

    @Override
    public void attach(DetailContract.View view) {
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
    public void getDetail(String tagId,int offset,int limit) {
    getModule().getDetail(tagId,offset,limit);
    }

}
