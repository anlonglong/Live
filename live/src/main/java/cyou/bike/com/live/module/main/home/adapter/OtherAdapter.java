package cyou.bike.com.live.module.main.home.adapter;

import android.content.Context;

import com.allen.library.SuperTextView;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cyou.bike.com.live.R;
import cyou.bike.com.live.module.videocontroller.cellphonelive.CellPhoneLiveActivity;
import cyou.bike.com.live.module.main.home.activity.MoreActivity;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.module.main.home.bean.OtherSection;

/**
 * Created by：anlonglong
 * on 2017/12/11 11:05
 * Email: anlonglong0721@gmail.com
 */

public class OtherAdapter extends BaseSectionQuickAdapter<OtherSection,BaseViewHolder> {

    public OtherAdapter(List<OtherSection> data) {
        super(R.layout.item_content, R.layout.item_head, data);
    }


    @Override
    protected void convertHead(final BaseViewHolder helper, final OtherSection item) {
        SuperTextView headItem = helper.getView(R.id.stv_title_info);
        headItem.setLeftString(item.header);
        headItem.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
            @Override
            public void onClickListener(SuperTextView superTextView) {
                HotCateBean.DataBean.RoomListBean t = getData().get(helper.getLayoutPosition()).t;
                if (null != t) {
                    MoreActivity.startActivity(superTextView.getContext(), superTextView.getLeftString(), t.getCate_id()+"");
                }
            }
        });
    }

    @Override
    protected void convert(BaseViewHolder holder, OtherSection item) {
//        OtherAdapter.HolderViewBinder holderViewBinder = holder.itemView.getTag() == null ? getBindHolder(holder) : (OtherAdapter.HolderViewBinder) holder.itemView.getTag();
//        holderViewBinder.bindValue(item);
        final BindValueHelper valueHelper = new BindValueHelper(holder);
        valueHelper.bindValue(new BindValueHelper.BindValueListener<OtherSection>() {
            @Override
            public void bindValue(OtherSection o) {
                HotCateBean.DataBean.RoomListBean item = o.t;
                valueHelper.bindValue(item.getRoom_src(), String.valueOf(item.getShow_status()).equals(String.valueOf(1)), false, item.getOnline(), item.getNickname(), item.getRoom_name(), item.getRoom_id());
            }
        },item);
        valueHelper.setOnItemClickListener(new BindValueHelper.OnItemClickListener() {
            @Override
            public void click(Context context, String roomId, boolean yanzhi) {
                CellPhoneLiveActivity.start(context,roomId,yanzhi);
            }
        });

    }

//    private OtherAdapter.HolderViewBinder getBindHolder(BaseViewHolder holder) {
//        OtherAdapter.HolderViewBinder holderViewBinder = new OtherAdapter.HolderViewBinder(holder);
//        holder.itemView.setTag(holderViewBinder);
//        return holderViewBinder;
//    }

//    class HolderViewBinder {
//
//        private SparseArray<View> mViews;
//        private BaseViewHolder mHolder;
//        private View mItemView;
//
//        HolderViewBinder(BaseViewHolder holder) {
//            this.mHolder = holder;
//            this.mItemView = holder.itemView;
//            mViews = new SparseArray<>();
//        }
//
//
//        @SuppressWarnings("unchecked")
////作用:去掉一些让人看着不舒服的下划线
//        void bindValue(OtherSection mSection) {
//            HotCateBean.DataBean.RoomListBean item = mSection.t;
//            bindValue(item.getRoom_src(), String.valueOf(item.getShow_status()).equals(String.valueOf(1)), false, item.getOnline(), item.getNickname(), item.getRoom_name(), item.getRoom_id());
//        }
//
//        private void bindValue(String imageUrl, boolean liveing, boolean isFromFaceValue, String onLinePeople, String liveName, String roomName, String roomId) {
//            setLiveImageBg(R.id.hot_item_img, imageUrl);
//            setLiveIconVisibility(R.id.iv_live, liveing, isFromFaceValue);
//            setOnLinePeople(R.id.online_people_count, onLinePeople);
//            setLiveName(R.id.live_name, liveName);
//            setRoomName(R.id.live_rome_name, roomName);
//            setOnItemChildClickListener(roomId, isFromFaceValue);
//        }
//
//        void setOnItemChildClickListener(final String roomId, final boolean isFaceScore) {
//            mItemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    CellPhoneLiveActivity.start(mContext, roomId, isFaceScore);
//                }
//            });
//        }
//
//
//        void setLiveImageBg(@IdRes int id, String img_url) {
//            SimpleDraweeView live = bindView(id);
//            live.setImageURI(img_url);
//        }
//
//        void setLiveIconVisibility(@IdRes int id, boolean isVisible, boolean isFromFaceValue) {
//            ImageView live = bindView(id);
//            live.setBackgroundResource(isFromFaceValue ? R.drawable.search_header_live_type_mobile : R.drawable.search_header_live_type_pc);
//            live.setVisibility(isVisible ? View.VISIBLE : View.GONE);
//        }
//
//        void setLiveName(@IdRes int id, String liveName) {
//            TextView lvName = bindView(id);
//            lvName.setText(liveName);
//        }
//
//        void setOnLinePeople(@IdRes int id, String count) {
//            SuperTextView linePeople = bindView(id);
//            linePeople.setCenterString(count);
//        }
//
//        void setRoomName(@IdRes int id, String liveName) {
//            TextView name = bindView(id);
//            name.setText(liveName);
//        }
//
//        @SuppressWarnings("unchecked")//作用:去掉一些让人看着不舒服的下划线
//        private <T extends View> T bindView(@IdRes int id) {
//            T t = (T) mViews.get(id);
//            if (null == t) {
//                t = (T) mItemView.findViewById(id);
//                mViews.put(id, t);
//            }
//            return t;
//        }
//    }
}
