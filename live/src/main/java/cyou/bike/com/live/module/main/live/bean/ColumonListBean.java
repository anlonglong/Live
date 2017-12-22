package cyou.bike.com.live.module.main.live.bean;

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by：anlonglong
 * on 2017/12/16 17:00
 * Email: anlonglong0721@gmail.com
 */

public class ColumonListBean extends BaseHttpOutput implements Serializable {



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
         * anchor_city :
         * avatar : https://apic.douyucdn.cn/upload/avatar/face/201609/08/f6c0c08a3f3cb1fd074fe38907ae2508_big.jpg?rltime
         * avatar_mid : https://apic.douyucdn.cn/upload/avatar/face/201609/08/f6c0c08a3f3cb1fd074fe38907ae2508_middle.jpg?rltime
         * avatar_small : https://apic.douyucdn.cn/upload/avatar/face/201609/08/f6c0c08a3f3cb1fd074fe38907ae2508_small.jpg?rltime
         * cate_id : 1
         * child_id : 34
         * fans : 9848013
         * game_name : 英雄联盟
         * game_url : /directory/game/LOL
         * hn : 1043767
         * isVertical : 0
         * is_noble_rec : 0
         * jumpUrl :
         * nickname : 芜湖大司马丶
         * online : 821704
         * owner_uid : 45862251
         * ranktype : 0
         * room_id : 606118
         * room_name : 大司马：舒服了，还是老东西好用
         * room_src : https://rpic.douyucdn.cn/alrpic/171216/606118_1640.jpg
         * show_status : 1
         * show_time : 1513407621
         * specific_catalog : dasima
         * specific_status : 1
         * subject :
         * url : /dasima
         * vertical_src : https://rpic.douyucdn.cn/alrpic/171216/606118_1640.jpg
         * vod_quality : 0
         */

        private String anchor_city;
        private String avatar;
        private String avatar_mid;
        private String avatar_small;
        private int cate_id;
        private int child_id;
        private String fans;
        private String game_name;
        private String game_url;
        private int hn;
        private int isVertical;
        private int is_noble_rec;
        private String jumpUrl;
        private String nickname;
        private int online;
        private String owner_uid;
        private int ranktype;
        private String room_id;
        private String room_name;
        private String room_src;
        private String show_status;
        private String show_time;
        private String specific_catalog;
        private String specific_status;
        private String subject;
        private String url;
        private String vertical_src;
        private String vod_quality;

        public String getAnchor_city() {
            return anchor_city;
        }

        public void setAnchor_city(String anchor_city) {
            this.anchor_city = anchor_city;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
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

        public int getCate_id() {
            return cate_id;
        }

        public void setCate_id(int cate_id) {
            this.cate_id = cate_id;
        }

        public int getChild_id() {
            return child_id;
        }

        public void setChild_id(int child_id) {
            this.child_id = child_id;
        }

        public String getFans() {
            return fans;
        }

        public void setFans(String fans) {
            this.fans = fans;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public String getGame_url() {
            return game_url;
        }

        public void setGame_url(String game_url) {
            this.game_url = game_url;
        }

        public int getHn() {
            return hn;
        }

        public void setHn(int hn) {
            this.hn = hn;
        }

        public int getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(int isVertical) {
            this.isVertical = isVertical;
        }

        public int getIs_noble_rec() {
            return is_noble_rec;
        }

        public void setIs_noble_rec(int is_noble_rec) {
            this.is_noble_rec = is_noble_rec;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
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

        public String getOwner_uid() {
            return owner_uid;
        }

        public void setOwner_uid(String owner_uid) {
            this.owner_uid = owner_uid;
        }

        public int getRanktype() {
            return ranktype;
        }

        public void setRanktype(int ranktype) {
            this.ranktype = ranktype;
        }

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_src() {
            return room_src;
        }

        public void setRoom_src(String room_src) {
            this.room_src = room_src;
        }

        public String getShow_status() {
            return show_status;
        }

        public void setShow_status(String show_status) {
            this.show_status = show_status;
        }

        public String getShow_time() {
            return show_time;
        }

        public void setShow_time(String show_time) {
            this.show_time = show_time;
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

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVertical_src() {
            return vertical_src;
        }

        public void setVertical_src(String vertical_src) {
            this.vertical_src = vertical_src;
        }

        public String getVod_quality() {
            return vod_quality;
        }

        public void setVod_quality(String vod_quality) {
            this.vod_quality = vod_quality;
        }
    }
}
