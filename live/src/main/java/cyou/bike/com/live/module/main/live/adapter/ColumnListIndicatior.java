package cyou.bike.com.live.module.main.live.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.TriangularPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

import cyou.bike.com.live.module.main.live.bean.ColumnListIndicatorBean;

/**
 * Created by：anlonglong
 * on 2017/12/16 15:52
 * Email: anlonglong0721@gmail.com
 */

public class ColumnListIndicatior extends CommonNavigatorAdapter {

    private List<ColumnListIndicatorBean.DataBean> mColumList;

    private ViewPager mLiveViewPager;

    public ColumnListIndicatior(List<ColumnListIndicatorBean.DataBean> columList, ViewPager viewPager ) {
        this.mLiveViewPager = viewPager;
        mColumList = columList;
    }

    @Override
    public int getCount() {
        return mColumList == null||mColumList.isEmpty()?1:mColumList.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
        simplePagerTitleView.setText(mColumList.get(index).getCate_name());
        simplePagerTitleView.setNormalColor(Color.parseColor("#FFD2B6A0"));
        simplePagerTitleView.setSelectedColor(Color.parseColor("#ffffff"));
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLiveViewPager.setCurrentItem(index);
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        TriangularPagerIndicator indicator = new TriangularPagerIndicator(context);
        indicator.setLineColor(Color.parseColor("#ffffff"));
        return indicator;
    }
}
