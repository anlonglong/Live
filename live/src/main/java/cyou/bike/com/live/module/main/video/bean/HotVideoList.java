package cyou.bike.com.live.module.main.video.bean;/**
 * Created by anlonglong on 2017/12/23.
 */

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/23 at 15:49
 * <p>
 * Desc: 最热数据
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class HotVideoList extends BaseHttpOutput implements Serializable {

    private static final long serialVersionUID = 5036233235043520525L;
    /**
     * data : [{"cid1":3,"cid2":43,"ctime":1514008080,"hash_id":"XNbwE7Z6q3p7n5Zz","is_replay":0,"is_vertical":0,"nickname":"花邪v","point_id":2287761,"ranktype":"25","recomType":"1","rpos":"31","up_id":"5byARb6Y0A69","utime":1514008140,"video_content":"独宠小周周  Everybody Knows I Love You - Lovebugs","video_cover":"https://cs-op.douyucdn.cn/vod-cover/2017/12/23/b5fbd892d8dc612dbfaa8fe92789805c.jpg","video_duration":163.4,"video_source":2,"video_status":0,"video_title":"独宠小周周","view_num":113},{"cid1":1,"cid2":5,"ctime":1513980120,"hash_id":"YGnzXvb6bVVv462l","is_replay":0,"is_vertical":0,"nickname":"起小点是大腿","point_id":2285560,"ranktype":"25","recomType":"1","rpos":"31","up_id":"y9LA15JV6AqW","utime":1513980120,"video_content":"微博：@起小点是大腿 @主播真会玩 主播真会玩粉丝群： 628803117 商务邮箱：bd@shidatui.com","video_cover":"https://cs-op.douyucdn.cn/vod-cover/2017/12/23/536c99295ee3f2401dc6d917ecc9f268.jpg","video_duration":769.72,"video_source":2,"video_status":0,"video_title":"【主播真会玩】121：马老师的超电磁炮","view_num":3087},{"cid1":51,"cid2":49,"ctime":1514001600,"hash_id":"YAox276jVwL7Vz8Z","is_replay":0,"is_vertical":0,"nickname":"KPL王者荣耀职业联赛","point_id":2287285,"ranktype":"25","recomType":"1","rpos":"31","up_id":"OxwXnKl3QAGk","utime":1514001600,"video_content":"一众主播为KPL总决赛加油！","video_cover":"https://cs-op.douyucdn.cn/vod-cover/2017/12/23/4e1be27762855d64e9973bed72d23504.jpg","video_duration":47.8,"video_source":2,"video_status":0,"video_title":"【KPL总决赛倒计时0天】一众主播为KPL总决赛加油！","view_num":4623},{"cid1":3,"cid2":27,"ctime":1514002981,"hash_id":"9DO84vrLj2GMedGr","is_replay":0,"is_vertical":0,"nickname":"DY星闻","point_id":2287396,"ranktype":"25","recomType":"1","rpos":"31","up_id":"08AeKjv8NwqL","utime":1514003161,"video_content":"","video_cover":"https://cs-op.douyucdn.cn/vod-cover/2017/12/23/76b9f8935b43cda957bf201fdd64764a.jpg","video_duration":114.44,"video_source":2,"video_status":0,"video_title":"冯提莫街头卖烧饼，观众不慎泄露电话号码，遭爆破","view_num":693},{"cid1":3,"cid2":101,"ctime":1514005981,"hash_id":"Z1LDR7Q65nmMJzx8","is_replay":0,"is_vertical":1,"nickname":"会飞的雯子","point_id":2287618,"ranktype":"25","recomType":"1","rpos":"31","up_id":"JGdyY4Z5adXy","utime":1514006160,"video_content":"","video_cover":"https://cs-op.douyucdn.cn/vod-cover/2017/12/23/ab2651cd007c6ce75a70eca5ed735640.jpeg","video_duration":13.84,"video_source":2,"video_status":0,"video_title":"会飞的雯子发布了一个斗鱼视频2017-12-23","view_num":199},{"cid1":102,"cid2":104,"ctime":1513932301,"hash_id":"wkDe0W2ELL8MA4Bz","is_replay":0,"is_vertical":0,"nickname":"主播油条","point_id":2280159,"ranktype":"25","recomType":"1","rpos":"31","up_id":"a1nAzeya5dXJ","utime":1513932301,"video_content":"绝地求生大逃杀，主播油条惜败与喷子。盆子面前人人平等。","video_cover":"https://cs-op.douyucdn.cn/vod-cover/2017/12/22/4d3c724157d49ee6a2ffee5e4107849a.jpg","video_duration":819.76,"video_source":2,"video_status":0,"video_title":"主播油条：2017.12.02-直播穿梭在子弹之中的山驴逼！","view_num":36806}]
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
         * cid1 : 3
         * cid2 : 43
         * ctime : 1514008080
         * hash_id : XNbwE7Z6q3p7n5Zz
         * is_replay : 0
         * is_vertical : 0
         * nickname : 花邪v
         * point_id : 2287761
         * ranktype : 25
         * recomType : 1
         * rpos : 31
         * up_id : 5byARb6Y0A69
         * utime : 1514008140
         * video_content : 独宠小周周  Everybody Knows I Love You - Lovebugs
         * video_cover : https://cs-op.douyucdn.cn/vod-cover/2017/12/23/b5fbd892d8dc612dbfaa8fe92789805c.jpg
         * video_duration : 163.4
         * video_source : 2
         * video_status : 0
         * video_title : 独宠小周周
         * view_num : 113
         */

        private int cid1;
        private int cid2;
        private int ctime;
        private String hash_id;
        private int is_replay;
        private int is_vertical;
        private String nickname;
        private int point_id;
        private String ranktype;
        private String recomType;
        private String rpos;
        private String up_id;
        private int utime;
        private String video_content;
        private String video_cover;
        private double video_duration;
        private int video_source;
        private int video_status;
        private String video_title;
        private int view_num;

        public int getCid1() {
            return cid1;
        }

        public void setCid1(int cid1) {
            this.cid1 = cid1;
        }

        public int getCid2() {
            return cid2;
        }

        public void setCid2(int cid2) {
            this.cid2 = cid2;
        }

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public String getHash_id() {
            return hash_id;
        }

        public void setHash_id(String hash_id) {
            this.hash_id = hash_id;
        }

        public int getIs_replay() {
            return is_replay;
        }

        public void setIs_replay(int is_replay) {
            this.is_replay = is_replay;
        }

        public int getIs_vertical() {
            return is_vertical;
        }

        public void setIs_vertical(int is_vertical) {
            this.is_vertical = is_vertical;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getPoint_id() {
            return point_id;
        }

        public void setPoint_id(int point_id) {
            this.point_id = point_id;
        }

        public String getRanktype() {
            return ranktype;
        }

        public void setRanktype(String ranktype) {
            this.ranktype = ranktype;
        }

        public String getRecomType() {
            return recomType;
        }

        public void setRecomType(String recomType) {
            this.recomType = recomType;
        }

        public String getRpos() {
            return rpos;
        }

        public void setRpos(String rpos) {
            this.rpos = rpos;
        }

        public String getUp_id() {
            return up_id;
        }

        public void setUp_id(String up_id) {
            this.up_id = up_id;
        }

        public int getUtime() {
            return utime;
        }

        public void setUtime(int utime) {
            this.utime = utime;
        }

        public String getVideo_content() {
            return video_content;
        }

        public void setVideo_content(String video_content) {
            this.video_content = video_content;
        }

        public String getVideo_cover() {
            return video_cover;
        }

        public void setVideo_cover(String video_cover) {
            this.video_cover = video_cover;
        }

        public double getVideo_duration() {
            return video_duration;
        }

        public void setVideo_duration(double video_duration) {
            this.video_duration = video_duration;
        }

        public int getVideo_source() {
            return video_source;
        }

        public void setVideo_source(int video_source) {
            this.video_source = video_source;
        }

        public int getVideo_status() {
            return video_status;
        }

        public void setVideo_status(int video_status) {
            this.video_status = video_status;
        }

        public String getVideo_title() {
            return video_title;
        }

        public void setVideo_title(String video_title) {
            this.video_title = video_title;
        }

        public int getView_num() {
            return view_num;
        }

        public void setView_num(int view_num) {
            this.view_num = view_num;
        }
    }
}
