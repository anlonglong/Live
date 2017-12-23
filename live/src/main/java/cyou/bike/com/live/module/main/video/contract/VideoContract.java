package cyou.bike.com.live.module.main.video.contract;/**
 * Created by anlonglong on 2017/12/23.
 */

import java.util.List;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.bean.VideoHomeCate;
import cyou.bike.com.live.module.main.video.callback.VideoResponseListener;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 15:40
 * <p>
 * Desc: 视频模块
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public interface VideoContract {
    interface View extends BaseView<Presenter> {
        //
        void onGetVideoHomeCate1(List<VideoHomeCate.DataBean> datas);
    }

    interface Presenter extends BasePresenter<View,Module> {
        void getVideoHomeCate1();
    }

    interface Module extends BaseModule {
        void getVideoHomeCate1(VideoResponseListener.VideoHomeCate1Listener listener);
    }
 }
