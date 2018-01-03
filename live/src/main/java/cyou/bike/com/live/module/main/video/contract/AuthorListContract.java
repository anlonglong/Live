package cyou.bike.com.live.module.main.video.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.video.bean.AuthorList;

/**
 * Created by anlonglong on 2017/12/31.
 */
public interface AuthorListContract {


    public interface Presenter extends BasePresenter<View,Module> {
        void getAuthorVidList(String upId,int offset,int limit);
    }

    public interface View extends BaseView<Presenter> {
        void onAuthorList(AuthorList list);
    }


    public interface Module extends BaseModule<View> {
        void getAuthorVidList(String upId,int offset,int limit);
    }
}
