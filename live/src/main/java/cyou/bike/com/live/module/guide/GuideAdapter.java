package cyou.bike.com.live.module.guide;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by：anlonglong
 * on 2017/10/19 11:01
 * Email: anlonglong0721@gmail.com
 */

class GuideAdapter extends PagerAdapter {
    private final List<Integer> mList;

    public GuideAdapter(List<Integer> guidePicList) {
        this.mList = guidePicList;
    }

    @Override
    public int getCount() {
        return mList == null?0:mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Integer resId = mList.get(position);
        ImageView imageView = new ImageView(container.getContext());
        imageView.setImageResource(resId);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }
}
