package cyou.bike.com.live.module.main.live.presenter;

import javax.xml.transform.sax.SAXSource;

import cyou.bike.com.live.module.main.live.contract.InnerLiveListContract;
import cyou.bike.com.live.module.main.live.module.InnerModule;

/**
 * Created by：anlonglong
 * on 2017/12/17 11:44
 * Email: anlonglong0721@gmail.com
 */

public class InnerPresenter implements InnerLiveListContract.Presenter {
    private InnerLiveListContract.View mView;

    @Override
    public InnerLiveListContract.View getView() {
        return mView;
    }

    @Override
    public InnerLiveListContract.Module getModule() {
        return new InnerModule(mView);
    }

    @Override
    public void attach(InnerLiveListContract.View view) {
          this.mView = view;
    }

    @Override
    public void detattch() {
        mView = null;
    }

    @Override
    public boolean isAttach() {
        return mView != null;
    }

    @Override
    public void getColumnDetail(String shortName) {
      getModule().getColumnDetail(shortName);
    }
}
