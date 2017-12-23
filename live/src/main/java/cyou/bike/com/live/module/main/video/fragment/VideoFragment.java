package cyou.bike.com.live.module.main.video.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.vondear.rxtools.view.RxToast;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.List;

import butterknife.BindView;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.live.adapter.ColumnListIndicatior;
import cyou.bike.com.live.module.main.video.adapter.VideoHomeCateIndicatior;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.bean.VideoHomeCate;
import cyou.bike.com.live.module.main.video.contract.VideoContract;
import cyou.bike.com.live.module.main.video.presenter.VideoPresenter;

/**
 * Created by：anlonglong
 * on 2017/12/7 17:33
 * Email: anlonglong0721@gmail.com
 */

public class VideoFragment extends BaseFragment<VideoPresenter> implements VideoContract.View{


    @BindView(R.id.video_indicator)
    MagicIndicator mVideoIndicator;
    @BindView(R.id.video_view_pager)
    ViewPager mVideoViewPager;
    private VideoPresenter mPresenter;

    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void loadData(View view) {
        mVideoIndicator.setBackgroundColor(getResources().getColor(R.color.colorStatueBar));
        mPresenter = (VideoPresenter) getPresenter();
        if (null != mPresenter) {
            mPresenter.attach(this);
            mPresenter.getVideoHomeCate1();
        }

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.vodeo_fragment_layout;
    }

    @Override
    protected void detach() {
          if (null != mPresenter) {
              mPresenter.detattch();
          }
    }

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
        return fragment;
    }

    @Override
    public void onErro(String msg) {
        RxToast.error(msg);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onGetVideoHomeCate1(final List<VideoHomeCate.DataBean> datas) {
        VideoHomeCate.DataBean bean = new VideoHomeCate.DataBean();
        bean.setCate1_name("推荐");
        datas.add(0,bean);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setScrollPivotX(0.15f);
        commonNavigator.setAdapter(new VideoHomeCateIndicatior(datas, mVideoViewPager));
        mVideoIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mVideoIndicator, mVideoViewPager);
        mVideoViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return RecommendFragment.newInstance();
            }

            @Override
            public int getCount() {
                return  datas == null || datas.isEmpty()?1:datas.size();
            }
        });
    }
}
