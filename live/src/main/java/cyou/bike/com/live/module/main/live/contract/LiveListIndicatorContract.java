package cyou.bike.com.live.module.main.live.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.live.bean.ColumnListIndicatorBean;

/**
 * Created by：anlonglong
 * on 2017/12/16 15:15
 * Email: anlonglong0721@gmail.com
 */

public interface LiveListIndicatorContract {

    interface Presenter extends BasePresenter<View,Module>{
         void getColumnList();
    }

    interface View extends BaseView<Presenter> {
         void onColumnList(ColumnListIndicatorBean data);
    }

    interface Module extends BaseModule<View> {
        void getColumnList();
    }

}
