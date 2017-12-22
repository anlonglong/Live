package cyou.bike.com.live.module.main.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vondear.rxtools.view.RxToast;

import java.util.List;

import butterknife.BindView;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.home.adapter.MoreAdapter;
import cyou.bike.com.live.module.main.home.bean.ThreeCate;
import cyou.bike.com.live.module.main.home.bean.ThreeCateData;
import cyou.bike.com.live.module.main.home.contract.MoreContract;
import cyou.bike.com.live.module.main.home.presenter.MoreActivityPresenter;
import cyou.bike.com.live.module.main.home.presenter.MoreFragmentPresenter;

/**
 * Created by：anlonglong
 * on 2017/12/14 21:56
 * Email: anlonglong0721@gmail.com
 */

public class MoreFragment extends BaseFragment<MoreFragmentPresenter> implements MoreContract.fragmentContract.View {
    private static final String CATEID = "id";
    @BindView(R.id.more_recycle_view)
    RecyclerView mMoreRecycleView;
    private String mCateID;
    private MoreFragmentPresenter mPresenter;
    private List<ThreeCateData.DataBean> mList;

    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void onFragmentArguements(Bundle arguments) {
        mCateID = arguments.getString(CATEID);
    }

    @Override
    protected void loadData(View view) {
        mPresenter = (MoreFragmentPresenter) getPresenter();
        mPresenter.attach(this);
        mPresenter.getThreeCateData(mCateID,0,20);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.more_fragment;
    }

    @Override
    protected void detach() {

    }

    public static MoreFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString(CATEID,id);
        MoreFragment fragment = new MoreFragment();
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
    public void onThreeCateData(ThreeCateData data) {
        GridLayoutManager layout = new GridLayoutManager(getContext(), 2);
        mMoreRecycleView.setLayoutManager(layout);
        mList = data.getData();
        MoreAdapter moreAdapter = new MoreAdapter(mList);
        moreAdapter.bindToRecyclerView(mMoreRecycleView);
        moreAdapter.setEmptyView(R.layout.empty_view);
        mMoreRecycleView.setAdapter(moreAdapter);
    }

}
