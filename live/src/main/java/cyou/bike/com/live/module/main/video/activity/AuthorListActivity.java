package cyou.bike.com.live.module.main.video.activity;/**
 * Created by anlonglong on 2017/12/31.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.vondear.rxtools.view.RxToast;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseActivity;
import cyou.bike.com.live.module.main.home.adapter.BindValueHelper;
import cyou.bike.com.live.module.main.video.bean.AuthorList;
import cyou.bike.com.live.module.main.video.contract.AuthorListContract;
import cyou.bike.com.live.module.main.video.presenter.AuthorListPresenter;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/31 at 11:16
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class AuthorListActivity extends BaseActivity<AuthorListPresenter> implements AuthorListContract.View, OnRefreshListener, OnLoadmoreListener {


    private static final String UP_ID = "up_id";
    @BindView(R.id.author_recycle_view)
    RecyclerView mAuthorRecycleView;
    @BindView(R.id.author_srl)
    SmartRefreshLayout mAuthorSrl;
    private AuthorListPresenter mPresenter;
    private String mUpId;
    private BaseQuickAdapter mAdapter;
    private List<AuthorList.DataBean> mAuthList;

    public static void start(Context context, String upId) {
        Intent starter = new Intent(context, AuthorListActivity.class);
        starter.putExtra(UP_ID, upId);
        context.startActivity(starter);
    }

    @Override
    protected void initListener() {
        mAuthorSrl.setOnRefreshListener(this);
        mAuthorSrl.setOnLoadmoreListener(this);
    }

    @Override
    protected void onEvent() {
        mUpId = getIntent().getStringExtra(UP_ID);
        mPresenter = (AuthorListPresenter) getPresenter();
        mPresenter.attach(this);
        mAuthorSrl.autoRefresh();
        //mPresenter.getAuthorVidList(mUpId,0,20);
    }

    @Override
    protected void attach() {
        if (null != mPresenter) {
            mPresenter.attach(this);
        }
    }

    @Override
    protected int getContentViewId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_author_list;
    }

    @Override
    protected void detech() {
        if (null != mPresenter) {
            mPresenter.detattch();
        }
    }

    @Override
    public void onErro(String msg) {
        RxToast.error(msg);
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onAuthorList(AuthorList list) {
        if (mAuthorSrl.isRefreshing()) {
            mAuthorSrl.finishRefresh();
            mAuthList = list.getData();
            mAuthorRecycleView.setLayoutManager(new GridLayoutManager(this,2));
            mAuthorRecycleView.setHasFixedSize(true);
            mAuthorRecycleView.setAdapter(mAdapter = new BaseQuickAdapter<AuthorList.DataBean,BaseViewHolder>(R.layout.video_item_content,mAuthList) {
                @Override
                protected void convert(BaseViewHolder holder, final AuthorList.DataBean item) {
                    BindValueHelper helper = holder.itemView.getTag() == null?setTag(holder): (BindValueHelper) holder.itemView.getTag();
                    helper.binderVideoValue(item.getVer_pic(),item.getStatus()+"",item.getVideo_title(),item.getNickname(),item.getView_num(),item.getHash_id());
                    helper.setOnItemClickListener(new BindValueHelper.OnItemClickListener() {
                        @Override
                        public void click(Context context, String roomId, boolean yanzhi) {
                            WebActivity.start(context,item.getHash_id(),item.getVideo_title());
                        }
                    });
                }

                private BindValueHelper setTag(BaseViewHolder holder) {
                    BindValueHelper valueHelper = new BindValueHelper(holder);
                    holder.itemView.setTag(valueHelper);
                    return valueHelper;
                }
            });
        }else {
            mAuthorSrl.finishLoadmore();
            mAuthorRecycleView.smoothScrollToPosition(mAuthList.size());

            mAdapter.addData(list.getData());
        }


    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.getAuthorVidList(mUpId,0,20);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getAuthorVidList(mUpId,mAdapter.getData().size(),20);
    }
}
