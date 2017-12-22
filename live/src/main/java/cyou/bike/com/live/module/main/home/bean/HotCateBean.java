package cyou.bike.com.live.module.main.home.bean;

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by：anlonglong
 * on 2017/11/7 16:42
 * Email: anlonglong0721@gmail.com
 */

public class HotCateBean extends BaseHttpOutput implements Serializable {


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
        return "HotCateBean{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }

    public static class DataBean extends BaseHttpOutput{
        /**
         * icon_url : https://staticlive.douyucdn.cn/upload/game_cate/d3e0073bfb714186ab0c818744601963.jpg
         * push_nearby : 0
         * push_vertical_screen : 0
         * room_list : [{"avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201705/28/12/d12b06c296acbe43aeed99e5d38ec314_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201705/28/12/d12b06c296acbe43aeed99e5d38ec314_small.jpg","cate_id":1,"game_name":"英雄联盟","isVertical":0,"jumpUrl":"","nickname":"风萌丶青风影","online":"3951","owner_uid":78715068,"ranktype":"0","rmf1":0,"rmf2":0,"room_id":"1718417","room_name":"娃娃音青风影 王者刺客之 风暴青钢影","room_src":"https://rpic.douyucdn.cn/acrpic/171107/1718417_1647.jpg","show_status":1,"show_time":1510023147,"specific_catalog":"qingfengying","specific_status":1,"vertical_src":"https://rpic.douyucdn.cn/acrpic/171107/1718417_1647.jpg"},{"avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201704/09/14/fb85c35b18a4a82ce5f29ecc554eb952_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201704/09/14/fb85c35b18a4a82ce5f29ecc554eb952_small.jpg","cate_id":1,"game_name":"英雄联盟","isVertical":0,"jumpUrl":"","nickname":"疯狗蛮阿海","online":"2379","owner_uid":762341,"ranktype":"0","rmf1":0,"rmf2":0,"room_id":"1992509","room_name":"你见过最强的蛮王","room_src":"https://rpic.douyucdn.cn/acrpic/171107/1992509_1648.jpg","show_status":1,"show_time":1510030909,"specific_catalog":"","specific_status":0,"vertical_src":"https://rpic.douyucdn.cn/acrpic/171107/1992509_1648.jpg"},{"avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201711/05/05/ec419510a245180ae35b8bd66aefd08d_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201711/05/05/ec419510a245180ae35b8bd66aefd08d_small.jpg","cate_id":1,"game_name":"英雄联盟","isVertical":0,"jumpUrl":"","nickname":"拾7岁","online":"2373","owner_uid":45562299,"ranktype":"0","rmf1":0,"rmf2":0,"room_id":"682197","room_name":"拾7：随机排位上分","room_src":"https://rpic.douyucdn.cn/acrpic/171107/682197_1643.jpg","show_status":1,"show_time":1510015060,"specific_catalog":"","specific_status":0,"vertical_src":"https://rpic.douyucdn.cn/acrpic/171107/682197_1643.jpg"},{"avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201710/19/01/295d5e52d80f32b5441de4342b94e265_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201710/19/01/295d5e52d80f32b5441de4342b94e265_small.jpg","cate_id":1,"game_name":"英雄联盟","isVertical":0,"jumpUrl":"","nickname":"安徽丶白皮虎","online":"2259","owner_uid":32632968,"ranktype":"0","rmf1":0,"rmf2":0,"room_id":"2331934","room_name":"您进来开心就好","room_src":"https://rpic.douyucdn.cn/acrpic/171107/2331934_1650.jpg","show_status":1,"show_time":1510034068,"specific_catalog":"","specific_status":0,"vertical_src":"https://rpic.douyucdn.cn/acrpic/171107/2331934_1650.jpg"}]
         * small_icon_url : https://staticlive.douyucdn.cn/upload/game_cate/ffdc72ed97b50ad8011de9a779b8d83b.png
         * tag_id : 1
         * tag_name : 英雄联盟
         */

        private String icon_url;
        private String push_nearby;
        private String push_vertical_screen;
        private String small_icon_url;
        private String tag_id;
        private String tag_name;
        private List<RoomListBean> room_list;

