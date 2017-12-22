package cyou.bike.com.live.module.main.live.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.View;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.List;

import cyou.bike.com.live.module.main.live.bean.InnerColumnDetailBean;

/**
 * Created by：anlonglong
 * on 2017/12/17 12:04
 * Email: anlonglong0721@gmail.com
 */

public class InnerAdapter extends CommonNavigatorAdapter {

    List<InnerColumnDetailBean.DataBean> mDatas;
    ViewPager mViewPager;

    public InnerAdapter(List<InnerColumnDetailBean.DataBean> datas, ViewPager liveListViewPager) {
        this.mDatas = datas;
        this.mViewPager = liveListViewPager;
    }

    @Override
    public int getCount() {
        return mDatas == null || mDatas.isEmpty()?1:mDatas.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {

        SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
        simplePagerTitleView.setText(mDatas.get(index).getTag_name());
        simplePagerTitleView.setNormalColor(Color.parseColor("#333333"));
        simplePagerTitleView.setSelectedColor(Color.parseColor("#e94220"));
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
        WrapPagerIndicator indicator = new WrapPagerIndicator(context);
        indicator.setFillColor(Color.parseColor("#ebe4e3"));
        return indicator;
    }
}
