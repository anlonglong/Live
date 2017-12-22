package cyou.bike.com.live.module.main.home.presenter;

import android.text.TextUtils;
import android.widget.TextView;

import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.home.contract.OtherContract;
import cyou.bike.com.live.module.main.home.module.OtherModule;

/**
 * Created by：anlonglong
 * on 2017/12/8 09:51
 * Email: anlonglong0721@gmail.com
 */

public class OtherPresenter implements OtherContract.Presenter {

    private OtherContract.View mView;

    @Override
    public OtherContract.View getView() {
        return mView;
    }

    @Override
    public OtherContract.Module getModule() {
        return InstanceProxy.getInstance().getModule(OtherModule.class);
    }

    @Override
    public void attach(OtherContract.View view) {
        this.mView = view;
    }

    @Override
    public void detattch() {
        this.mView = null;
    }

    @Override
    public boolean isAttach() {
        return mView != null;
    }

    @Override
    public void getOtherList(String identification) {
        if (!TextUtils.isEmpty(identification)) {
            getModule().getOtherList(identification);
        }
    }
}
