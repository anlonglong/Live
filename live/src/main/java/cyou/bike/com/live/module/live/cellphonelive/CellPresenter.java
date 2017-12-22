package cyou.bike.com.live.module.live.cellphonelive;

import android.text.TextUtils;

import com.vondear.rxtools.view.RxToast;

import cyou.bike.com.live.module.main.home.InstanceProxy;

/**
 * Created by：anlonglong
 * on 2017/12/4 10:04
 * Email: anlonglong0721@gmail.com
 */

public class CellPresenter implements CellPhoneContract.Presenter {
    CellPhoneContract.View mView;

    @Override
    public CellPhoneContract.View getView() {
        return mView;
    }

    @Override
    public CellPhoneContract.Model getModule() {
        return InstanceProxy.getInstance().getModule(CellModel.class);
    }

    @Override
    public void attach(CellPhoneContract.View view) {
       this.mView = view;
    }

    @Override
    public void detattch() {
      this.mView = null;
    }

    @Override
    public boolean isAttach() {
        return this.mView != null;
    }

    @Override
    public void getLiveVideoInfo(String roomId) {
           if (!TextUtils.isEmpty(roomId) || TextUtils.isDigitsOnly(roomId)) {
               getModule().getLiveVideoInfo(roomId);
           } else {
               RxToast.error("roomId包含非法字符");
           }
    }
}
