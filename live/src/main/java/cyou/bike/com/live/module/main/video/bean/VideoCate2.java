package cyou.bike.com.live.module.main.video.bean;/**
 * Created by anlonglong on 2017/12/29.
 */

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/29 at 12:50
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoCate2 extends BaseHttpOutput implements Serializable {
    private static final long serialVersionUID = 7560168111705840989L;

    /**
     * error : 0
     * data : [{"cid2":"104","cate2_name":"绝地求生","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/19/c87a4a9f7b38837d5abcd530f18ff179.jpg","cid1":"102","recommend":"1"},{"cid2":"103","cate2_name":"主机游戏","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/19/c421325aa7b29ace2563c386bd6fb7e1.jpg","cid1":"102","recommend":"0"},{"cid2":"107","cate2_name":"怀旧游戏","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/19/4079d445d68aec076e242714840a30b6.jpg","cid1":"102","recommend":"0"},{"cid2":"106","cate2_name":"我的世界","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/19/37eda9d28fa1de57eab868c21ac322e2.jpg","cid1":"102","recommend":"0"},{"cid2":"105","cate2_name":"独立游戏","mobile_icon":"https://cs-op.douyucdn.cn/vod-index/2017/09/19/8e309d4a8e7c2dc71070cada5f2d18bf.jpg","cid1":"102","recommend":"0"}]
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
         * cid2 : 104
         * cate2_name : 绝地求生
         * mobile_icon : https://cs-op.douyucdn.cn/vod-index/2017/09/19/c87a4a9f7b38837d5abcd530f18ff179.jpg
         * cid1 : 102
         * recommend : 1
         */

        private String cid2;
        private String cate2_name;
        private String mobile_icon;
        private String cid1;
        private String recommend;

        public String getCid2() {
            return cid2;
        }

        public void setCid2(String cid2) {
            this.cid2 = cid2;
        }

        public String getCate2_name() {
            return cate2_name;
        }

        public void setCate2_name(String cate2_name) {
            this.cate2_name = cate2_name;
        }

        public String getMobile_icon() {
            return mobile_icon;
        }

        public void setMobile_icon(String mobile_icon) {
            this.mobile_icon = mobile_icon;
        }

        public String getCid1() {
            return cid1;
        }

        public void setCid1(String cid1) {
            this.cid1 = cid1;
        }

        public String getRecommend() {
            return recommend;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }
    }
}
