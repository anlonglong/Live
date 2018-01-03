package cyou.bike.com.live.net.api.home;

import cyou.bike.com.live.net.http.IDYRequest;

/**
 * Created by anlonglong on 2017/12/23.
 */
public interface VideoApi {
    String BASE_URL = "http://apiv2.douyucdn.cn/video/";

    String GET_VIDEO_HOME_CATE1_URL = BASE_URL+"Cate/getVideoHomeCate1";
    String GET_HOT_VIDEO_LIST = BASE_URL+"Video/getHotVideoList1";
    String GET_CATE_HOT_VIDEO_LIST = BASE_URL+"Video/getCateHotVideoList1";
    String GET_HOT_AUTHORS = BASE_URL+"Home/getHotAuthors";
    String GET_VIDEO_CATE2 = BASE_URL+"Cate/getVideoCate2";
    String GET_REC_VIDEO_LIST = BASE_URL+"Videoroomlist/getRecVideoList";
    String GET_AUTHOR_VID_LIST = BASE_URL+"VideoRoomList/getAuthorVidList";
}
