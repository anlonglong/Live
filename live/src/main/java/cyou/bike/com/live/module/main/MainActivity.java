package cyou.bike.com.live.module.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.constant.Constants;
import cyou.bike.com.live.module.main.follow.FollowFragment;
import cyou.bike.com.live.module.main.home.fragment.HomeFragment;
import cyou.bike.com.live.module.main.live.fragment.LiveFragment;
import cyou.bike.com.live.module.main.my.MyFragment;
import cyou.bike.com.live.module.main.video.VideoFragment;
import cyou.bike.com.live.utils.LogUtil;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.bottom_navigation_bar_container)
    BottomNavigationBar mBottomNavigationBarContainer;
    private Fragment mFragment;
    private FragmentManager mManager;
    private Unbinder mBind;

    public static void start(Activity activity, boolean needFinish) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        if (needFinish) {
            activity.finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        mBottomNavigationBarContainer.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBarContainer.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        mBottomNavigationBarContainer.setTabSelectedListener(this);
        BottomNavigationItem homeItem
                = new BottomNavigationItem(R.drawable.home_selected, Constants.HOME_ITEM)
                .setActiveColorResource(R.color.colorNavigationBg)
                .setInActiveColor(R.color.colorStatueBar)
                .setInactiveIcon(getDrawable(R.drawable.home_pressed));
        BottomNavigationItem liveItem
                = new BottomNavigationItem(R.drawable.live_selected, Constants.lIVE_ITEM)
                .setActiveColorResource(R.color.colorNavigationBg)
                .setInActiveColor(R.color.colorStatueBar)
                .setInactiveIcon(getDrawable(R.drawable.live_pressed));

        BottomNavigationItem videoItem
                = new BottomNavigationItem(R.drawable.video_selected, Constants.VIDEO_ITEM)
                .setActiveColorResource(R.color.colorNavigationBg)
                .setInActiveColor(R.color.colorStatueBar)
                .setInactiveIcon(getDrawable(R.drawable.video));
        BottomNavigationItem followItem
                = new BottomNavigationItem(R.drawable.follow_selected, Constants.FLLLOW_ITEM)
                .setActiveColorResource(R.color.colorNavigationBg)
                .setInActiveColor(R.color.colorStatueBar)
                .setInactiveIcon(getDrawable(R.drawable.follow_pressed));
        BottomNavigationItem myItem
                = new BottomNavigationItem(R.drawable.user_selected, Constants.MY_ITEM)
                .setActiveColorResource(R.color.colorNavigationBg)
                .setInActiveColor(R.color.colorStatueBar)
                .setInactiveIcon(getDrawable(R.drawable.user_pressed));
        mBottomNavigationBarContainer
                .addItem(homeItem)
                .addItem(liveItem)
                .addItem(videoItem)
                .addItem(followItem)
                .addItem(myItem)
                .setFirstSelectedPosition(0)
                .initialise();
        mManager = getSupportFragmentManager();
        mManager.beginTransaction().replace(R.id.fragment_container, HomeFragment.newInstance()).commit();
        //ViewPager+FragmentStatePagerAdapter 报错Fragment already added: RecommendFragment{47f7127 #0 id=0x7f10015c}  很大程度上是布局发问题,可以先设置一个TextView看一看布局是否有问题
    }

    @Override
    public void onTabSelected(int position) {
        LogUtil.i(TAG, "position = " + position);
        FragmentTransaction ft = mManager.beginTransaction();
        BaseFragment fragment = null;
        switch (position) {
            case Constants.HOME:
                fragment = HomeFragment.newInstance();
                break;
            case Constants.LIVE:
                fragment = LiveFragment.getInstance();
                break;
            case Constants.VIDEO:
                fragment = VideoFragment.newInstance();
                break;
            case Constants.FLLOW:
                fragment = FollowFragment.newInstance();
                break;
            case Constants.ME:
                fragment = MyFragment.newInstance();
                break;
            default:
        }
       ft.replace(R.id.fragment_container,fragment).commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onDestroy() {
        if (null != mBind) {
            mBind.unbind();
        }
        super.onDestroy();
    }
}
