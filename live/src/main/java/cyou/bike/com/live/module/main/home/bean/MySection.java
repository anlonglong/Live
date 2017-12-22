package cyou.bike.com.live.module.main.home.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by：anlonglong
 * on 2017/11/21 16:32
 * Email: anlonglong0721@gmail.com
 */

public class MySection extends SectionEntity<ItemSection>{

    private boolean isMore;
    public MySection(boolean isHeader, String header,boolean isMore) {
        super(isHeader,header);
        this.isMore = isMore;
    }

    public MySection(ItemSection section) {
        super(section);
    }


    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}
