package cyou.bike.com.live.notuse;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.module.main.home.bean.DigDataRoomBean;
import cyou.bike.com.live.module.main.home.bean.FaceScoreBean;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;
import cyou.bike.com.live.utils.LogUtil;
import io.vov.vitamio.utils.Log;

/**
 * Created by：anlonglong
 * on 2017/11/7 15:48
 * Email: anlonglong0721@gmail.com
 */

public class RecommAdpater<T extends BaseHttpOutput> extends BaseQuickAdapter<BaseHttpOutput,BaseViewHolder> {


    public RecommAdpater( @Nullable List<BaseHttpOutput> data) {
            super(R.layout.recommend_item, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, BaseHttpOutput item) {
       if (item instanceof HotCateBean.DataBean) {
           bindHotCateValue(holder,(HotCateBean.DataBean) item);
       }else if(item instanceof FaceScoreBean.DataBean) {
           bindFaceScoreValue(holder,((FaceScoreBean.DataBean) item));
       } else if (item instanceof DigDataRoomBean.DataBean) {
           bindDigDataRoom(holder,(DigDataRoomBean.DataBean) item);
       }
    }

    private void bindDigDataRoom(BaseViewHolder holder, DigDataRoomBean.DataBean item) {

    }

    private void bindFaceScoreValue(BaseViewHolder holder, FaceScoreBean.DataBean item) {
            holder.setText(R.id.stv_title_info,item.getGame_name());
    }

    private void bindHotCateValue(BaseViewHolder holder, HotCateBean.DataBean item) {
            LogUtil.i(TAG,item.toString());
    }
}
