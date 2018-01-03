package cyou.bike.com.live.module.main.video.fragment;/**
 * Created by anlonglong on 2017/12/29.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.vondear.rxtools.view.RxToast;

import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.home.adapter.BindValueHelper;
import cyou.bike.com.live.module.main.video.activity.WebActivity;
import cyou.bike.com.live.module.main.video.bean.RecVideoList;
import cyou.bike.com.live.module.main.video.contract.VideoDetailContract;
import cyou.bike.com.live.module.main.video.presenter.VideoDetailPresenter;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/29 at 13:49
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoDetailFragment extends BaseFragment<VideoDetailPresenter> implements VideoDetailContract.View {
    private static final String CID1 = "cid1";
    private static final String CID2 = "cid2";
    @BindView(R.id.detail_recycle_view)
    RecyclerView mDetailRecycleView;
    @BindView(R.id.detailrefreshlayiut)
    SmartRefreshLayout mDetailrefreshlayiut;
    Unbinder unbinder;
    private String mCid1;
    private String mCid2;
    private VideoDetailPresenter mPresenter;
    private BaseQuickAdapter mAdapter;

    @Override
    protected Class getThisClass() {
        return getClass();
    }


    @Override
    protected void onFragmentArguements(Bundle arguments) {
        mCid1 = arguments.getString(CID1);
        mCid2 = arguments.getString(CID2);
    }

    @Override
    protected void loadData(View view) {
        mDetailRecycleView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mPresenter = (VideoDetailPresenter) getPresenter();
        mPresenter.attach(this);
        mPresenter.getRecVideoList(mCid1,mCid2,0,20);

    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.detail_fragment;
    }

    @Override
    protected void detach() {
     if (null != mPresenter) {
         mPresenter.detattch();
     }
    }

    public static VideoDetailFragment newInstance(String cid1, String cid2) {
        Bundle args = new Bundle();
        args.putString(CID1, cid1);
        args.putString(CID2, cid2);
        VideoDetailFragment fragment = new VideoDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onErro(String msg) {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onRecVideoList(RecVideoList detailBean) {
        List<RecVideoList.DataBean> data = detailBean.getData();
        mDetailRecycleView.setAdapter(mAdapter= new BaseQuickAdapter<RecVideoList.DataBean,BaseViewHolder>(R.layout.item_content, data) {
            @Override
            protected void convert(BaseViewHolder holder, final RecVideoList.DataBean bean) {
                BindValueHelper valueHelper = holder.itemView.getTag()==null? setTag(holder): (BindValueHelper) holder.itemView.getTag();
                valueHelper.bindValue(bean.getVer_pic(),String.valueOf(1).equals(String.valueOf(1)),false,bean.getView_num()+"", bean.getNickname(), bean.getVideo_title(), bean.getShow_id()+"");
                valueHelper.setOnItemClickListener(new BindValueHelper.OnItemClickListener() {
                    @Override
                    public void click(Context context, String roomId, boolean yanzhi) {
                        WebActivity.start(context,bean.getHash_id(),bean.getVideo_title());
                    }
                });
            }

            private BindValueHelper setTag(BaseViewHolder holder) {
                BindValueHelper  valueHelper = new BindValueHelper(holder);
                holder.itemView.setTag(valueHelper);
                return valueHelper;
            }
        });
        mAdapter.bindToRecyclerView(mDetailRecycleView);
        mAdapter.setEmptyView(R.layout.empty_view);
    }
}
