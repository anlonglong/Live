package cyou.bike.com.live.module.main.video.adapter;/**
 * Created by anlonglong on 2017/12/29.
 */

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

import cyou.bike.com.live.module.main.video.bean.VideoCate2;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/29 at 15:56
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoIndicatorAdapter extends CommonNavigatorAdapter {
    private  ViewPager mPager;
    private  List<VideoCate2.DataBean> mDatas;

    public VideoIndicatorAdapter(List<VideoCate2.DataBean> dataBeanList, ViewPager liveListViewPager) {
        this.mDatas = dataBeanList;
        this.mPager = liveListViewPager;
    }

    @Override
    public int getCount() {
        return mDatas == null || mDatas.size() == 0?1:mDatas.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {

        SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
        simplePagerTitleView.setText(mDatas.get(index).getCate2_name());
        simplePagerTitleView.setNormalColor(Color.parseColor("#333333"));
        simplePagerTitleView.setSelectedColor(Color.parseColor("#e94220"));
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPager.setCurrentItem(index);
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
