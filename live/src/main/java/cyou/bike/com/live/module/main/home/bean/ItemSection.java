package cyou.bike.com.live.module.main.home.bean;

/**
 * Created by：anlonglong
 * on 2017/11/21 16:56
 * Email: anlonglong0721@gmail.com
 */
@SuppressWarnings("unused")
public class ItemSection {
    private DigDataRoomBean.DataBean mDigDataBean;

    private FaceScoreBean.DataBean mFaceScoreDataBean;

    private HotCateBean.DataBean.RoomListBean mHotCateDataBean;

    public ItemSection(DigDataRoomBean.DataBean digDataBean, FaceScoreBean.DataBean mfcDataBean, HotCateBean.DataBean.RoomListBean mHotCateDataBean) {
        mDigDataBean = digDataBean;
        this.mFaceScoreDataBean = mfcDataBean;
        this.mHotCateDataBean = mHotCateDataBean;
    }

    public ItemSection(DigDataRoomBean.DataBean digDataBean) {
        mDigDataBean = digDataBean;
    }

    public ItemSection(FaceScoreBean.DataBean mfcDataBean) {
        this.mFaceScoreDataBean = mfcDataBean;
    }

    public ItemSection(HotCateBean.DataBean.RoomListBean mHotCateDataBean) {
        this.mHotCateDataBean = mHotCateDataBean;
    }

    public DigDataRoomBean.DataBean getDataBean() {
        return mDigDataBean;
    }

    public void setDataBean(DigDataRoomBean.DataBean dataBean) {
        mDigDataBean = dataBean;
    }

    public FaceScoreBean.DataBean getFaceScoreDataBean() {
        return mFaceScoreDataBean;
    }

    public void setFaceScoreDataBean(FaceScoreBean.DataBean mfsDataBean) {
        this.mFaceScoreDataBean = mfsDataBean;
    }

    public HotCateBean.DataBean.RoomListBean getHotCateDataBean() {
        return mHotCateDataBean;
    }

    public void setHotCateDataBean(HotCateBean.DataBean.RoomListBean mhcDataBean) {
        this.mHotCateDataBean = mhcDataBean;
    }
}
