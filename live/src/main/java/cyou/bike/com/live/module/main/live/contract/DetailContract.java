package cyou.bike.com.live.module.main.live.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.live.bean.DetailBean;

/**
 * Created by：anlonglong
 * on 2017/12/17 12:19
 * Email: anlonglong0721@gmail.com
 */

public interface DetailContract {

    interface Presenter extends BasePresenter<View,Module> {
          void getDetail(String tagId,int offset,int limit);
    }

    interface View extends BaseView<Presenter> {
           void onDetail(DetailBean detailBean);
    }

    interface Module extends BaseModule<View> {
        void getDetail(String tagId,int offset,int limit);
    }

}
