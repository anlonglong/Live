package cyou.bike.com.live.module.videocontroller.cellphonelive;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;

/**
 * Created by：anlonglong
 * on 2017/12/1 09:38
 * Email: anlonglong0721@gmail.com
 */

public interface CellPhoneContract {

   public interface Presenter extends BasePresenter<CellPhoneContract.View,CellPhoneContract.Model>{
        void getLiveVideoInfo(String roomId);
    }

    public interface View extends BaseView<CellPhoneContract.Presenter> {
        void onLiveVideoInfoSuccess(LivePathBean data);
    }

   public interface Model extends BaseModule<CellPhoneContract.View> {
        void getLiveVideoInfo(String roomId);
    }



}
