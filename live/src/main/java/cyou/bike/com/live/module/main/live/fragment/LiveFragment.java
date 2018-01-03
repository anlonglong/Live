package cyou.bike.com.live.module.main.live.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.List;

import butterknife.BindView;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.live.adapter.ColumnListIndicatior;
import cyou.bike.com.live.module.main.live.bean.ColumnListIndicatorBean;
import cyou.bike.com.live.module.main.live.contract.LiveListIndicatorContract;
import cyou.bike.com.live.module.main.live.presenter.LiveListPresenter;

/**
 * Created by：anlonglong
 * on 2017/10/25 17:23
 * Email: anlonglong0721@gmail.com
 */

public class LiveFragment extends BaseFragment<LiveListPresenter> implements LiveListIndicatorContract.View {
    @BindView(R.id.live_indication)
    MagicIndicator mLiveIndication;
    @BindView(R.id.live_viewpager)
    ViewPager mLiveViewpager;
    private LiveListPresenter mPresenter;

    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void loadData(View view) {
        mPresenter = (LiveListPresenter) getPresenter();
        mPresenter.attach(this);
        mPresenter.getColumnList();
        mLiveIndication.setBackgroundColor(getResources().getColor(R.color.colorStatueBar));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void detach() {
        if (null != mPresenter) {
            mPresenter.detattch();
        }
    }

    public static BaseFragment getInstance() {
        return new LiveFragment();
    }

    @Override
    public void onErro(String msg) {

    }

    @Override
    public void onSuccess() {

    }


    @Override
    public void onColumnList(ColumnListIndicatorBean data) {
        final List<ColumnListIndicatorBean.DataBean> columList = data.getData();
        final ColumnListIndicatorBean.DataBean firstDataBean = new ColumnListIndicatorBean.DataBean();
        firstDataBean.setCate_name("全部");
        columList.add(0, firstDataBean);
        ColumnListIndicatorBean.DataBean allDataBean = new ColumnListIndicatorBean.DataBean();
        allDataBean.setCate_name("常用");
        columList.add(0, allDataBean);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setScrollPivotX(0.15f);
        commonNavigator.setAdapter(new ColumnListIndicatior(columList, mLiveViewpager));
        mLiveIndication.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mLiveIndication, mLiveViewpager);
        mLiveViewpager.setOffscreenPageLimit(columList.size());
        mLiveViewpager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                BaseFragment fragment;
                if (position == 0) {
                    fragment = CommentUseFragment.newInstance();
                } else if (position == 1) {
                    fragment = ColumonAllListFragment.newInstance(columList.get(position).getShort_name());
                } else {
                    fragment = InnerLiveListFragment.newInstance(columList.get(position).getShort_name());
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return columList == null || columList.isEmpty() ? 1 : columList.size();
            }
        });
    }
}
