package cyou.bike.com.live.module.main.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vondear.rxtools.view.RxToast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.module.main.home.activity.MoreActivity;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/12/11 17:58
 * Email: anlonglong0721@gmail.com
 */

public class OtherTopListAFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.other_top_list)
    RecyclerView mOtherTopRecycleView;
    private static List<HotCateBean.DataBean> mOtherSectionList;
    private  BaseQuickAdapter mQuickAdapter;

    @Override
    protected Class getThisClass() {
        return this.getClass();
    }

    @Override
    protected void loadData(View view) {
        LogUtil.i("OtherTopListAFragment","size = "+mOtherSectionList.size());
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        mOtherTopRecycleView.setHasFixedSize(true);
        mOtherTopRecycleView.setLayoutManager(layoutManager);
        if (null != mOtherSectionList && !mOtherSectionList.isEmpty()) {
            mOtherTopRecycleView.setAdapter(mQuickAdapter = new BaseQuickAdapter<HotCateBean.DataBean,BaseViewHolder>(R.layout.other_top_list_item, mOtherSectionList) {

                @Override
                protected void convert(BaseViewHolder holder, HotCateBean.DataBean item) {
                    SimpleDraweeView view = holder.getView(R.id.top_list_item);
                    TextView name = holder.getView(R.id.top_list_item_name);
                    view.setImageURI(item.getIcon_url());
                    name.setText(item.getTag_name());
                }
            });
        }
        mQuickAdapter.setOnItemClickListener(this);
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.other_top_list;
    }

    @Override
    protected void detach() {

    }


    public static OtherTopListAFragment newInstance(List<HotCateBean.DataBean> list) {
        mOtherSectionList = list;
        OtherTopListAFragment fragment = new OtherTopListAFragment();
        return fragment;
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        List<HotCateBean.DataBean> data = adapter.getData();
        RxToast.success(data.get(position).getTag_name());
        MoreActivity.startActivity(view.getContext(),data.get(position).getTag_name(),data.get(position).getTag_id());
    }
}
