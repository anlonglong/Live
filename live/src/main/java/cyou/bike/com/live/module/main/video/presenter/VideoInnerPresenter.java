package cyou.bike.com.live.module.main.video.presenter;/**
 * Created by anlonglong on 2017/12/29.
 */

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.video.bean.VideoCate2;
import cyou.bike.com.live.module.main.video.contract.VideoInnerContract;
import cyou.bike.com.live.module.main.video.module.VideoInnerModule;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/29 at 14:05
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoInnerPresenter implements VideoInnerContract.Presenter {
    private VideoInnerContract.View mView;

    @Override
    public VideoInnerContract.View getView() {
        return mView;
    }

    @Override
    public VideoInnerContract.Module getModule() {
        return new VideoInnerModule();
    }

    @Override
    public void attach(VideoInnerContract.View view) {
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
    public void getVideoCate2(String cid) {
      getModule().getVideoCate2(cid, new VideoCate2Listener() {
          @Override
          public void onVideoCate2(VideoCate2 detailBean) {
              mView.onVideoCate2(detailBean);
          }

          @Override
          public void onError(String msg) {
              mView.onErro(msg);
          }
      });
    }


    public interface VideoCate2Listener {
        void onVideoCate2(VideoCate2 detailBean);
        void onError(String msg);
    }
}
