package cyou.bike.com.live.module.main.live.bean;

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by：anlonglong
 * on 2017/12/17 11:10
 * Email: anlonglong0721@gmail.com
 */


@SuppressWarnings("all")
public class InnerColumnDetailBean extends BaseHttpOutput implements Serializable {
    private static final long serialVersionUID = -576232459156852428L;

    /**
     * data : [{"broadcast_limit":"3","cate_id":"16","count":62,"count_ios":52,"icon_name":"94691f7a259e7e85c4c65e5849cd94dc.jpg","icon_url":"https://staticlive.douyucdn.cn/upload/game_cate/94691f7a259e7e85c4c65e5849cd94dc.jpg","is_childs":4,"is_del":"0","is_game_cate":"1","is_relate":"1","night_rank_score":"0","nums":"958","open_full_screen":"0","orderdisplay":"35","pic_name":"2baff99c2d776f70d95a43aff087952a.jpg","pic_name2":"b31e6ea7cdb651fb688f787c2ace29b2.jpg","pic_url":"https://staticlive.douyucdn.cn/upload/game_cate/2baff99c2d776f70d95a43aff087952a.jpg","push_home":"1","push_ios":"1","push_nearby":"0","push_qqapp":"1","push_vertical_screen":"0","rank_score":"0","short_name":"CF","small_icon_name":"6eecb81635b03ebc9272abe9216f6d21.png","small_icon_url":"https://staticlive.douyucdn.cn/upload/game_cate/6eecb81635b03ebc9272abe9216f6d21.png","square_icon_name":{"mob":"29f0315728c7a9965b11552cbebe706e.jpg","web":"6b6fc9804611459df5354c713f7a34f8.jpg"},"tag_id":"33","tag_introduce":"《穿越火线》作为国民枪战第一网游，是一款第一人称射击游戏类游戏。由Smile Gate开发，腾讯游戏发行。玩家扮演保卫、潜伏阵营进行持枪战斗。","tag_name":"穿越火线","url":"/directory/game/CF","vodd_cateids":""}]
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
         * broadcast_limit : 3
         * cate_id : 16
         * count : 62
         * count_ios : 52
         * icon_name : 94691f7a259e7e85c4c65e5849cd94dc.jpg
         * icon_url : https://staticlive.douyucdn.cn/upload/game_cate/94691f7a259e7e85c4c65e5849cd94dc.jpg
         * is_childs : 4
         * is_del : 0
         * is_game_cate : 1
         * is_relate : 1
         * night_rank_score : 0
         * nums : 958
         * open_full_screen : 0
         * orderdisplay : 35
         * pic_name : 2baff99c2d776f70d95a43aff087952a.jpg
         * pic_name2 : b31e6ea7cdb651fb688f787c2ace29b2.jpg
         * pic_url : https://staticlive.douyucdn.cn/upload/game_cate/2baff99c2d776f70d95a43aff087952a.jpg
         * push_home : 1
         * push_ios : 1
         * push_nearby : 0
         * push_qqapp : 1
         * push_vertical_screen : 0
         * rank_score : 0
         * short_name : CF
         * small_icon_name : 6eecb81635b03ebc9272abe9216f6d21.png
         * small_icon_url : https://staticlive.douyucdn.cn/upload/game_cate/6eecb81635b03ebc9272abe9216f6d21.png
         * square_icon_name : {"mob":"29f0315728c7a9965b11552cbebe706e.jpg","web":"6b6fc9804611459df5354c713f7a34f8.jpg"}
         * tag_id : 33
         * tag_introduce : 《穿越火线》作为国民枪战第一网游，是一款第一人称射击游戏类游戏。由Smile Gate开发，腾讯游戏发行。玩家扮演保卫、潜伏阵营进行持枪战斗。
         * tag_name : 穿越火线
         * url : /directory/game/CF
         * vodd_cateids :
         */

        private String broadcast_limit;
        private String cate_id;
        private int count;
        private int count_ios;
        private String icon_name;
        private String icon_url;
        private int is_childs;
        private String is_del;
        private String is_game_cate;
        private String is_relate;
        private String night_rank_score;
        private String nums;
        private String open_full_screen;
        private String orderdisplay;
        private String pic_name;
        private String pic_name2;
        private String pic_url;
        private String push_home;
        private String push_ios;
        private String push_nearby;
        private String push_qqapp;
        private String push_vertical_screen;
        private String rank_score;
        private String short_name;
        private String small_icon_name;
        private String small_icon_url;
        private String square_icon_name;
        private String tag_id;
        private String tag_introduce;
        private String tag_name;
        private String url;
        private String vodd_cateids;

