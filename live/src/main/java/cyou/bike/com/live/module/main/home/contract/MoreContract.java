package cyou.bike.com.live.module.main.home.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.home.bean.ThreeCate;
import cyou.bike.com.live.module.main.home.bean.ThreeCateData;

/**
 * Created by：anlonglong
 * on 2017/12/13 22:15
 * Email: anlonglong0721@gmail.com
 */

public interface MoreContract {


    public interface ActivityContract {
        interface Presenter extends BasePresenter<View,Module> {
            void getThreeCate(String tagId);
        }

        interface View extends BaseView<Presenter> {
            void onThreeCate(ThreeCate data);
        }

        interface Module extends BaseModule<View> {
            void getThreeCate(String tagId);
        }

    }

    public interface fragmentContract {
        interface Presenter extends BasePresenter<View,Module> {
            void getThreeCateData(String tagId, int offset, int limit);
        }

        interface View extends BaseView<Presenter> {
            void onThreeCateData(ThreeCateData data);
        }

        interface Module extends BaseModule<View> {
            void getThreeCateData(String tagId, int offset, int limit);
        }
    }

}
