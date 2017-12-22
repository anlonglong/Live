package cyou.bike.com.live.module.main.home.contract;

import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.home.bean.BannerBean;
import cyou.bike.com.live.module.main.home.bean.DigDataRoomBean;
import cyou.bike.com.live.module.main.home.bean.FaceScoreBean;
import cyou.bike.com.live.module.main.home.bean.HotCateBean;

/**
 * Created by：anlonglong
 * on 2017/11/2 21:11
 * Email: anlonglong0721@gmail.com
 */

public interface RecommendContract {

    interface Presenter extends BasePresenter<RecommendContract.View, RecommendContract.RecommendMoudle> {

        //aid=android1&client_sys=android&identification=3e760da75be261a588c74c4830632360&time=1480493599&auth=b455ecdc27fd82acc4f5ed771d015a3d
        void getHotRoom(String aid, String identification, String time, String auth);

        //http://capi.douyucdn.cn/api/v1/slide/6?version=2.421&client_sys=android
        void getBannerList(String version);

        /**
         * http://capi.douyucdn.cn/api/v1/getHotCate?aid=android1&client_sys=android&time=1480500054&token=89175431_12_cd2cb4963d259081_1_54371072&auth=19ca301d4523a0af1c4945887ae0b03e
         **/
        void getHotCate(String aid, String time, String token, String auth);

        //最热
        void getBigDataRoom(String aid, long stampTime, String token, String auth);

        //颜值
        void getFaceScoreRoom(int offset, int limit);


    }

    public interface View extends BaseView<RecommendContract.Presenter> {
        void onBannerListSuccess(BannerBean data);

        void onDigDataRoomSuccess(DigDataRoomBean dataRoom);

        void onHotCate(HotCateBean hotCateBean);

        void onFaceScore(FaceScoreBean faceScoreBean);
    }

    public interface RecommendMoudle extends BaseModule<RecommendContract.View> {
        //aid=android1&client_sys=android&identification=3e760da75be261a588c74c4830632360&time=1480493599&auth=b455ecdc27fd82acc4f5ed771d015a3d
        void getHotRoom(String aid, String identification, String time, String auth);

        //http://capi.douyucdn.cn/api/v1/slide/6?version=2.421&client_sys=android
        void getBannerList(String version);

        /**
         * http://capi.douyucdn.cn/api/v1/getHotCate?aid=android1&client_sys=android&time=1480500054&token=89175431_12_cd2cb4963d259081_1_54371072&auth=19ca301d4523a0af1c4945887ae0b03e
         **/
        void getHotCate(String aid, String time, String token, String auth);

        //最热
        void getBigDataRoom(String aid, long stampTime, String token, String auth);


        //颜值
        void getFaceScoreRoom(int offset, int limit);

    }

}
