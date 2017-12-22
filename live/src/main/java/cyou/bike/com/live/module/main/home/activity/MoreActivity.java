package cyou.bike.com.live.module.main.home.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.vondear.rxtools.view.RxToast;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cyou.bike.com.live.R;
import cyou.bike.com.live.module.main.home.adapter.IndicatorAdapter;
import cyou.bike.com.live.module.main.home.bean.ThreeCate;
import cyou.bike.com.live.module.main.home.contract.MoreContract;
import cyou.bike.com.live.module.main.home.fragment.MoreFragment;
import cyou.bike.com.live.module.main.home.presenter.MoreActivityPresenter;

/**
 * Created by：anlonglong
 * on 2017/12/12 22:13
 * Email: anlonglong0721@gmail.com
 */

public class MoreActivity extends SwipeActivity<MoreActivityPresenter> implements MoreContract.ActivityContract.View {


    @BindView(R.id.more_title)
    TextView mMoreTitle;
    @BindView(R.id.other_back)
    ImageView mOtherBack;
    @BindView(R.id.more_indicator)
    MagicIndicator mMoreIndicator;
    @BindView(R.id.more_view_pager)
    ViewPager mMoreViewPager;
    private MoreActivityPresenter mPresenter;
    private static final String TITLE = "title";
    private static final String CATEID = "cateId";
    private String mCateId;


    public static void startActivity(Context context,String title,String catId) {
        Intent intent = new Intent(context, MoreActivity.class);
        intent.putExtra(TITLE,title);
        intent.putExtra(CATEID,catId);
        context.startActivity(intent);
    }


    @Override
    protected int getContentViewId() {
        return R.layout.activity_more;
    }

    @Override
    protected void detach() {
        if (null != mPresenter) {
            mPresenter.detattch();
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData(Intent intent) {
        if (null != intent) {
            String title = intent.getStringExtra(TITLE);
            mMoreTitle.setText(title);
            mCateId = intent.getStringExtra(CATEID);
            mPresenter = (MoreActivityPresenter) getPresenter();
            mPresenter.attach(this);
            mPresenter.getThreeCate(mCateId);
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
    public void onThreeCate(final ThreeCate data) {
        final List<ThreeCate.DataBean> cataList = data.getData();
        ThreeCate.DataBean firstData = new ThreeCate.DataBean();
        firstData.setName("全部");
        cataList.add(0,firstData);
        mMoreIndicator.setBackgroundColor(0xffffffff);
        CommonNavigator navigator = new CommonNavigator(this);
        navigator.setScrollPivotX(0.5f);
        navigator.setAdapter(new IndicatorAdapter(cataList,mMoreViewPager));
        mMoreIndicator.setNavigator(navigator);
        ViewPagerHelper.bind(mMoreIndicator,mMoreViewPager);
        mMoreViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position ==0) {
                    return MoreFragment.newInstance(mCateId);
                }else {
                    return MoreFragment.newInstance(data.getData().get(position).getId());
                }
            }

            @Override
            public int getCount() {
                return cataList == null?0:cataList.size();
            }
        });
    }



    @OnClick(R.id.other_back)
    public void click(View v) {
        switch (v.getId()) {
            case R.id.other_back:
                finish();
                break;
        }
    }
}
