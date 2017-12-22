package cyou.bike.com.live.module.main.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.List;

import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.home.bean.CateListBean;
import cyou.bike.com.live.module.main.home.fragment.OtherFragemnt;
import cyou.bike.com.live.module.main.home.fragment.RecommendFragment;
import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/11/2 16:04
 * Email: anlonglong0721@gmail.com
 */

public class HomeAdapter extends FragmentStatePagerAdapter {

    private List<CateListBean.DataBean> mTitleList;
    SparseArray<WeakReference<BaseFragment>> regisFragment = new SparseArray<>();
    FragmentManager fm;
    public HomeAdapter(FragmentManager fm, List<CateListBean.DataBean> cateList) {
        super(fm);
        this.fm = fm;
        this.mTitleList = cateList;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList == null ?"无标题":mTitleList.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        LogUtil.e("HomeAdapter","=="+position);
        BaseFragment fragment = null;
       if (position == 0) {
            fragment =  RecommendFragment.getInstance();
       }else {
            CateListBean.DataBean dataBean = mTitleList.get(position);
            fragment = OtherFragemnt.getInstance(dataBean);
        }
        WeakReference<BaseFragment> reference = new WeakReference<BaseFragment>(fragment);
        regisFragment.put(position,reference);
        return fragment;
    }


    @Override
    public int getCount() {
        return mTitleList == null?0:mTitleList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }


}
