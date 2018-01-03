package cyou.bike.com.live.module.main.video.presenter;/**
 * Created by anlonglong on 2017/12/23.
 */

import java.util.List;

import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.callback.VideoResponseListener;
import cyou.bike.com.live.module.main.video.contract.RecommContract;
import cyou.bike.com.live.module.main.video.module.RecommModule;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 17:45
 * <p>
 * Desc: null
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class RecommPresenter implements RecommContract.Presenter {
    private RecommContract.View mView;
    private RecommContract.Module mModule;

    @Override
    public RecommContract.View getView() {
        return mView;
    }

    @Override
    public RecommContract.Module getModule() {
        if (null == mModule) {
            mModule = InstanceProxy.getInstance().getModule(RecommModule.class);
        }
        return mModule;
    }

    @Override
    public void attach(RecommContract.View view) {
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
    public void getHotVideoList1() {
        getModule().getHotVideoList1(new VideoResponseListener.HotVideoList1Listener() {
            @Override
            public void onGetHotVideoList1Listener(List<HotVideoList.DataBean> datas,HotVideoList hotVideoList) {
                mView.onGetHotVideoList1(datas,hotVideoList);
            }

            @Override
            public void onFail(String msg) {
                mView.onErro(msg);
            }
        });
    }

    @Override
    public void getCateHotVideoList1() {
        getModule().getCateHotVideoList1(new VideoResponseListener.CateHotVideoList1Listener() {
            @Override
            public void onGetCateHotVideoList1Listener(List<CateHotVideoList.DataBean> datas,CateHotVideoList cateHotVideoList) {
                mView.onGetCateHotVideoList1(datas,cateHotVideoList);
            }

            @Override
            public void onFail(String msg) {
                mView.onErro(msg);
            }
        });
    }

    @Override
    public void getHotAuthors() {
        getModule().getHotAuthors(new VideoResponseListener.HotAuthorsListener() {
            @Override
            public void onGetHotAuthorsListener(List<HotAuthors.DataBean> datas,HotAuthors hotAuthors) {
                mView.onGetHotAuthors(datas,hotAuthors);
            }

            @Override
            public void onFail(String msg) {
                mView.onErro(msg);
            }
        });
    }
}
