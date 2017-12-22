package cyou.bike.com.live.module.main.home.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.vondear.rxtools.view.RxToast;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.circlenavigator.CircleNavigator;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.home.adapter.OtherAdapter;
import cyou.bike.com.live.module.main.home.bean.CateListBean;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.module.main.home.bean.OtherSection;
import cyou.bike.com.live.module.main.home.contract.OtherContract;
import cyou.bike.com.live.module.main.home.presenter.OtherPresenter;

/**
 * Created by：anlonglong
 * on 2017/11/2 17:54
 * Email: anlonglong0721@gmail.com
 */

public class OtherFragemnt extends BaseFragment<OtherPresenter> implements OtherContract.View {
    private static String CATE_LIST_BEAN = "cateListBean";
    @BindView(R.id.other_recycle_view)
    RecyclerView mOtherRecycleView;
    @BindView(R.id.other_refresh)
    SmartRefreshLayout mRefreshlayout;
    private List<OtherSection> mOtherSections = new ArrayList<>();

    private CateListBean.DataBean mDataBean;
    private OtherPresenter mPresenter;
    List<HotCateBean.DataBean> topAList = new ArrayList<>();
    List<HotCateBean.DataBean> topBList = new ArrayList<>();

    @Override
    protected Class getThisClass() {
        return this.getClass();
    }

    @Override
    protected void loadData(View view) {
        mPresenter = (OtherPresenter) getPresenter();
        if (null != mDataBean && null != mPresenter) {
            mPresenter.attach(this);
            String identification = mDataBean.getIdentification();
            mPresenter.getOtherList(identification);
        }
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void onFragmentArguements(Bundle arguments) {
        mDataBean = (CateListBean.DataBean) arguments.getSerializable(CATE_LIST_BEAN);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_other;
    }

    public static OtherFragemnt getInstance(CateListBean.DataBean dataBean) {
        OtherFragemnt fragment = new OtherFragemnt();
        if (null != dataBean) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(CATE_LIST_BEAN, dataBean);
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    protected void detach() {
        if (null != mPresenter)
        mPresenter.detattch();
    }

    @Override
    public void onErro(String msg) {
        RxToast.error(msg);
    }

    @Override
    public void onSuccess() {
        RxToast.success("数据请求成功");
    }

    @Override
    public void onOtherList(HotCateBean data) {
        View headView = View.inflate(getContext(), R.layout.other_fragment_top_layout, null);
        OtherAdapter otherAdapter = new OtherAdapter(mOtherSections);
        otherAdapter.addHeaderView(headView);
        ViewPager viewPager = headView.findViewById(R.id.top_view_pager);
        List<HotCateBean.DataBean> dataBeanList = data.getData();
        for (HotCateBean.DataBean datas :dataBeanList){
            OtherSection otherSection = new OtherSection(true, datas.getTag_name());
            if (topAList.size()<8) {
                topAList.add(datas);
            }else if (topBList.size() < 8){
                if (topBList.size() == 7) {
                    HotCateBean.DataBean dd = new HotCateBean.DataBean();
                    dd.setTag_name("全部分类");
                    //C:\androidproject\DouYu-master\live\src\main\res\drawable-xxhdpi\more_icon.png
                    dd.setIcon_url("android.resource://cyou.bike.com.live/"+R.drawable.more_icon);
                    topBList.add(dd);
                }else {
                    topBList.add(datas);
                }

            }
            mOtherSections.add(otherSection);
            for(HotCateBean.DataBean.RoomListBean dd:datas.getRoom_list()) {
                OtherSection otherSections = new OtherSection(dd);
                mOtherSections.add(otherSections);
            }
        }
        mOtherRecycleView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mOtherRecycleView.setAdapter(otherAdapter);
        viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return OtherTopListAFragment.newInstance(topAList);
                }else {
                    return OtherTopListBFragment.newInstance(topBList);
                }
            }

            @Override
            public int getCount() {
                return topAList.size()>=8 && !topBList.isEmpty()?2:1;
            }
        });
        MagicIndicator indicator = headView.findViewById(R.id.top_indication);
        CircleNavigator circleNavigator = new CircleNavigator(getContext());
        circleNavigator.setFollowTouch(false);
        circleNavigator.setCircleCount(topAList.size()>=8 && !topBList.isEmpty()?2:1);
        circleNavigator.setCircleColor(Color.GRAY);
        indicator.setNavigator(circleNavigator);
        ViewPagerHelper.bind(indicator,viewPager);
    }

}
