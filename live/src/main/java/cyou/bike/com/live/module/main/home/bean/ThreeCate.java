package cyou.bike.com.live.module.main.home.bean;

import java.io.Serializable;
import java.util.List;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by：anlonglong
 * on 2017/12/13 22:19
 * Email: anlonglong0721@gmail.com
 */

public class ThreeCate extends BaseHttpOutput implements Serializable {

    /**
     * data : [{"id":"168","name":"妹纸主播"},{"id":"32","name":"荣耀上单"},{"id":"33","name":"野区霸主"},{"id":"34","name":"中路杀神"},{"id":"35","name":"最强AD"},{"id":"36","name":"神级辅助"},{"id":"37","name":"赛事直播"}]
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
         * id : 168
         * name : 妹纸主播
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
