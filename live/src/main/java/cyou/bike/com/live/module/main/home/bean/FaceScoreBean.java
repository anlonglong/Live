package cyou.bike.com.live.module.main.home.bean;

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by：anlonglong
 * on 2017/11/9 16:38
 * Email: anlonglong0721@gmail.com
 */

public class FaceScoreBean extends BaseHttpOutput implements Serializable {
    private static final long serialVersionUID = -3816010510275522012L;

    /**
     * error : 0
     * data : [{"room_id":"3601414","room_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2017/11/09/3601414_20171109142722_small.jpg","vertical_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2017/11/09/3601414_20171109142722_big.jpg","isVertical":1,"cate_id":201,"room_name":"蛋蛋berber的直播间","show_status":"1","subject":"","show_time":"1510208995","owner_uid":"175432496","specific_catalog":"","specific_status":"0","vod_quality":"0","nickname":"蛋蛋berber","online":522,"game_name":"颜值","child_id":545,"avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201711/07/00/6f80a1f22305d9e9485820f38277fa1a_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201711/07/00/6f80a1f22305d9e9485820f38277fa1a_small.jpg","jumpUrl":"","ranktype":0,"rmf1":0,"rmf2":0,"show_type":0,"is_noble_rec":0,"anchor_city":"上海市"},{"room_id":"3318573","room_src":"https://rpic.douyucdn.cn/appCovers/2017/10/05/3318573_20171005155145_small.jpg","vertical_src":"https://rpic.douyucdn.cn/appCovers/2017/10/05/3318573_20171005155145_big.jpg","isVertical":1,"cate_id":201,"room_name":"这是南方姑娘啊","show_status":"1","subject":"","show_time":"1510205632","owner_uid":"163423923","specific_catalog":"","specific_status":"0","vod_quality":"0","nickname":"瓜瓜gea","online":8884,"game_name":"颜值","child_id":545,"avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201710/26/14/c42168b20e9405bec573bdce66e81476_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201710/26/14/c42168b20e9405bec573bdce66e81476_small.jpg","jumpUrl":"","ranktype":0,"rmf1":0,"rmf2":0,"show_type":0,"is_noble_rec":0,"anchor_city":"广州市"},{"room_id":"3630861","room_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2017/11/05/3630861_20171105140813_small.jpg","vertical_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2017/11/05/3630861_20171105140813_big.jpg","isVertical":1,"cate_id":201,"room_name":"中国戏曲直播频道的直播间","show_status":"1","subject":"","show_time":"1510214713","owner_uid":"176047028","specific_catalog":"","specific_status":"0","vod_quality":"0","nickname":"中国戏曲直播频道","online":8,"game_name":"颜值","child_id":545,"avatar_mid":"https://apic.douyucdn.cn/upload/avatar/default/07_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avatar/default/07_small.jpg","jumpUrl":"","ranktype":0,"rmf1":0,"rmf2":0,"show_type":0,"is_noble_rec":0,"anchor_city":"北京市"},{"room_id":"3612416","room_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2017/11/09/3612416_20171109145648_small.jpg","vertical_src":"https://rpic.douyucdn.cn/live-cover/appCovers/2017/11/09/3612416_20171109145648_big.jpg","isVertical":1,"cate_id":201,"room_name":"绵羊球球的直播间","show_status":"1","subject":"","show_time":"1510212527","owner_uid":"175588973","specific_catalog":"","specific_status":"0","vod_quality":"0","nickname":"绵羊球球","online":5,"game_name":"颜值","child_id":545,"avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201711/08/09/d90b20796f79fa14c797bbdcdb068738_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201711/08/09/d90b20796f79fa14c797bbdcdb068738_small.jpg","jumpUrl":"","ranktype":0,"rmf1":0,"rmf2":0,"show_type":0,"is_noble_rec":0,"anchor_city":"杭州市"}]
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

    @Override
    public String toString() {
        return "FaceScoreBean{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }

    public static class DataBean extends BaseHttpOutput{
        /**
         * room_id : 3601414
         * room_src : https://rpic.douyucdn.cn/live-cover/appCovers/2017/11/09/3601414_20171109142722_small.jpg
         * vertical_src : https://rpic.douyucdn.cn/live-cover/appCovers/2017/11/09/3601414_20171109142722_big.jpg
         * isVertical : 1
         * cate_id : 201
         * room_name : 蛋蛋berber的直播间
         * show_status : 1
         * subject :
         * show_time : 1510208995
         * owner_uid : 175432496
         * specific_catalog :
         * specific_status : 0
         * vod_quality : 0
         * nickname : 蛋蛋berber
         * online : 522
         * game_name : 颜值
         * child_id : 545
         * avatar_mid : https://apic.douyucdn.cn/upload/avanew/face/201711/07/00/6f80a1f22305d9e9485820f38277fa1a_middle.jpg
         * avatar_small : https://apic.douyucdn.cn/upload/avanew/face/201711/07/00/6f80a1f22305d9e9485820f38277fa1a_small.jpg
         * jumpUrl :
         * ranktype : 0
         * rmf1 : 0
         * rmf2 : 0
         * show_type : 0
         * is_noble_rec : 0
         * anchor_city : 上海市
         */

