package cyou.bike.com.live.module.main.video.bean;/**
 * Created by anlonglong on 2017/12/23.
 */

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 15:47
 * <p>
 * Desc: 导航标题数据载体
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoHomeCate extends BaseHttpOutput implements Serializable{

    private static final long serialVersionUID = -2136758156737892807L;
    /**
     * data : [{"cate1_name":"游戏竞技","cid1":"1","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/12/e17f24d55792bf6ab491227bbea5a901.png"},{"cate1_name":"客厅游戏","cid1":"102","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/12/ce5a5bdc6d32b89bb29bec8349c55fcb.png"},{"cate1_name":"移动游戏","cid1":"51","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/12/92f72a17e8fb0ca887bf99f3288bd430.png"},{"cate1_name":"星秀娱乐","cid1":"3","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/10/27/20372ed0dd7e1ab866a6fe1d953dc7d6.png"},{"cate1_name":"数码科技","cid1":"108","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/19/033302d1c2f94532891d88cca5320bc3.png"},{"cate1_name":"文娱课堂","cid1":"109","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/19/356071804aa7c31193210a0fb6daf902.png"},{"cate1_name":"正能量","cid1":"129","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/11/01/c397d386c134310eda1a1c45ea8b9945.png"}]
     * error : 0
     */

    private int error;
    private List<DataBean> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cate1_name : 游戏竞技
         * cid1 : 1
         * mobile_icon : https://cs-op.douyucdn.cn/vod-index/2017/09/12/e17f24d55792bf6ab491227bbea5a901.png
         */

        private String cate1_name;
        private String cid1;
        private String mobile_icon;

        public String getCate1_name() {
            return cate1_name;
        }

        public void setCate1_name(String cate1_name) {
            this.cate1_name = cate1_name;
        }

        public String getCid1() {
            return cid1;
        }

        public void setCid1(String cid1) {
            this.cid1 = cid1;
        }

        public String getMobile_icon() {
            return mobile_icon;
        }

        public void setMobile_icon(String mobile_icon) {
            this.mobile_icon = mobile_icon;
        }
    }
}
