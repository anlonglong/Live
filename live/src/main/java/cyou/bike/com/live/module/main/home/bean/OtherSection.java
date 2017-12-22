package cyou.bike.com.live.module.main.home.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by：anlonglong
 * on 2017/12/11 11:09
 * Email: anlonglong0721@gmail.com
 */

public class OtherSection extends SectionEntity<HotCateBean.DataBean.RoomListBean> implements Serializable{

    private HotCateBean.DataBean mDataBean;

    public OtherSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public OtherSection(HotCateBean.DataBean.RoomListBean o) {
        super(o);
    }

    public HotCateBean.DataBean getDataBean() {
        return mDataBean;
    }

    public void setDataBean(HotCateBean.DataBean dataBean) {
        mDataBean = dataBean;
    }
}
