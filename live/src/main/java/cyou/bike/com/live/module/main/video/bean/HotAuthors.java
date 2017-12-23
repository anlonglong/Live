package cyou.bike.com.live.module.main.video.bean;/**
 * Created by anlonglong on 2017/12/23.
 */

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 15:52
 * <p>
 * Desc: 热门作者
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class HotAuthors extends BaseHttpOutput implements Serializable {

    private static final long serialVersionUID = 2616731364340956322L;
    /**
     * data : [{"author_avatar":"https://apic.douyucdn.cn/upload/avanew/face/201712/15/16/70398dcce27f0599e4df46b9aedef883_middle.jpg","follow_num":"4152766","nickname":"英雄联盟官方赛事","submit_num":806,"up_id":"qy70OVM5RAXG"},{"author_avatar":"https://apic.douyucdn.cn/upload/avanew/face/201710/27/15/30bfcb5821ced2bb6898fedc8ca8f38e_middle.jpg","follow_num":"3709217","nickname":"阿冷aleng丶","submit_num":428,"up_id":"JjAL0pxNaAXr"},{"author_avatar":"https://apic.douyucdn.cn/upload/avanew/face/201706/08/07/a7a8ff739cd49680b8eb7959f0be6790_middle.jpg","follow_num":"923887","nickname":"纳豆nado","submit_num":504,"up_id":"KzAaNmlNB73Q"},{"author_avatar":"https://apic.douyucdn.cn/upload/avanew/face/201704/08/22/c07e98d71d03c7b21cd77bbaf9d61911_middle.jpg","follow_num":"1638932","nickname":"Riot丶LCK","submit_num":491,"up_id":"W67QambEN70O"},{"author_avatar":"https://apic.douyucdn.cn/upload/avatar/face/201609/08/f6c0c08a3f3cb1fd074fe38907ae2508_middle.jpg","follow_num":"10128936","nickname":"芜湖大司马丶","submit_num":1092,"up_id":"rEdl10GqJANM"}]
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
         * author_avatar : https://apic.douyucdn.cn/upload/avanew/face/201712/15/16/70398dcce27f0599e4df46b9aedef883_middle.jpg
         * follow_num : 4152766
         * nickname : 英雄联盟官方赛事
         * submit_num : 806
         * up_id : qy70OVM5RAXG
         */

        private String author_avatar;
        private String follow_num;
        private String nickname;
        private int submit_num;
        private String up_id;

        public String getAuthor_avatar() {
            return author_avatar;
        }

        public void setAuthor_avatar(String author_avatar) {
            this.author_avatar = author_avatar;
        }

        public String getFollow_num() {
            return follow_num;
        }

        public void setFollow_num(String follow_num) {
            this.follow_num = follow_num;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getSubmit_num() {
            return submit_num;
        }

        public void setSubmit_num(int submit_num) {
            this.submit_num = submit_num;
        }

        public String getUp_id() {
            return up_id;
        }

        public void setUp_id(String up_id) {
            this.up_id = up_id;
        }
    }
}
