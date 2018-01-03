package cyou.bike.com.live.module.main.video.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.video.bean.RecVideoList;
import cyou.bike.com.live.module.main.video.presenter.VideoDetailPresenter;

/**
 * Created by anlonglong on 2017/12/29.
 */
public interface VideoDetailContract {
    interface Presenter extends BasePresenter<View,Module> {
        void getRecVideoList(String cd1,String cd2,int offset,int limit);
    }

    interface View extends BaseView<Presenter> {
        void onRecVideoList(RecVideoList detailBean);
    }

    interface Module extends BaseModule<View> {
        void getRecVideoList(String cd1,String cd2,int offset,int limit,VideoDetailPresenter.onRecVideoListListener listListener);
    }
}
