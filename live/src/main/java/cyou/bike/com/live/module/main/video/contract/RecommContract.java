package cyou.bike.com.live.module.main.video.contract;

import java.util.List;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.callback.VideoResponseListener;

/**
 * Created by anlonglong on 2017/12/23.
 */
public interface RecommContract {
    interface Presenter extends BasePresenter<View,Module> {
        void getHotVideoList1();
        void getCateHotVideoList1();
        void getHotAuthors();
    }

    interface View extends BaseView <Presenter>{
        void onGetHotVideoList1(List<HotVideoList.DataBean> datas,HotVideoList hotVideoList);
        void onGetCateHotVideoList1(List<CateHotVideoList.DataBean> datas,CateHotVideoList cateHotVideoList);
        void onGetHotAuthors(List<HotAuthors.DataBean> datas,HotAuthors hotAuthors);
    }

    interface Module extends BaseModule<View> {
        void getHotVideoList1(VideoResponseListener.HotVideoList1Listener listener);
        void getCateHotVideoList1(VideoResponseListener.CateHotVideoList1Listener listener);
        void getHotAuthors(VideoResponseListener.HotAuthorsListener listener);
    }
}

