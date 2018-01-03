package cyou.bike.com.live.module.main.video.bean;/**
 * Created by anlonglong on 2017/12/28.
 */

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/28 at 17:10
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class AuthSection extends SectionEntity {
    public AuthSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public AuthSection() {
        super(false, "");
    }
}