        public String getBroadcast_limit() {
            return broadcast_limit;
        }

        public void setBroadcast_limit(String broadcast_limit) {
            this.broadcast_limit = broadcast_limit;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount_ios() {
            return count_ios;
        }

        public void setCount_ios(int count_ios) {
            this.count_ios = count_ios;
        }

        public String getIcon_name() {
            return icon_name;
        }

        public void setIcon_name(String icon_name) {
            this.icon_name = icon_name;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public int getIs_childs() {
            return is_childs;
        }

        public void setIs_childs(int is_childs) {
            this.is_childs = is_childs;
        }

        public String getIs_del() {
            return is_del;
        }

        public void setIs_del(String is_del) {
            this.is_del = is_del;
        }

        public String getIs_game_cate() {
            return is_game_cate;
        }

        public void setIs_game_cate(String is_game_cate) {
            this.is_game_cate = is_game_cate;
        }

        public String getIs_relate() {
            return is_relate;
        }

        public void setIs_relate(String is_relate) {
            this.is_relate = is_relate;
        }

        public String getNight_rank_score() {
            return night_rank_score;
        }

        public void setNight_rank_score(String night_rank_score) {
            this.night_rank_score = night_rank_score;
        }

        public String getNums() {
            return nums;
        }

        public void setNums(String nums) {
            this.nums = nums;
        }

        public String getOpen_full_screen() {
            return open_full_screen;
        }

        public void setOpen_full_screen(String open_full_screen) {
            this.open_full_screen = open_full_screen;
        }

        public String getOrderdisplay() {
            return orderdisplay;
        }

        public void setOrderdisplay(String orderdisplay) {
            this.orderdisplay = orderdisplay;
        }

        public String getPic_name() {
            return pic_name;
        }

        public void setPic_name(String pic_name) {
            this.pic_name = pic_name;
        }

        public String getPic_name2() {
            return pic_name2;
        }

        public void setPic_name2(String pic_name2) {
            this.pic_name2 = pic_name2;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getPush_home() {
            return push_home;
        }

        public void setPush_home(String push_home) {
            this.push_home = push_home;
        }

        public String getPush_ios() {
            return push_ios;
        }

        public void setPush_ios(String push_ios) {
            this.push_ios = push_ios;
        }

        public String getPush_nearby() {
            return push_nearby;
        }

        public void setPush_nearby(String push_nearby) {
            this.push_nearby = push_nearby;
        }

        public String getPush_qqapp() {
            return push_qqapp;
        }

        public void setPush_qqapp(String push_qqapp) {
            this.push_qqapp = push_qqapp;
        }

        public String getPush_vertical_screen() {
            return push_vertical_screen;
        }

        public void setPush_vertical_screen(String push_vertical_screen) {
            this.push_vertical_screen = push_vertical_screen;
        }

        public String getRank_score() {
            return rank_score;
        }

        public void setRank_score(String rank_score) {
            this.rank_score = rank_score;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public String getSmall_icon_name() {
            return small_icon_name;
        }

        public void setSmall_icon_name(String small_icon_name) {
            this.small_icon_name = small_icon_name;
        }

        public String getSmall_icon_url() {
            return small_icon_url;
        }

        public void setSmall_icon_url(String small_icon_url) {
            this.small_icon_url = small_icon_url;
        }

        public String getSquare_icon_name() {
            return square_icon_name;
        }

        public void setSquare_icon_name(String square_icon_name) {
            this.square_icon_name = square_icon_name;
        }

        public String getTag_id() {
            return tag_id;
        }

        public void setTag_id(String tag_id) {
            this.tag_id = tag_id;
        }

        public String getTag_introduce() {
            return tag_introduce;
        }

        public void setTag_introduce(String tag_introduce) {
            this.tag_introduce = tag_introduce;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVodd_cateids() {
            return vodd_cateids;
        }

        public void setVodd_cateids(String vodd_cateids) {
            this.vodd_cateids = vodd_cateids;
        }
    }

}
