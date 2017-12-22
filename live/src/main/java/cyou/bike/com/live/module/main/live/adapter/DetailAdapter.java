package cyou.bike.com.live.module.main.live.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cyou.bike.com.live.R;
import cyou.bike.com.live.module.live.cellphonelive.CellPhoneLiveActivity;
import cyou.bike.com.live.module.main.home.adapter.BindValueHelper;
import cyou.bike.com.live.module.main.live.bean.DetailBean;

/**
 * Created by：anlonglong
 * on 2017/12/17 12:45
 * Email: anlonglong0721@gmail.com
 */

public class DetailAdapter extends BaseQuickAdapter<DetailBean.DataBean,BaseViewHolder> {


    public DetailAdapter(@Nullable List<DetailBean.DataBean> data) {
        super(R.layout.item_content, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, DetailBean.DataBean bean) {
        BindValueHelper valueHelper = holder.itemView.getTag()==null? setTag(holder): (BindValueHelper) holder.itemView.getTag();
        valueHelper.bindValue(bean.getRoom_src(),String.valueOf(bean.getShow_status()).equals(String.valueOf(1)),false,bean.getOnline()+"", bean.getNickname(), bean.getRoom_name(), bean.getRoom_id());
        valueHelper.setOnItemClickListener(new BindValueHelper.OnItemClickListener() {
            @Override
            public void click(Context context, String roomId, boolean yanzhi) {
                CellPhoneLiveActivity.start(context,roomId,yanzhi);
            }
        });
    }

    private BindValueHelper setTag(BaseViewHolder holder) {
        BindValueHelper  valueHelper = new BindValueHelper(holder);
        holder.itemView.setTag(valueHelper);
        return valueHelper;
    }
}
