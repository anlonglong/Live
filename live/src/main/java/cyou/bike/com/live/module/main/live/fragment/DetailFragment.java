package cyou.bike.com.live.module.main.live.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.live.adapter.DetailAdapter;
import cyou.bike.com.live.module.main.live.annotation.ViewCreator;
import cyou.bike.com.live.module.main.live.bean.DetailBean;
import cyou.bike.com.live.module.main.live.contract.DetailContract;
import cyou.bike.com.live.module.main.live.presenter.DetailPresenter;

/**
 * Created by：anlonglong
 * on 2017/12/17 12:14
 * Email: anlonglong0721@gmail.com
 */

@ViewCreator(DetailFragment.class)
public class DetailFragment extends BaseFragment<DetailPresenter> implements DetailContract.View {
    private static String TAG_ID = "id";
    @BindView(R.id.detail_recycle_view)
    RecyclerView mDetailRecycleView;
    @BindView(R.id.detailrefreshlayiut)
    SmartRefreshLayout mSrefreshlayiut;
    private String mTagId;
    private DetailPresenter mPresentfer;

    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void loadData(View view) {
        mPresentfer = (DetailPresenter) getPresenter();
        mPresentfer.attach(this);
        mPresentfer.getDetail(mTagId, 0, 20);
    }

    @Override
    public void onDetail(DetailBean detailBean) {
        List<DetailBean.DataBean> details = detailBean.getData();
        mDetailRecycleView.setLayoutManager(new GridLayoutManager(getContext(),2));
        DetailAdapter detailAdapter = new DetailAdapter(details);
        detailAdapter.bindToRecyclerView(mDetailRecycleView);
        detailAdapter.setEmptyView(R.layout.empty_view);
        mDetailRecycleView.setAdapter(detailAdapter);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.detail_fragment;
    }

    @Override
    protected void onFragmentArguements(Bundle arguments) {
        mTagId = arguments.getString(TAG_ID);
    }

    @Override
    protected void detach() {
        if (null != mPresentfer) {
            mPresentfer.detattch();
        }
    }

    public static DetailFragment newInstance(String tagid) {

        Bundle args = new Bundle();
        args.putString(TAG_ID, tagid);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onErro(String msg) {

    }

    @Override
    public void onSuccess() {

    }
}
