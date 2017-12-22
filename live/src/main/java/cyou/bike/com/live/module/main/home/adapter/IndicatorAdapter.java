package cyou.bike.com.live.module.main.home.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

import cyou.bike.com.live.module.main.home.activity.ColorFlipPagerTitleView;
import cyou.bike.com.live.module.main.home.bean.ThreeCate;

/**
 * Created by：anlonglong
 * on 2017/12/14 21:49
 * Email: anlonglong0721@gmail.com
 */

public class IndicatorAdapter extends CommonNavigatorAdapter {
    private List<ThreeCate.DataBean> mList;
    private ViewPager mViewPager;

    public IndicatorAdapter(List<ThreeCate.DataBean> list,ViewPager pager) {
        mList = list;
        mViewPager = pager;
    }

    @Override
    public int getCount() {
        return mList == null ?0:mList.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ColorFlipPagerTitleView(context);
        simplePagerTitleView.setText(mList.get(index).getName());
        simplePagerTitleView.setNormalColor(0xFFBEBBBB);
        simplePagerTitleView.setSelectedColor(0xFFED6D10);
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(index);
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
        indicator.setLineHeight(UIUtil.dip2px(context, 3));
        indicator.setLineWidth(UIUtil.dip2px(context, 20));
        indicator.setRoundRadius(UIUtil.dip2px(context, 1));
        indicator.setStartInterpolator(new AccelerateInterpolator());
        indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
        indicator.setColors(0xFF00C853);
        return indicator;
    }
}
