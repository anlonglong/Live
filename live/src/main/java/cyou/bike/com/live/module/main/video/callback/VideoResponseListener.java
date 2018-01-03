package cyou.bike.com.live.module.main.video.callback;

import java.util.List;

import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.bean.VideoHomeCate;

/**
 * Created by anlonglong on 2017/12/23.
 */
public interface VideoResponseListener<T> {
    /**
     *
     * @param data 实际要得到的数据载体bean的类型
     */
    void onResponse(T data);
    void onFail(String msg);

    interface VideoHomeCate1Listener {

        void onGetVideoHomeCate1Listener(List<VideoHomeCate.DataBean> datas);
        void onFail(String msg);
    }

    interface HotVideoList1Listener {

        void onGetHotVideoList1Listener(List<HotVideoList.DataBean> datas,HotVideoList hotVideoList);
        void onFail(String msg);
    }

    interface CateHotVideoList1Listener {

        void onGetCateHotVideoList1Listener(List<CateHotVideoList.DataBean> datas,CateHotVideoList cateHotVideoList);
        void onFail(String msg);
    }

    interface HotAuthorsListener {

        void onGetHotAuthorsListener(List<HotAuthors.DataBean> datas,HotAuthors hotAuthors);
        void onFail(String msg);
    }


}
