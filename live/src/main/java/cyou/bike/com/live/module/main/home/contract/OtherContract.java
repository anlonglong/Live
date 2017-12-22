package cyou.bike.com.live.module.main.home.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.home.bean.CateListBean;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.module.main.home.bean.HotRoomBean;

/**
 * Created by：anlonglong
 * on 2017/12/7 17:50
 * Email: anlonglong0721@gmail.com
 */

public interface OtherContract {

    public interface Presenter extends BasePresenter<View,Module> {
        void getOtherList(String identification);
    }

    public interface View extends BaseView<Presenter> {
        void onOtherList(HotCateBean data);
    }

    public interface Module extends BaseModule<View> {
        void getOtherList(String identification);
    }
}
