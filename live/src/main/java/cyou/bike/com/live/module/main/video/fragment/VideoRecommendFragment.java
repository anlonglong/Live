package cyou.bike.com.live.module.main.video.fragment;/**
 * Created by anlonglong on 2017/12/23.
 */

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.vondear.rxtools.view.RxToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.video.adapter.VideoAuthAdapter;
import cyou.bike.com.live.module.main.video.adapter.VideoRecommAdapter;
import cyou.bike.com.live.module.main.video.bean.AuthSection;
import cyou.bike.com.live.module.main.video.bean.CateHotVideoList;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;
import cyou.bike.com.live.module.main.video.bean.HotVideoList;
import cyou.bike.com.live.module.main.video.bean.VideoItemSection;
import cyou.bike.com.live.module.main.video.bean.VideoSection;
import cyou.bike.com.live.module.main.video.contract.RecommContract;
import cyou.bike.com.live.module.main.video.presenter.RecommPresenter;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 16:02
 * <p>
 * Desc: 推荐
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoRecommendFragment extends BaseFragment<RecommPresenter> implements RecommContract.View {

    @BindView(R.id.video_recycle_view)
    RecyclerView mVideoRecycleView;
    @BindView(R.id.video_recomm_refreshlayiut)
    SmartRefreshLayout mVideoRecommRefreshlayiut;
    private RecommPresenter mPresenter;

    private List<VideoSection> mSectionList = new ArrayList<>();
    private VideoRecommAdapter mAdapter;
    private RecyclerView mFoodeeRecycle;


    @Override
    protected void loadData(View view) {
        mPresenter = (RecommPresenter) getPresenter();
        if (null != mPresenter) {
            mPresenter.attach(this);
            GridLayoutManager layout = new GridLayoutManager(getContext(), 2);
            mVideoRecycleView.setLayoutManager(layout);
            mAdapter = new VideoRecommAdapter(mSectionList);
            View footer = View.inflate(getContext(), R.layout.video_recomm_footer_layout, null);
            mFoodeeRecycle = footer.findViewById(R.id.fooder_recycle_view);
            mFoodeeRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
            mAdapter.addFooterView(footer);
            mPresenter.getCateHotVideoList1();
            mPresenter.getHotVideoList1();
            mPresenter.getHotAuthors();
        }
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.video_recomm_fragment;
    }

    @Override
    protected void detach() {
        if (null != mPresenter) {
            mPresenter.detattch();
        }
    }

    public static VideoRecommendFragment newInstance() {

        Bundle args = new Bundle();
        VideoRecommendFragment fragment = new VideoRecommendFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onErro(String msg) {
        RxToast.error(msg);
    }

    @Override
    public void onSuccess() {

    }


    @Override
    protected Class getThisClass() {
        return getClass();
    }

    @Override
    public void onGetHotVideoList1(List<HotVideoList.DataBean> datas, HotVideoList hotVideoList) {
        VideoSection section = new VideoSection(true, "热门视频", false);
        mSectionList.add(section);
        for (HotVideoList.DataBean data : datas) {
            VideoItemSection itemSection = new VideoItemSection(data);
            section = new VideoSection(itemSection);
            mSectionList.add(section);
        }
        mVideoRecycleView.setAdapter(mAdapter);
        mAdapter.setNewData(mSectionList);
    }

    @Override
    public void onGetCateHotVideoList1(List<CateHotVideoList.DataBean> datas, CateHotVideoList cateHotVideoList) {
        for (CateHotVideoList.DataBean data : datas) {
            VideoSection section = new VideoSection(true, data.getCate_name(), true);
            mSectionList.add(section);
            for (CateHotVideoList.DataBean.VideoListBean videoListBean : data.getVideo_list()) {
                VideoItemSection videoItemSection = new VideoItemSection(videoListBean);
                section = new VideoSection(videoItemSection);
                mSectionList.add(section);
            }
        }
        mAdapter.setNewData(mSectionList);

    }

    @Override
    public void onGetHotAuthors(List<HotAuthors.DataBean> datas, HotAuthors hotAuthors) {
        List<AuthSection> authList = new ArrayList<>();
        AuthSection authSection = new AuthSection(true, "热门作者");
        authList.add(authSection);
        for (HotAuthors.DataBean data : datas) {
            authSection = new AuthSection();
            authSection.t = data;
            authList.add(authSection);
        }
        mFoodeeRecycle.setAdapter(new VideoAuthAdapter(authList));
    }

}
