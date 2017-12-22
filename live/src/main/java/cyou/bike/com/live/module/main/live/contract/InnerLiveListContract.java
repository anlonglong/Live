package cyou.bike.com.live.module.main.live.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.live.bean.InnerColumnDetailBean;

/**
 * Created by：anlonglong
 * on 2017/12/17 11:32
 * Email: anlonglong0721@gmail.com
 */

public interface InnerLiveListContract {

    interface Presenter extends BasePresenter<View,Module> {
        void getColumnDetail(String shortName);
    }

    interface View extends BaseView<Presenter> {
        void onColumnDetail(InnerColumnDetailBean detailBean);
    }

    interface Module extends BaseModule<View> {
        void getColumnDetail(String shortName);
    }

}
