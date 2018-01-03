package cyou.bike.com.live.module.videocontroller.cellphonelive;

import java.io.Serializable;

import cyou.bike.com.live.base.BaseHttpOutput;

/**
 * Created by：anlonglong
 * on 2017/12/4 14:37
 * Email: anlonglong0721@gmail.com
 */

public class LivePathBean extends BaseHttpOutput implements Serializable {

    private static final long serialVersionUID = -5286689037874296163L;


    /**
     * error : 0
     * data : {"hls_url":"http://hlsa.douyucdn.cn/live/540910rLDcWz000Z_550/playlist.m3u8?wsSecret=97dbac31d1a7967d11b7ba55b79adad7&wsTime=1512351379&token=h5-douyu-0-540910-acd73634183bfb287ec50d02d1ce19eb&did=h5_did"}
     */

    private int error;
    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hls_url : http://hlsa.douyucdn.cn/live/540910rLDcWz000Z_550/playlist.m3u8?wsSecret=97dbac31d1a7967d11b7ba55b79adad7&wsTime=1512351379&token=h5-douyu-0-540910-acd73634183bfb287ec50d02d1ce19eb&did=h5_did
         */

        private String hls_url;

        public String getHls_url() {
            return hls_url;
        }

        public void setHls_url(String hls_url) {
            this.hls_url = hls_url;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "hls_url='" + hls_url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "LivePathBean{" +
                "error=" + error +
                ", data=" + data +
                '}';
    }
}
