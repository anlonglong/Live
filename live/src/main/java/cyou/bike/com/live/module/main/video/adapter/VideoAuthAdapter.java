package cyou.bike.com.live.module.main.video.adapter;/**
 * Created by anlonglong on 2017/12/28.
 */

import android.view.View;
import android.widget.TextView;

import com.allen.library.SuperTextView;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import cyou.bike.com.live.R;
import cyou.bike.com.live.module.main.video.activity.AuthorListActivity;
import cyou.bike.com.live.module.main.video.bean.AuthSection;
import cyou.bike.com.live.module.main.video.bean.HotAuthors;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/28 at 17:09
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoAuthAdapter extends BaseSectionQuickAdapter<AuthSection,BaseViewHolder> {

    public VideoAuthAdapter(List<AuthSection> data) {
        super(R.layout.auth_item, R.layout.item_head, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, AuthSection item) {
        SuperTextView headItem = helper.getView(R.id.stv_title_info);
        headItem.setLeftString(item.header);
    }

    @Override
    protected void convert(BaseViewHolder holder, AuthSection item) {
        if (null != item.t) {
            final HotAuthors.DataBean bean = (HotAuthors.DataBean) item.t;
            SimpleDraweeView simpleDraweeView = holder.getView(R.id.auth_list_item);
            simpleDraweeView.setImageURI(bean.getAuthor_avatar());
            ((TextView) holder.getView(R.id.nickname)).setText(bean.getNickname());
            TextView followNum = holder.getView(R.id.follow_num);
            followNum.setText(bean.getNickname());
            followNum.setText(holder.getConvertView().getResources().getString(R.string.follow,bean.getFollow_num(),bean.getSubmit_num()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AuthorListActivity.start(v.getContext(),bean.getUp_id());
                }
            });
        }

    }
}