        private String room_id;
        private String room_src;
        private String vertical_src;
        private int isVertical;
        private int cate_id;
        private String room_name;
        private String show_status;
        private String subject;
        private String show_time;
        private String owner_uid;
        private String specific_catalog;
        private String specific_status;
        private String vod_quality;
        private String nickname;
        private int online;
        private String game_name;
        private int child_id;
        private String avatar_mid;
        private String avatar_small;
        private String jumpUrl;
        private int ranktype;
        private int rmf1;
        private int rmf2;
        private int show_type;
        private int is_noble_rec;
        private String anchor_city;

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_src() {
            return room_src;
        }

        public void setRoom_src(String room_src) {
            this.room_src = room_src;
        }

        public String getVertical_src() {
            return vertical_src;
        }

        public void setVertical_src(String vertical_src) {
            this.vertical_src = vertical_src;
        }

        public int getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(int isVertical) {
            this.isVertical = isVertical;
        }

        public int getCate_id() {
            return cate_id;
        }

        public void setCate_id(int cate_id) {
            this.cate_id = cate_id;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getShow_status() {
            return show_status;
        }

        public void setShow_status(String show_status) {
            this.show_status = show_status;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getShow_time() {
            return show_time;
        }

        public void setShow_time(String show_time) {
            this.show_time = show_time;
        }

        public String getOwner_uid() {
            return owner_uid;
        }

        public void setOwner_uid(String owner_uid) {
            this.owner_uid = owner_uid;
        }

        public String getSpecific_catalog() {
            return specific_catalog;
        }

        public void setSpecific_catalog(String specific_catalog) {
            this.specific_catalog = specific_catalog;
        }

        public String getSpecific_status() {
            return specific_status;
        }

        public void setSpecific_status(String specific_status) {
            this.specific_status = specific_status;
        }

        public String getVod_quality() {
            return vod_quality;
        }

        public void setVod_quality(String vod_quality) {
            this.vod_quality = vod_quality;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public int getChild_id() {
            return child_id;
        }

        public void setChild_id(int child_id) {
            this.child_id = child_id;
        }

        public String getAvatar_mid() {
            return avatar_mid;
        }

        public void setAvatar_mid(String avatar_mid) {
            this.avatar_mid = avatar_mid;
        }

        public String getAvatar_small() {
            return avatar_small;
        }

        public void setAvatar_small(String avatar_small) {
            this.avatar_small = avatar_small;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public int getRanktype() {
            return ranktype;
        }

        public void setRanktype(int ranktype) {
            this.ranktype = ranktype;
        }

        public int getRmf1() {
            return rmf1;
        }

        public void setRmf1(int rmf1) {
            this.rmf1 = rmf1;
        }

        public int getRmf2() {
            return rmf2;
        }

        public void setRmf2(int rmf2) {
            this.rmf2 = rmf2;
        }

        public int getShow_type() {
            return show_type;
        }

        public void setShow_type(int show_type) {
            this.show_type = show_type;
        }

        public int getIs_noble_rec() {
            return is_noble_rec;
        }

        public void setIs_noble_rec(int is_noble_rec) {
            this.is_noble_rec = is_noble_rec;
        }

        public String getAnchor_city() {
            return anchor_city;
        }

        public void setAnchor_city(String anchor_city) {
            this.anchor_city = anchor_city;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "room_id='" + room_id + '\'' +
                    ", room_src='" + room_src + '\'' +
                    ", vertical_src='" + vertical_src + '\'' +
                    ", isVertical=" + isVertical +
                    ", cate_id=" + cate_id +
                    ", room_name='" + room_name + '\'' +
                    ", show_status='" + show_status + '\'' +
                    ", subject='" + subject + '\'' +
                    ", show_time='" + show_time + '\'' +
                    ", owner_uid='" + owner_uid + '\'' +
                    ", specific_catalog='" + specific_catalog + '\'' +
                    ", specific_status='" + specific_status + '\'' +
                    ", vod_quality='" + vod_quality + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", online=" + online +
                    ", game_name='" + game_name + '\'' +
                    ", child_id=" + child_id +
                    ", avatar_mid='" + avatar_mid + '\'' +
                    ", avatar_small='" + avatar_small + '\'' +
                    ", jumpUrl='" + jumpUrl + '\'' +
                    ", ranktype=" + ranktype +
                    ", rmf1=" + rmf1 +
                    ", rmf2=" + rmf2 +
                    ", show_type=" + show_type +
                    ", is_noble_rec=" + is_noble_rec +
                    ", anchor_city='" + anchor_city + '\'' +
                    '}';
        }
    }
}
