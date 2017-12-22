package cyou.bike.com.live.net.api.home;

import org.w3c.dom.Text;

import cyou.bike.com.live.net.http.IDYRequest;

/**
 * Created by：anlonglong
 * on 2017/10/23 20:52
 * Email: anlonglong0721@gmail.com
 */

public interface HomeApi {
    //String BASE_URL = "http://capi.douyucdn.cn/api/";


    String BANNER_URL = IDYRequest.BASE_URL+"v1/slide/6";
    String CATELIST_URL = IDYRequest.BASE_URL+"homeCate/getCateList";
    //http://capi.douyucdn.cn/api/v1/getbigDataRoom?aid=android1&client_sys=android&time=1509690286&token=89175431_12_cd2cb4963d259081_1_54371072&auth=43b3facb607f9f0251a4918249ujdceb
    String RECOMMEND_HOT_URL =IDYRequest.BASE_URL+"v1/getBigDataRoom";
    String HOt_CATE_URL = IDYRequest.BASE_URL+"v1/getHotCate";
    String FACE_SCORE_URL = IDYRequest.BASE_URL+"v1/getVerticalRoom";
    // //https://m.douyu.com/html5/live?{roomId=2227593}roomId : 动态的
    String VIDEO_URL = "https://m.douyu.com/html5/live";
    String OTHER_URL = IDYRequest.BASE_URL+"homeCate/getHotRoom";
    String THREDE_CATA_URL = IDYRequest.BASE_URL+"v1/getThreeCate";
    String LIVE_URL = IDYRequest.BASE_URL+"v1/live";
    String THREDE_CATA_DATA_URL = LIVE_URL+"/";
    String LIVE_COLUMN_LIST_URL = IDYRequest.BASE_URL+"v1/getColumnList";
    String LIVE_COLUMN_LIST_DETAIL = IDYRequest.BASE_URL+"v1/getColumnDetail";
}
