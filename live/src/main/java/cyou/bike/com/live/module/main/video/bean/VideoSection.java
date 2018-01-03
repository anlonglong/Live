package cyou.bike.com.live.module.main.video.bean;/**
 * Created by anlonglong on 2017/12/24.
 */

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/24 at 12:51
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoSection extends SectionEntity<VideoItemSection> {

    private boolean isMore;

    public VideoSection(boolean isHeader, String header,boolean more) {
        super(isHeader, header);
        this.isMore = more;
    }

    public VideoSection(VideoItemSection itemSection) {
        super(itemSection);
    }

    public boolean isMore() {
        return isMore;
    }

    public void setMore(boolean more) {
        isMore = more;
    }
}
