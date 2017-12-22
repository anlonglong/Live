package cyou.bike.com.live.module.main.home.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by：anlonglong
 * on 2017/12/14 22:17
 * Email: anlonglong0721@gmail.com
 */

public class MoreSection extends SectionEntity<ThreeCateData.DataBean> {

    private ThreeCateData.DataBean mBean;

    public MoreSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public void setBean(ThreeCateData.DataBean bean) {
        mBean = bean;
    }

    public ThreeCateData.DataBean getBean() {
        return mBean;
    }
}
