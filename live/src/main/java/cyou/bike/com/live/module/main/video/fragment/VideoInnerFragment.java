package cyou.bike.com.live.module.main.video.fragment;/**
 * Created by anlonglong on 2017/12/29.
 */

import android.os.Bundle;
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
import cyou.bike.com.live.module.main.live.fragment.DetailFragment;
import cyou.bike.com.live.module.main.video.adapter.VideoIndicatorAdapter;
import cyou.bike.com.live.module.main.video.bean.VideoCate2;
import cyou.bike.com.live.module.main.video.contract.VideoInnerContract;
import cyou.bike.com.live.module.main.video.presenter.VideoInnerPresenter;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/29 at 13:47
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoInnerFragment extends BaseFragment<VideoInnerPresenter> implements VideoInnerContract.View {
    private static final String CID = "cid";
    @BindView(R.id.live_list_indictor)
    MagicIndicator mLiveListIndictor;
    @BindView(R.id.live_list_view_pager)
    ViewPager mLiveListViewPager;
    private String mCid;
    private VideoInnerPresenter mPresenter;

    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    protected void onFragmentArguements(Bundle arguments) {
        mCid = arguments.getString(CID);
    }

    @Override
    protected void loadData(View view) {
        mPresenter = (VideoInnerPresenter) getPresenter();
        mPresenter.attach(this);
        mLiveListIndictor.setBackgroundColor(0xffffff);
        mPresenter.getVideoCate2(mCid);
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

    @Override
    public void onErro(String msg) {
        RxToast.error(msg);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onVideoCate2(VideoCate2 detailBean) {
        final List<VideoCate2.DataBean> dataBeanList = detailBean.getData();
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setScrollPivotX(0.35f);
        commonNavigator.setAdapter(new VideoIndicatorAdapter(dataBeanList,mLiveListViewPager));
        mLiveListIndictor.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mLiveListIndictor,mLiveListViewPager);
        mLiveListViewPager.setOffscreenPageLimit(dataBeanList.size());
        mLiveListViewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                VideoCate2.DataBean dataBean = dataBeanList.get(position);
                return VideoDetailFragment.newInstance(dataBean.getCid1(),dataBean.getCid2());
            }

            @Override
            public int getCount() {
                return dataBeanList == null||dataBeanList.isEmpty()?1:dataBeanList.size();
            }
        });
    }

    public static VideoInnerFragment newInstance(String cid) {

        Bundle args = new Bundle();
        args.putString(CID, cid);
        VideoInnerFragment fragment = new VideoInnerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
