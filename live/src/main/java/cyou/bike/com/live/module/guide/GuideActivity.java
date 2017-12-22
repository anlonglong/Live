package cyou.bike.com.live.module.guide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cyou.bike.com.live.R;
import cyou.bike.com.live.module.main.MainActivity;
import cyou.bike.com.live.repository.ConfigKey;
import cyou.bike.com.live.repository.daggerProvider.RepositoryModule;
import cyou.bike.com.live.repository.localrepository.Local;
import cyou.bike.com.live.utils.LogUtil;

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    private static List<Integer> guidePicList = new ArrayList<>();

    static {
        guidePicList.add(R.drawable.guide_bg1);
        guidePicList.add(R.drawable.guide_bg2);
        guidePicList.add(R.drawable.guide_bg3);
        guidePicList.add(R.drawable.guide_bg4);
    }

    @BindView(R.id.guide_view_pager)
    ViewPager mGuideViewPager;
    @BindView(R.id.enter_main)
    TextView mEnterMain;


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, GuideActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        mGuideViewPager.setAdapter(new GuideAdapter(guidePicList));
        mGuideViewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mEnterMain.setVisibility(position == guidePicList.size()-1 ? View.VISIBLE:View.GONE);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @OnClick(R.id.enter_main)
    public void onViewClicked() {
        RepositoryModule.getInstance().saveBooleanValue(ConfigKey.FIRSTLAUNCH, false);
        MainActivity.start(this,true);
    }
}
