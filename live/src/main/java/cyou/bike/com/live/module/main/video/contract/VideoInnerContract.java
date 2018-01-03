package cyou.bike.com.live.module.main.video.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.video.bean.VideoCate2;
import cyou.bike.com.live.module.main.video.presenter.VideoInnerPresenter;

/**
 * Created by：anlonglong
 * on 2017/12/17 11:32
 * Email: anlonglong0721@gmail.com
 */

public interface VideoInnerContract {

    interface Presenter extends BasePresenter<View,Module> {
        void getVideoCate2(String cid);
    }

    interface View extends BaseView<Presenter> {
        void onVideoCate2(VideoCate2 detailBean);
    }

    interface Module extends BaseModule<View> {
        void getVideoCate2(String cid,VideoInnerPresenter.VideoCate2Listener listener);
    }

}