        public String getIcon_url() {
            return icon_url;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "icon_url='" + icon_url + '\'' +
                    ", push_nearby='" + push_nearby + '\'' +
                    ", push_vertical_screen='" + push_vertical_screen + '\'' +
                    ", small_icon_url='" + small_icon_url + '\'' +
                    ", tag_id='" + tag_id + '\'' +
                    ", tag_name='" + tag_name + '\'' +
                    ", room_list=" + room_list +
                    '}';
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getPush_nearby() {
            return push_nearby;
        }

        public void setPush_nearby(String push_nearby) {
            this.push_nearby = push_nearby;
        }

        public String getPush_vertical_screen() {
            return push_vertical_screen;
        }

        public void setPush_vertical_screen(String push_vertical_screen) {
            this.push_vertical_screen = push_vertical_screen;
        }

        public String getSmall_icon_url() {
            return small_icon_url;
        }

        public void setSmall_icon_url(String small_icon_url) {
            this.small_icon_url = small_icon_url;
        }

        public String getTag_id() {
            return tag_id;
        }

        public void setTag_id(String tag_id) {
            this.tag_id = tag_id;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }

        public List<RoomListBean> getRoom_list() {
            return room_list;
        }

        public void setRoom_list(List<RoomListBean> room_list) {
            this.room_list = room_list;
        }

        public static class RoomListBean implements Serializable {
            /**
             * avatar_mid : https://apic.douyucdn.cn/upload/avanew/face/201705/28/12/d12b06c296acbe43aeed99e5d38ec314_middle.jpg
             * avatar_small : https://apic.douyucdn.cn/upload/avanew/face/201705/28/12/d12b06c296acbe43aeed99e5d38ec314_small.jpg
             * cate_id : 1
             * game_name : 英雄联盟
             * isVertical : 0
             * jumpUrl :
             * nickname : 风萌丶青风影
             * online : 3951
             * owner_uid : 78715068
             * ranktype : 0
             * rmf1 : 0
             * rmf2 : 0
             * room_id : 1718417
             * room_name : 娃娃音青风影 王者刺客之 风暴青钢影
             * room_src : https://rpic.douyucdn.cn/acrpic/171107/1718417_1647.jpg
             * show_status : 1
             * show_time : 1510023147
             * specific_catalog : qingfengying
             * specific_status : 1
             * vertical_src : https://rpic.douyucdn.cn/acrpic/171107/1718417_1647.jpg
             */

            private String avatar_mid;
            private String avatar_small;
            private int cate_id;
            private String game_name;
            private int isVertical;
            private String jumpUrl;
            private String nickname;
            private String online;
            private int owner_uid;
            private String ranktype;
            private int rmf1;
            private int rmf2;
            private String room_id;
            private String room_name;
            private String room_src;
            private int show_status;
            private int show_time;
            private String specific_catalog;
            private int specific_status;
            private String vertical_src;

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

            public String getGame_name() {
                return game_name;
            }

            public void setGame_name(String game_name) {
                this.game_name = game_name;
            }

            public int getIsVertical() {
                return isVertical;
            }

            public void setIsVertical(int isVertical) {
                this.isVertical = isVertical;
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

            public String getOnline() {
                return online;
            }

            public void setOnline(String online) {
                this.online = online;
            }

            public int getOwner_uid() {
                return owner_uid;
            }

            public void setOwner_uid(int owner_uid) {
                this.owner_uid = owner_uid;
            }

            public String getRanktype() {
                return ranktype;
            }

            public void setRanktype(String ranktype) {
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

            public int getShow_status() {
                return show_status;
            }

            public void setShow_status(int show_status) {
                this.show_status = show_status;
            }

            public int getShow_time() {
                return show_time;
            }

            public void setShow_time(int show_time) {
                this.show_time = show_time;
            }

            public String getSpecific_catalog() {
                return specific_catalog;
            }

            public void setSpecific_catalog(String specific_catalog) {
                this.specific_catalog = specific_catalog;
            }

            public int getSpecific_status() {
                return specific_status;
            }

            public void setSpecific_status(int specific_status) {
                this.specific_status = specific_status;
            }

            public String getVertical_src() {
                return vertical_src;
            }

            public void setVertical_src(String vertical_src) {
                this.vertical_src = vertical_src;
            }

            @Override
            public String toString() {
                return "RoomListBean{" +
                        "avatar_mid='" + avatar_mid + '\'' +
                        ", avatar_small='" + avatar_small + '\'' +
                        ", cate_id=" + cate_id +
                        ", game_name='" + game_name + '\'' +
                        ", isVertical=" + isVertical +
                        ", jumpUrl='" + jumpUrl + '\'' +
                        ", nickname='" + nickname + '\'' +
                        ", online='" + online + '\'' +
                        ", owner_uid=" + owner_uid +
                        ", ranktype='" + ranktype + '\'' +
                        ", rmf1=" + rmf1 +
                        ", rmf2=" + rmf2 +
                        ", room_id='" + room_id + '\'' +
                        ", room_name='" + room_name + '\'' +
                        ", room_src='" + room_src + '\'' +
                        ", show_status=" + show_status +
                        ", show_time=" + show_time +
                        ", specific_catalog='" + specific_catalog + '\'' +
                        ", specific_status=" + specific_status +
                        ", vertical_src='" + vertical_src + '\'' +
                        '}';
            }
        }

    }

}
