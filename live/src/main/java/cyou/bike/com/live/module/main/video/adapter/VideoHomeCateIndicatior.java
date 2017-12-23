package cyou.bike.com.live.module.main.video.adapter;/**
 * Created by anlonglong on 2017/12/23.
 */

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

import cyou.bike.com.live.module.main.video.bean.VideoHomeCate;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 17:09
 * <p>
 * Desc: null
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoHomeCateIndicatior extends CommonNavigatorAdapter {
    private final List<VideoHomeCate.DataBean> mList;
    private final ViewPager mPage;

    public VideoHomeCateIndicatior(List<VideoHomeCate.DataBean> datas, ViewPager videoViewPager) {
        this.mList = datas;
        this.mPage = videoViewPager;
    }

    @Override
    public int getCount() {
        return mList == null || mList.isEmpty()?1:mList.size();
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new SimplePagerTitleView(context);
        simplePagerTitleView.setText(mList.get(index).getCate1_name());
        simplePagerTitleView.setNormalColor(Color.parseColor("#FFD2B6A0"));
        simplePagerTitleView.setSelectedColor(Color.parseColor("#ffffff"));
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPage.setCurrentItem(index);
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
