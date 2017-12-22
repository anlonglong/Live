package cyou.bike.com.live.module.main.home.contract;

import cyou.bike.com.live.annotation.DefSystemType;
import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.bean.CateListBean;

/**
 * Created by：anlonglong
 * on 2017/10/31 21:33
 * Email: anlonglong0721@gmail.com
 */

public interface HomeContract {

    interface Presenter extends BasePresenter<View,HomeMoudle> {
        void getCateList(int limit, @DefSystemType SystemType sysType, int offset);
    }

    public interface View extends BaseView<Presenter> {
        void onCateListSuccess(CateListBean data);

    }

    public interface HomeMoudle extends BaseModule<View> {
        void getCateList(int limit, @DefSystemType SystemType sysType, int offset);
        //aid=android1&client_sys=android&identification=3e760da75be261a588c74c4830632360&time=1480493599&auth=b455ecdc27fd82acc4f5ed771d015a3d
    }


}
