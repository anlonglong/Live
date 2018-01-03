package cyou.bike.com.live.module.main.video.presenter;/**
 * Created by anlonglong on 2017/12/31.
 */

import cyou.bike.com.live.module.main.video.contract.AuthorListContract;
import cyou.bike.com.live.module.main.video.module.AuthorListModule;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/31 at 11:33
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class AuthorListPresenter implements AuthorListContract.Presenter {
    private AuthorListContract.View mView;

    @Override
    public AuthorListContract.View getView() {
        return mView;
    }

    @Override
    public AuthorListContract.Module getModule() {
        return new AuthorListModule(mView);
    }

    @Override
    public void attach(AuthorListContract.View view) {
      this.mView = view;
    }

    @Override
    public void detattch() {
        mView =null;
    }

    @Override
    public boolean isAttach() {
        return mView != null;
    }

    @Override
    public void getAuthorVidList(String upId,int offset,int limit) {
    getModule().getAuthorVidList(upId,offset,limit);
    }

}
