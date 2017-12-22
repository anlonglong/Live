package cyou.bike.com.live.module.main.live.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.vondear.rxtools.view.RxToast;
import com.vondear.rxtools.view.dialog.RxDialog;

import java.util.List;

import butterknife.BindView;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.live.adapter.ColumonAllListAdaper;
import cyou.bike.com.live.module.main.live.bean.ColumonListBean;
import cyou.bike.com.live.module.main.live.contract.ColumonListContract;
import cyou.bike.com.live.module.main.live.presenter.ColumonPresenter;

/**
 * Created by：anlonglong
 * on 2017/12/16 15:04
 * Email: anlonglong0721@gmail.com
 */

public class ColumonAllListFragment extends BaseFragment<ColumonPresenter> implements ColumonListContract.View {
    private static final String CATE_NAME = "cate_name";
    @BindView(R.id.columon_all_recycle_view)
    RecyclerView mRecycleView;
    private ColumonPresenter mPresenter;
    private String mCateName;
    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void loadData(View view) {
        mPresenter = (ColumonPresenter) getPresenter();
        mPresenter.attach(this);
        mPresenter.getColumonList(0, 20);
    }

    @Override
    protected void onFragmentArguements(Bundle arguments) {
        mCateName = arguments.getString(CATE_NAME);
    }

    public static ColumonAllListFragment newInstance(String cate_name) {
        Bundle args = new Bundle();
        args.putString(CATE_NAME, cate_name);
        ColumonAllListFragment fragment = new ColumonAllListFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onColumonList(ColumonListBean data) {
        List<ColumonListBean.DataBean> dataBeanList = data.getData();
        mRecycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ColumonAllListAdaper adapter = new ColumonAllListAdaper(dataBeanList);
        adapter.bindToRecyclerView(mRecycleView);
        adapter.setEmptyView(R.layout.empty_view);
        mRecycleView.setAdapter(adapter);
    }

    @Override
    public void onErro(String msg) {
        RxToast.error(msg);
    }

    @Override
    public void onSuccess() {
        RxToast.success("Dimiss Loading Dialog");
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.columon_all_list_fragment;
    }

    @Override
    protected void detach() {
        if (null != mPresenter) {
            mPresenter.detattch();
        }
    }
}
