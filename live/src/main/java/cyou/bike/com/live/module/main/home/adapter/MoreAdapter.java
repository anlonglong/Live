package cyou.bike.com.live.module.main.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cyou.bike.com.live.R;
import cyou.bike.com.live.module.live.cellphonelive.CellPhoneLiveActivity;
import cyou.bike.com.live.module.main.home.bean.ThreeCateData;

/**
 * Created by：anlonglong
 * on 2017/12/14 22:09
 * Email: anlonglong0721@gmail.com
 */

public class MoreAdapter extends BaseQuickAdapter<ThreeCateData.DataBean,BaseViewHolder> {

    public MoreAdapter(@Nullable List<ThreeCateData.DataBean> data) {
        super(R.layout.item_content,data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ThreeCateData.DataBean bean) {
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
