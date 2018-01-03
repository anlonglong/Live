package cyou.bike.com.live.module.main.home.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.allen.library.SuperTextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import cyou.bike.com.live.R;

/**
 * Created by：anlonglong
 * on 2017/12/12 10:36
 * Email: anlonglong0721@gmail.com
 * 根据推荐fragmnet和其他fragment的adapter抽取出来的一个绑定适配器数据的工具类
 */

public class BindValueHelper {
    private SparseArray<View> mViews;
    private BaseViewHolder mHolder;
    private View mItemView;
    private OnItemClickListener mListener;

    public BindValueHelper(BaseViewHolder holder) {
        this.mHolder = holder;
        this.mItemView = holder.itemView;
        mViews = new SparseArray<>();
    }


    /**
     * 由于每个Fragment中的数据是不一样的,所以绑定数据之前的逻辑也不一样,用一个接口来实现每个页面
     * 在绑定数据之前一些逻辑判断.
     * @param <T> 因为每个条目所对应的数据类型是不一样的,所以用泛型来代替,实际实现该接口的时候会传入具体的类型实例.
     */
    public <T> void  bindValue(BindValueListener<T> bindValueListener,T t) {
        bindValueListener.bindValue(t);
    }


    public interface BindValueListener<T> {
       void bindValue(T t);
    }

    /**
     * 每一个条目的点击事件
     */
    public interface OnItemClickListener {
       void click(Context context,String roomId,boolean yanzhi);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
     this.mListener =listener;
    }
    String coverSrc;
    String repo;
    String title;
    String name;
    String number;
    public void binderVideoValue(String coverSrc, String repo, String titile, String name, String number, final String hashId) {
        setLiveImageBg(R.id.video_item_img, coverSrc);
        setText(R.id.video_people_count,repo);
        setText(R.id.live_rome_name,titile);
        setText(R.id.video_name,name);
        setText(R.id.live_play_time,number);
        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                mListener.click(mItemView.getContext(),hashId,false);
            }
        });
    }

    public void  bindValue(String imageUrl, boolean liveing, boolean isFromFaceValue, String onLinePeople, String liveName, String roomName, String roomId) {
        setLiveImageBg(R.id.hot_item_img, imageUrl);
        setLiveIconVisibility(R.id.iv_live, liveing, isFromFaceValue);
        setOnLinePeople(R.id.online_people_count, onLinePeople);
        setLiveName(R.id.live_name, liveName);
        setRoomName(R.id.live_rome_name, roomName);
        setOnItemChildClickListener(roomId, isFromFaceValue);
    }

    private void setOnItemChildClickListener(final String roomId, final boolean isFaceScore) {
        mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.click(mItemView.getContext(),roomId,isFaceScore);
                }
            }
        });
    }


    public void setLiveImageBg(@IdRes int id, String img_url) {
        SimpleDraweeView live = bindView(id);
        live.setImageURI(img_url);
    }

    public void setLiveIconVisibility(@IdRes int id, boolean isVisible, boolean isFromFaceValue) {
        ImageView live = bindView(id);
        live.setBackgroundResource(isFromFaceValue ? R.drawable.search_header_live_type_mobile : R.drawable.search_header_live_type_pc);
        live.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    public  void setLiveName(@IdRes int id, String liveName) {
        TextView lvName = bindView(id);
        lvName.setText(liveName);
    }

    public void setOnLinePeople(@IdRes int id, String count) {
        SuperTextView linePeople = bindView(id);
        linePeople.setCenterString(count);
    }

    public void setRoomName(@IdRes int id, String liveName) {
        TextView name = bindView(id);
        name.setText(liveName);
    }

    public void setText(@IdRes int id, String text) {
        TextView name = bindView(id);
        name.setText(text);
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
