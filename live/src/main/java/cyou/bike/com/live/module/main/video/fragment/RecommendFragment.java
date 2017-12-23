package cyou.bike.com.live.module.main.video.fragment;/**
 * Created by anlonglong on 2017/12/23.
 */

import android.os.Bundle;
import android.view.View;

import java.util.List;

import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.contract.RecommContract;
import cyou.bike.com.live.module.main.video.presenter.RecommPresenter;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 16:02
 * <p>
 * Desc: 推荐
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class RecommendFragment extends BaseFragment<RecommPresenter> implements RecommContract.View{

    private RecommPresenter mPresenter;

    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void loadData(View view) {
        mPresenter = (RecommPresenter) getPresenter();
        if (null != mPresenter) {
            mPresenter.attach(this);
            mPresenter.getCateHotVideoList1();
            mPresenter.getHotVideoList1();
            mPresenter.getHotAuthors();
        }
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.video_recomm_fragment;
    }

    @Override
    protected void detach() {
        if (null != mPresenter) {
            mPresenter.detattch();
        }
    }

    public static RecommendFragment newInstance() {

        Bundle args = new Bundle();
        RecommendFragment fragment = new RecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onErro(String msg) {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onGetHotVideoList1(List<HotVideoList.DataBean> datas) {

    }

    @Override
    public void onGetCateHotVideoList1(List<CateHotVideoList.DataBean> datas) {

    }

    @Override
    public void onGetHotAuthors(List<HotAuthors.DataBean> datas) {

    }
}
