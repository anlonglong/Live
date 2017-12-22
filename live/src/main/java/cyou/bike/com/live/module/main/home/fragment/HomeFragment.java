package cyou.bike.com.live.module.main.home.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.vondear.rxtools.activity.ActivityScanerCode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.adapter.HomeAdapter;
import cyou.bike.com.live.module.main.home.bean.CateListBean;
import cyou.bike.com.live.module.main.home.contract.HomeContract;
import cyou.bike.com.live.module.main.home.presenter.HomePresenter;
import cyou.bike.com.live.utils.LogUtil;
import io.vov.vitamio.utils.Log;

/**
 * Created by：anlonglong
 * on 2017/11/2 15:29
 * Email: anlonglong0721@gmail.com
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.search)
    ImageView mSearch;
    @BindView(R.id.scan)
    ImageView mScan;
    @BindView(R.id.history)
    ImageView mHistory;
    @BindView(R.id.message)
    ImageView mMessage;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    private HomePresenter mPresenter;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;

    @Override
    protected Class getThisClass() {
        return this.getClass();
    }

    @Override
    protected void loadData(View view) {
        mPresenter = (HomePresenter) getPresenter();
        mPresenter.attach(this);
        showLoading();
        mPresenter.getCateList(0, SystemType.ANDROID, 0);
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void detach() {
        mPresenter.detattch();
    }

    @Override
    public void onErro(String msg) {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onCateListSuccess(CateListBean data) {
        LogUtil.i("HomeAdapter","dddddd");
        hideLoading();
        List<CateListBean.DataBean> cateList = data.getData();
        CateListBean.DataBean dataBean = new CateListBean.DataBean();
        dataBean.setTitle("推荐");
        cateList.add(0,dataBean);
        mViewPager.setOffscreenPageLimit(cateList.size());
        HomeAdapter homeAdapter = new HomeAdapter(getChildFragmentManager(),cateList);
        mViewPager.setAdapter(homeAdapter);
        mTablayout.setupWithViewPager(mViewPager);
    }


    @OnClick({R.id.search, R.id.scan, R.id.history, R.id.message})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.search:
                Toast.makeText(getContext(), "搜索", Toast.LENGTH_SHORT).show();
                break;
            case R.id.scan:
                startActivity(new Intent(getContext(),ActivityScanerCode.class));
                Toast.makeText(getContext(), "扫描", Toast.LENGTH_SHORT).show();
                break;
            case R.id.history:
                Toast.makeText(getContext(), "历史", Toast.LENGTH_SHORT).show();
                break;
            case R.id.message:
                Toast.makeText(getContext(), "消息", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(getContext(), "位置点击事件", Toast.LENGTH_SHORT).show();

        }
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }
}
