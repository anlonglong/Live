package cyou.bike.com.live.module.main.live.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

import butterknife.BindView;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.live.adapter.InnerAdapter;
import cyou.bike.com.live.module.main.live.bean.InnerColumnDetailBean;
import cyou.bike.com.live.module.main.live.contract.InnerLiveListContract;
import cyou.bike.com.live.module.main.live.presenter.InnerPresenter;

/**
 * Created by：anlonglong
 * on 2017/12/16 15:59
 * Email: anlonglong0721@gmail.com
 */

public class InnerLiveListFragment extends BaseFragment<InnerPresenter> implements InnerLiveListContract.View {
    private static String CATE_NAME = "cate_name";
    @BindView(R.id.live_list_indictor)
    MagicIndicator mLiveListIndictor;
    @BindView(R.id.live_list_view_pager)
    ViewPager mLiveListViewPager;
    private String mCateName;
    private InnerPresenter mPresenter;

    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void onFragmentArguements(Bundle arguments) {
        mCateName = arguments.getString(CATE_NAME);
    }

    @Override
    protected void loadData(View view) {
        mPresenter = (InnerPresenter) getPresenter();
        mPresenter.attach(this);
        mLiveListIndictor.setBackgroundColor(0xffffff);
        mPresenter.getColumnDetail(mCateName);
    }

    @Override
    public void onColumnDetail(InnerColumnDetailBean detailBean) {
        final List<InnerColumnDetailBean.DataBean> datas = detailBean.getData();
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setScrollPivotX(0.35f);
        commonNavigator.setAdapter(new InnerAdapter(datas,mLiveListViewPager));
        mLiveListIndictor.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mLiveListIndictor,mLiveListViewPager);
        mLiveListViewPager.setOffscreenPageLimit(datas.size());
        mLiveListViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return DetailFragment.newInstance(datas.get(position).getTag_id());
            }

            @Override
            public int getCount() {
                return datas == null||datas.isEmpty()?1:datas.size();
            }
        });
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.live_list_fragment;
    }

    @Override
    protected void detach() {
        if (null != mPresenter) {
            mPresenter.detattch();
        }
    }

    public static InnerLiveListFragment newInstance(String cate_name) {

        Bundle args = new Bundle();
        args.putString(CATE_NAME, cate_name);
        InnerLiveListFragment fragment = new InnerLiveListFragment();
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
