package cyou.bike.com.live.module.main.live.bean;

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by：anlonglong
 * on 2017/12/16 15:21
 * Email: anlonglong0721@gmail.com
 */

public class ColumnListIndicatorBean extends BaseHttpOutput implements Serializable {

    /**
     * data : [{"cate_id":"16","cate_name":"热门游戏","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"game"},{"cate_id":"1","cate_name":"电脑游戏","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"PCgame"},{"cate_id":"14","cate_name":"王者荣耀","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"wzry"},{"cate_id":"15","cate_name":"客厅游戏","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"ktyx"},{"cate_id":"9","cate_name":"手机游戏","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"sjyx"},{"cate_id":"2","cate_name":"娱乐","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"yl"},{"cate_id":"8","cate_name":"颜值","push_ios":"1","push_nearby":"1","push_show":"0","push_vertical_screen":"1","short_name":"yz"},{"cate_id":"3","cate_name":"科技","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"kj"},{"cate_id":"11","cate_name":"文娱课堂","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"wykt"},{"cate_id":"13","cate_name":"正能量","push_ios":"1","push_nearby":"0","push_show":"0","push_vertical_screen":"0","short_name":"znl"}]
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
         * cate_id : 16
         * cate_name : 热门游戏
         * push_ios : 1
         * push_nearby : 0
         * push_show : 0
         * push_vertical_screen : 0
         * short_name : game
         */

        private String cate_id;
        private String cate_name;
        private String push_ios;
        private String push_nearby;
        private String push_show;
        private String push_vertical_screen;
        private String short_name;

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
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

        public String getPush_show() {
            return push_show;
        }

        public void setPush_show(String push_show) {
            this.push_show = push_show;
        }

        public String getPush_vertical_screen() {
            return push_vertical_screen;
        }

        public void setPush_vertical_screen(String push_vertical_screen) {
            this.push_vertical_screen = push_vertical_screen;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }
    }
}
