package cyou.bike.com.live.module.main.video.presenter;/**
 * Created by anlonglong on 2017/12/23.
 */

import java.util.List;

import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.bean.VideoHomeCate;
import cyou.bike.com.live.module.main.video.callback.VideoResponseListener;
import cyou.bike.com.live.module.main.video.contract.VideoContract;
import cyou.bike.com.live.module.main.video.fragment.VideoFragment;
import cyou.bike.com.live.module.main.video.module.VideoModule;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 15:59
 * <p>
 * Desc: null
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoPresenter implements VideoContract.Presenter {

    private VideoContract.View mView;
    private VideoContract.Module mModule;

    @Override
    public VideoContract.View getView() {
        return mView;
    }

    @Override
    public VideoContract.Module getModule() {
        if (null == mModule) {
            mModule = InstanceProxy.getInstance().getModule(VideoModule.class);
        }
        return mModule;
    }

    @Override
    public void attach(VideoContract.View view) {
      this.mView = view;
    }

    @Override
    public void detattch() {
     this.mView =null;
    }

    @Override
    public boolean isAttach() {
        return this.mView != null;
    }

    @Override
    public void getVideoHomeCate1() {
       getModule().getVideoHomeCate1(new VideoResponseListener.VideoHomeCate1Listener() {
           @Override
           public void onGetVideoHomeCate1Listener(List<VideoHomeCate.DataBean> datas) {
               mView.onGetVideoHomeCate1(datas);
           }

           @Override
           public void onFail(String msg) {
               mView.onErro(msg);
           }
       });
    }
}
