package cyou.bike.com.live.module.main.video.presenter;/**
 * Created by anlonglong on 2017/12/29.
 */

import cyou.bike.com.live.module.main.video.bean.RecVideoList;
import cyou.bike.com.live.module.main.video.contract.VideoDetailContract;
import cyou.bike.com.live.module.main.video.module.VideoDetailModule;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/29 at 16:26
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoDetailPresenter implements VideoDetailContract.Presenter {
    private VideoDetailContract.View mView;

    @Override
    public VideoDetailContract.View getView() {
        return mView;
    }

    @Override
    public VideoDetailContract.Module getModule() {
        return new VideoDetailModule();
    }

    @Override
    public void attach(VideoDetailContract.View view) {
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
    public void getRecVideoList(String cd1, String cd2, int offset, int limit) {
         getModule().getRecVideoList(cd1, cd2, offset, limit, new onRecVideoListListener() {
             @Override
             public void onRecVideoList(RecVideoList detailBean) {
                 mView.onRecVideoList(detailBean);
             }

             @Override
             public void onError(String msg) {
                mView.onErro(msg);
             }
         });
    }

    public interface onRecVideoListListener {
        void onRecVideoList(RecVideoList detailBean);

        void onError(String msg);
    }
}
