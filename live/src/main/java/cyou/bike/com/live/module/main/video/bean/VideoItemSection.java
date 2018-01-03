package cyou.bike.com.live.module.main.video.bean;/**
 * Created by anlonglong on 2017/12/24.
 */

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/24 at 12:52
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class VideoItemSection {
    private CateHotVideoList.DataBean mCateHotVideoList;
    private HotVideoList.DataBean mHotVideoList;
    private CateHotVideoList.DataBean.VideoListBean mVideoListBean;

    public VideoItemSection(CateHotVideoList.DataBean cateHotVideoList) {
        mCateHotVideoList = cateHotVideoList;
    }

    public VideoItemSection(HotVideoList.DataBean hotVideoList) {

        mHotVideoList = hotVideoList;
    }

    public VideoItemSection(CateHotVideoList.DataBean.VideoListBean videoListBean) {
        mVideoListBean = videoListBean;
    }

    public CateHotVideoList.DataBean getCateHotVideoList() {
        return mCateHotVideoList;
    }

    public void setCateHotVideoList(CateHotVideoList.DataBean cateHotVideoList) {
        mCateHotVideoList = cateHotVideoList;
    }

    public HotVideoList.DataBean getHotVideoList() {
        return mHotVideoList;
    }

    public void setHotVideoList(HotVideoList.DataBean hotVideoList) {
        mHotVideoList = hotVideoList;
    }

    public CateHotVideoList.DataBean.VideoListBean getVideoListBean() {
        return mVideoListBean;
    }

    public void setVideoListBean(CateHotVideoList.DataBean.VideoListBean videoListBean) {
        mVideoListBean = videoListBean;
    }
}
