package cyou.bike.com.live.module.main.home.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bingoogolapple.bgabanner.BGABanner;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.constant.Constants;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.live.cellphonelive.CellPhoneLiveActivity;
import cyou.bike.com.live.module.main.home.adapter.SectionAdapter;
import cyou.bike.com.live.module.main.home.bean.BannerBean;
import cyou.bike.com.live.module.main.home.bean.DigDataRoomBean;
import cyou.bike.com.live.module.main.home.bean.FaceScoreBean;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.module.main.home.bean.ItemSection;
import cyou.bike.com.live.module.main.home.bean.MySection;
import cyou.bike.com.live.module.main.home.contract.RecommendContract;
import cyou.bike.com.live.module.main.home.presenter.RecommendPresenter;
import cyou.bike.com.live.repository.ConfigKey;
import cyou.bike.com.live.repository.daggerProvider.RepositoryModule;
import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/10/20 16:21
 * Email: anlonglong0721@gmail.com
 */

public class RecommendFragment extends BaseFragment<RecommendPresenter>
        implements RecommendContract.View,
        OnRefreshListener,
        OnLoadmoreListener,
        BGABanner.Delegate<LinearLayout,BannerBean.DataBean> {


    public static final String TAG = RecommendFragment.class.getSimpleName();


    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;
    @BindView(R.id.srefreshlayiut)
    SmartRefreshLayout mSrefreshlayiut;
    BGABanner mBanner;
    private RecommendPresenter mPresenter;

    private List<MySection> mSectionList = new ArrayList<>();
    private SectionAdapter mSectionAdapter;
    private BGABanner.Adapter mAdapter;


    @Override
    protected void loadData(View view) {
        mPresenter = (RecommendPresenter) getPresenter();
        mPresenter.attach(this);
        View bannerView  = View.inflate(getContext(), R.layout.recommend_head, null);
        mBanner = (BGABanner) bannerView.findViewById(R.id.banner);
        mBanner.setDelegate(this);
        mSectionAdapter = new SectionAdapter(mSectionList);
        mSectionAdapter.addHeaderView(bannerView);
        GridLayoutManager layout = new GridLayoutManager(getContext(), 2);
        mRecycleView.setLayoutManager(layout);
        mRecycleView.setAdapter(mSectionAdapter);
        mSectionAdapter.bindToRecyclerView(mRecycleView);
        mSectionAdapter.setEmptyView(R.layout.empty_view);
        mPresenter.getBannerList(Constants.VERSION);
    }


    @Override
    protected void initListener() {
        mSrefreshlayiut.setOnRefreshListener(this);
        mSrefreshlayiut.setOnLoadmoreListener(this);
/**
 * flapMap操作符的作用是回调中套回调的情况下使用的,
 * eg:
 *    网络请求拿到token后立刻用token请求用户数据的情形.
 */
    }


    @Override
    public void onBannerListSuccess(BannerBean data) {
        if (mSrefreshlayiut.isRefreshing()) {
            mSrefreshlayiut.finishRefresh();
        }
        List<BannerBean.DataBean> bannerList = data.getData();
        mBanner.setAdapter(mAdapter = new BGABanner.Adapter<LinearLayout, BannerBean.DataBean>() {
            @Override
            public void fillBannerItem(BGABanner bgaBanner, LinearLayout item, BannerBean.DataBean dataBean, int i) {
                SimpleDraweeView itemSimple = (SimpleDraweeView) item.findViewById(R.id.banner_img);
                itemSimple.setImageURI(dataBean.getPic_url());
            }
        });
        mBanner.setData(R.layout.banner_item, bannerList, null);
        String token = RepositoryModule.getInstance().loadByKey(ConfigKey.TOKEN, "");
        String auth = RepositoryModule.getInstance().loadByKey(ConfigKey.AUTH, "");
        mPresenter.getBigDataRoom(SystemType.ANDROID.name().concat("1"),System.currentTimeMillis(),token,auth);
    }

    @Override
    public void onDigDataRoomSuccess(DigDataRoomBean dataRoom) {
        MySection hottitle = new MySection(true, "最热", false);
        mSectionList.add(hottitle);
        for(DigDataRoomBean.DataBean dataBean:dataRoom.getData()) {
            MySection section = new MySection(new ItemSection(dataBean));
            mSectionList.add(section);
        }
        mPresenter.getFaceScoreRoom(0,4);
        notifyDataChanged(0,mSectionList.size());
    }




    @Override
    public void onFaceScore(FaceScoreBean faceScoreBean) {
        LogUtil.i(TAG,"onFaceScore = "+faceScoreBean.toString());
        MySection hottitle = new MySection(true, "颜值", true);
        int posi = mSectionList.size();
        mSectionList.add(hottitle);
        for(FaceScoreBean.DataBean dataBean : faceScoreBean.getData()){
            MySection section = new MySection(new ItemSection(dataBean));
            mSectionList.add(section);
        }
        notifyDataChanged(posi,mSectionList.size()-posi);
        String token = RepositoryModule.getInstance().loadByKey(ConfigKey.TOKEN, "");
        String auth = RepositoryModule.getInstance().loadByKey(ConfigKey.AUTH, "");
        mPresenter.getHotCate(SystemType.ANDROID.name().concat("1"), String.valueOf(System.currentTimeMillis()), token, auth);
    }


    @Override
    public void onHotCate(HotCateBean hotCateBean) {
        int posi = mSectionList.size();
        for (HotCateBean.DataBean date:hotCateBean.getData()) {
            MySection section = new MySection(true, date.getTag_name(), true);
            mSectionList.add(section);
            for(HotCateBean.DataBean.RoomListBean dat: date.getRoom_list()) {
                MySection mySection = new MySection(new ItemSection(dat));
                mSectionList.add(mySection);
            }
        }
        notifyDataChanged(posi,mSectionList.size()-posi);
        text();


    }

    private void text() {
        RecyclerView.Adapter adapter = mRecycleView.getAdapter();
        int childCount = mRecycleView.getChildCount();
        View childAt = mRecycleView.getChildAt(childCount - 1);
        childAt.getLayoutParams();
        Utils.isRecyclerViewFullscreen(mRecycleView);
    }

    private void notifyDataChanged(int startPosi,int count) {
        mSectionAdapter.setNewData(mSectionList);
        //mSectionAdapter.notifyDataSetChanged();
       // mSectionAdapter.notifyItemRangeInserted(startPosi,count);
    }

    @Override
    public void onErro(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        hideLoading();
    }

    @Override
    public void onSuccess() {

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void detach() {
        if (null != mPresenter)
        mPresenter.detattch();
    }


    public static BaseFragment getInstance() {
        return new RecommendFragment();
    }


    @Override
    protected Class getThisClass() {
        return this.getClass();
    }


    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mSectionList.clear();
        notifyDataChanged(0,0);
        mPresenter.getBannerList(Constants.VERSION);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {

    }

    @Override
    public void onBannerItemClick(BGABanner bgaBanner, LinearLayout linearLayout, BannerBean.DataBean data, int position) {

        CellPhoneLiveActivity.start(linearLayout.getContext(),data.getRoom().getRoom_id(),false);
    }

}
