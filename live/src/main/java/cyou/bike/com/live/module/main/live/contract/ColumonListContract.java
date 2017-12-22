package cyou.bike.com.live.module.main.live.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.live.bean.ColumonListBean;

/**
 * Created by：anlonglong
 * on 2017/12/16 16:56
 * Email: anlonglong0721@gmail.com
 */

public interface ColumonListContract {
    //http://capi.douyucdn.cn/api/v1/live?client_sys=android&aid=android1&time=1513414732430&offset=0&limit=20


    interface Presenter extends BasePresenter<View,Module> {

        void getColumonList(int offset, int limit);

    }

    interface View extends BaseView<Presenter> {
        void onColumonList(ColumonListBean data);
    }

    interface Module extends BaseModule<View> {
        void getColumonList(int offset, int limit);
    }


}
