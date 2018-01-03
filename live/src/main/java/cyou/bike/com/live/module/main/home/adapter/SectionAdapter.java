package cyou.bike.com.live.module.main.home.adapter;


import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allen.library.SuperTextView;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import cyou.bike.com.live.R;
import cyou.bike.com.live.module.videocontroller.cellphonelive.CellPhoneLiveActivity;
import cyou.bike.com.live.module.main.home.activity.MoreActivity;
import cyou.bike.com.live.module.main.home.bean.DigDataRoomBean;
import cyou.bike.com.live.module.main.home.bean.FaceScoreBean;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.module.main.home.bean.MySection;
import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/11/21 16:34
 * Email: anlonglong0721@gmail.com
 */

public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {

    private static final String TAG = SectionAdapter.class.getSimpleName();


    public SectionAdapter(List<MySection> data) {
        super(R.layout.item_content, R.layout.item_head, data);
    }

    @Override
    protected void convertHead(final BaseViewHolder helper, MySection item) {
        SuperTextView headItem = helper.getView(R.id.stv_title_info);
        headItem.setLeftString(item.header);
        int iconId;
        switch (item.header) {
            case "最热":
                iconId = R.drawable.reco_game_txt_icon;
                break;
            case "颜值":
                iconId = R.drawable.icon_reco_mobile;
                break;
            default:
                iconId = R.drawable.icon_column;
                break;
        }
        headItem.setLeftIcon(iconId);

        if (item.isMore()) {
            headItem.setOnSuperTextViewClickListener(new SuperTextView.OnSuperTextViewClickListener() {
                @Override
                public void onClickListener(SuperTextView superTextView) {
                    LogUtil.i(TAG, superTextView.getLeftString());
                     MySection mySection = getData().get(helper.getLayoutPosition());
                     String mCateId = "";
                    if (null != mySection.t) {
                        if (mySection.t.getHotCateDataBean() != null && (mySection.t.getHotCateDataBean() instanceof HotCateBean.DataBean.RoomListBean)) {
                            mCateId = mySection.t.getHotCateDataBean().getCate_id()+"";
                        } else if (null != mySection.t.getDataBean() && mySection.t.getDataBean() instanceof DigDataRoomBean.DataBean) {
                            mCateId = mySection.t.getDataBean().getCate_id()+"";
                        } else if (null != mySection.t.getFaceScoreDataBean() && mySection.t.getFaceScoreDataBean() instanceof FaceScoreBean.DataBean) {
                            mCateId = mySection.t.getFaceScoreDataBean().getCate_id()+"";
                        }
                        MoreActivity.startActivity(superTextView.getContext(), superTextView.getLeftString(), mCateId);
                    }
                }
            });
        }

    }

    @Override
    protected void convert(BaseViewHolder holder, MySection item) {
        //LogUtil.i(TAG, "position = " + holder.getLayoutPosition());
        //HolderViewBinder holderViewBinder = null;
//        if (holder.itemView.getTag() == null) {
//            getBindHolder(holder);
//        }
//        ((HolderViewBinder) holder.itemView.getTag()).bindValue(item);

        HolderViewBinder holderViewBinder = holder.itemView.getTag() == null ? getBindHolder(holder) : (HolderViewBinder) holder.itemView.getTag();
        holderViewBinder.bindValue(item);
    }

    private HolderViewBinder getBindHolder(BaseViewHolder holder) {
        HolderViewBinder holderViewBinder = new HolderViewBinder(holder);
        holder.itemView.setTag(holderViewBinder);
        return holderViewBinder;
    }
/*
    @SuppressWarnings("unused")
    private void bindDigDataRoom(BaseViewHolder holder, DigDataRoomBean.DataBean item) {
        SimpleDraweeView sdv = holder.getView(R.id.hot_item_img);
        if (item.getShow_status() != 1) {
            ImageView live = holder.getView(R.id.iv_live);
            live.setVisibility(View.GONE);
        }
        SuperTextView count = holder.getView(R.id.online_people_count);
        TextView name = holder.getView(R.id.live_name);
        TextView desc = holder.getView(R.id.live_rome_name);
        sdv.setImageURI(item.getRoom_src());
        count.setCenterString(item.getOnline());
        name.setText(item.getNickname());
        desc.setText(item.getRoom_name());
    }

    @SuppressWarnings("unused")
    private void bindFaceScoreValue(BaseViewHolder holder, FaceScoreBean.DataBean item) {
        SimpleDraweeView sdv = holder.getView(R.id.hot_item_img);
        if (item.getShow_status().equals(String.valueOf(1))) {
            ImageView live = holder.getView(R.id.iv_live);
            live.setVisibility(View.GONE);
        }
        SuperTextView count = holder.getView(R.id.online_people_count);
        TextView name = holder.getView(R.id.live_name);
        TextView desc = holder.getView(R.id.live_rome_name);
        sdv.setImageURI(item.getRoom_src());
        count.setCenterString(String.valueOf(item.getOnline()));
        name.setText(item.getNickname());
        desc.setText(item.getRoom_name());
    }

    @SuppressWarnings("unused")
    private void bindHotCateValue(BaseViewHolder holder, HotCateBean.DataBean data) {
        for (int i = 0; i < data.getRoom_list().size(); i++) {
            HotCateBean.DataBean.RoomListBean item = data.getRoom_list().get(i);
            SimpleDraweeView sdv = holder.getView(R.id.hot_item_img);
            if (item.getShow_status() != 1) {
                ImageView live = holder.getView(R.id.iv_live);
                live.setVisibility(View.GONE);
            }
            SuperTextView count = holder.getView(R.id.online_people_count);
            TextView name = holder.getView(R.id.live_name);
            TextView desc = holder.getView(R.id.live_rome_name);
            sdv.setImageURI(item.getRoom_src());
            count.setCenterString(item.getOnline());
            name.setText(item.getNickname());
            desc.setText(item.getRoom_name());
        }
    }*/


    @SuppressWarnings({"unused", "WeakerAccess"})
//作用:去掉未使用方法下面的下划线,强迫症,让人看着不舒服.
    class HolderViewBinder {

        private SparseArray<View> mViews;
        private BaseViewHolder mHolder;
        private View mItemView;

        HolderViewBinder(BaseViewHolder holder) {
            this.mHolder = holder;
            this.mItemView = holder.itemView;
            mViews = new SparseArray<>();
        }


        @SuppressWarnings("unchecked")
//作用:去掉一些让人看着不舒服的下划线
        void bindValue(MySection section) {
            if (null != section.t) {
                boolean liveing;
                String imageUrl;
                String onLinePeople;
                String liveName;
                String roomName;
                String roomId;
                if (section.t.getHotCateDataBean() != null && (section.t.getHotCateDataBean() instanceof HotCateBean.DataBean.RoomListBean)) {
                    HotCateBean.DataBean.RoomListBean item = section.t.getHotCateDataBean();
                    liveing = String.valueOf(item.getShow_status()).equals(String.valueOf(1));
                    imageUrl = item.getRoom_src();
                    onLinePeople = item.getOnline();
                    liveName = item.getNickname();
                    roomName = item.getRoom_name();
                    roomId = item.getRoom_id();
                    bindValue(imageUrl, liveing, false, onLinePeople, liveName, roomName, roomId);
                    //}
                } else if (null != section.t.getDataBean() && section.t.getDataBean() instanceof DigDataRoomBean.DataBean) {
                    DigDataRoomBean.DataBean dataBean = section.t.getDataBean();
                    liveing = String.valueOf(dataBean.getShow_status()).equals(String.valueOf(1));
                    imageUrl = dataBean.getRoom_src();
                    onLinePeople = dataBean.getOnline();
                    liveName = dataBean.getNickname();
                    roomName = dataBean.getRoom_name();
                    roomId = dataBean.getRoom_id();
                    bindValue(imageUrl, liveing, false, onLinePeople, liveName, roomName, roomId);
                } else if (null != section.t.getFaceScoreDataBean() && section.t.getFaceScoreDataBean() instanceof FaceScoreBean.DataBean) {

                    FaceScoreBean.DataBean dataBean = section.t.getFaceScoreDataBean();
                    liveing = String.valueOf(dataBean.getShow_status()).equals(String.valueOf(1));
                    imageUrl = dataBean.getRoom_src();
                    onLinePeople = String.valueOf(dataBean.getOnline());
                    liveName = dataBean.getNickname();
                    roomName = dataBean.getRoom_name();
                    roomId = dataBean.getRoom_id();
                    bindValue(imageUrl, liveing, true, onLinePeople, liveName, roomName, roomId);
                }
            }
        }

        private void bindValue(String imageUrl, boolean liveing, boolean isFromFaceValue, String onLinePeople, String liveName, String roomName, String roomId) {
            setLiveImageBg(R.id.hot_item_img, imageUrl);
            setLiveIconVisibility(R.id.iv_live, liveing, isFromFaceValue);
            setOnLinePeople(R.id.online_people_count, onLinePeople);
            setLiveName(R.id.live_name, liveName);
            setRoomName(R.id.live_rome_name, roomName);
            setOnItemChildClickListener(roomId, isFromFaceValue);
        }

        void setOnItemChildClickListener(final String roomId, final boolean isFaceScore) {
            mItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CellPhoneLiveActivity.start(mContext, roomId, isFaceScore);
                }
            });
        }


        void setLiveImageBg(@IdRes int id, String img_url) {
            SimpleDraweeView live = bindView(id);
            live.setImageURI(img_url);
        }

        void setLiveIconVisibility(@IdRes int id, boolean isVisible, boolean isFromFaceValue) {
            ImageView live = bindView(id);
            live.setBackgroundResource(isFromFaceValue ? R.drawable.search_header_live_type_mobile : R.drawable.search_header_live_type_pc);
            live.setVisibility(isVisible ? View.VISIBLE : View.GONE);
        }

        void setLiveName(@IdRes int id, String liveName) {
            TextView lvName = bindView(id);
            lvName.setText(liveName);
        }

        void setOnLinePeople(@IdRes int id, String count) {
            SuperTextView linePeople = bindView(id);
            linePeople.setCenterString(count);
        }

        void setRoomName(@IdRes int id, String liveName) {
            TextView name = bindView(id);
            name.setText(liveName);
        }

        @SuppressWarnings("unchecked")//作用:去掉一些让人看着不舒服的下划线
        private <T extends View> T bindView(@IdRes int id) {
            T t = (T) mViews.get(id);
            if (null == t) {
                t = (T) mItemView.findViewById(id);
                mViews.put(id, t);
            }
            return t;
        }

    }
}
