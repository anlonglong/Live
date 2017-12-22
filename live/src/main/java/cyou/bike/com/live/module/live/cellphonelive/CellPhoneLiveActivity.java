package cyou.bike.com.live.module.live.cellphonelive;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Message;
import android.support.annotation.DrawableRes;
import android.support.constraint.ConstraintLayout;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vondear.rxtools.view.RxToast;
import com.wang.avi.AVLoadingIndicatorView;

import org.greenrobot.greendao.annotation.NotNull;

import butterknife.BindView;
import butterknife.OnClick;
import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseActivity;
import cyou.bike.com.live.module.live.danmu.DanmuProcessor;
import cyou.bike.com.live.utils.CommentUtil;
import cyou.bike.com.live.utils.LogUtil;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import master.flame.danmaku.ui.widget.DanmakuView;


public class CellPhoneLiveActivity extends BaseActivity<CellPresenter>
        implements CellPhoneContract.View, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener {
    private static final String TAG = CellPhoneLiveActivity.class.getSimpleName();


    private static final String ROOM_ID = "room_id";
    private static String IS_FROM_FACE_SCORE = "face_score";
    @BindView(R.id.video_view)
    VideoView mVideoView;
    @BindView(R.id.danmaku_view)
    DanmakuView mDanmakuView;
    @BindView(R.id.iv_back)
    ImageView mIvBack;
    @BindView(R.id.top_control)
    RelativeLayout mTopControl;
    @BindView(R.id.bottom_control)
    ConstraintLayout mBottomControl;
    @BindView(R.id.iv_setting)
    ImageView mIvSetting;
    @BindView(R.id.iv_gift)
    ImageView mIvGift;
    @BindView(R.id.iv_share)
    ImageView mIvShare;
    @BindView(R.id.iv_pause)
    ImageView mIvPause;
    @BindView(R.id.iv_refresh)
    ImageView mIvRefresh;
    @BindView(R.id.iv_hot)
    ImageView mIvHot;
    @BindView(R.id.separ)
    View mSepar;
    @BindView(R.id.text_danmu)
    EditText mTextDanmu;
    @BindView(R.id.iv_live_hor)
    ImageView mIvLiveHor;
    @BindView(R.id.danmu_container)
    RelativeLayout mDanmuContainer;
    @BindView(R.id.tv_live_list)
    TextView mTvLiveList;
    @BindView(R.id.iv_danmu)
    ImageView mIvDanmu;
    @BindView(R.id.bg)
    ImageView mBg;
    @BindView(R.id.av_loading)
    AVLoadingIndicatorView mAvLoading;
    @BindView(R.id.loading_percent)
    TextView mLoadingPercent;
    @BindView(R.id.iv_control_img)
    ImageView mIvControlImg;
    @BindView(R.id.tv_control_name)
    TextView mTvControlName;
    @BindView(R.id.tv_control)
    TextView mTvControl;
    @BindView(R.id.control_center)
    RelativeLayout mControlCenter;
    @BindView(R.id.loading_container)
    ConstraintLayout mLoadingContainer;
    private CellPhoneContract.Presenter mPresenter;
    private GestureDetector mDetector;
    private Voice$Lightness mVoice$Lightness;
    private String mRoomId;
    private DanmuProcessor mDanmuProcessor;
    private boolean mIsFromFS;


    public static void start(Context context, @NotNull String roomId, boolean isFromFaceScore) {
        Intent intent = new Intent(context, CellPhoneLiveActivity.class);
        intent.putExtra(ROOM_ID, roomId);
        intent.putExtra(IS_FROM_FACE_SCORE, isFromFaceScore);
        context.startActivity(intent);
    }

    @Override
    protected void initListener() {
        mVideoView.setOnBufferingUpdateListener(this);
        mVideoView.setOnCompletionListener(this);
        mVideoView.setOnInfoListener(this);
        mVideoView.setOnPreparedListener(this);
        mVideoView.setOnErrorListener(this);
    }

    private void initDanm(int roomId) {
        mDanmuProcessor = new DanmuProcessor();
        mDanmuProcessor.configDanmu();
        mDanmuProcessor.setCallBack(mDanmakuView);
        mDanmuProcessor.addDanmu(roomId);
    }

    @Override
    protected void onEvent() {
        Intent intent = getIntent();
        mRoomId = intent == null ? "" : intent.getStringExtra(ROOM_ID);
        mIsFromFS = intent == null ? false : intent.getBooleanExtra(IS_FROM_FACE_SCORE, false);
        mPresenter = (CellPhoneContract.Presenter) getPresenter();
        mPresenter.getLiveVideoInfo(mRoomId);
        initDanm(Integer.parseInt(mRoomId));
        mVideoView.setKeepScreenOn(true);
        mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_STRETCH, 0);
        MediaController mediaController = new MediaController(this);
        mediaController.setVisibility(View.VISIBLE);
        mediaController.show(5000);
        mVideoView.setMediaController(mediaController);
        mVoice$Lightness = new Voice$Lightness(getHandler(), mControlCenter, mTvControlName, mTvControl, mIvControlImg, this);
        mDetector = new GestureDetector(this, mVoice$Lightness);
    }

    @Override
    protected void handlerMessager(Message msg) {
        mVoice$Lightness.handlerMessager(msg);
        switch (msg.what) {
            case 0x02:
                //CellPhoneLiveActivity.start(this,mRoomId);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (top$bottomVisible) {
                hideControl();
            } else {
                showControl();
            }
        }
        mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onPause() {
        if (mVideoView.isPlaying()) {
            mVideoView.pause();
        }
        if (null != mDanmakuView) {
            mDanmakuView.pause();
        }
        super.onPause();
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        if (!mVideoView.isPlaying()) {
            mVideoView.start();
        }
        if (mDanmakuView.isPaused()) {
            mDanmakuView.start();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!mIsFromFS) {
            if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
            return;
        }
        mVideoView.resume();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    @Override
    protected void onDestroy() {
        if (null != mVideoView) {
            mVideoView.stopPlayback();
        }
        if (null != mDanmuProcessor) {
            mDanmuProcessor.finish();
        }
        //释放弹幕资源
        if (null != mDanmakuView) {
            mDanmakuView.release();
            mDanmakuView.clear();
            mDanmakuView = null;
        }
        super.onDestroy();
    }

    @Override
    public void onLiveVideoInfoSuccess(LivePathBean data) {
        String hls_url = data.getData().getHls_url();
        Uri uri = Uri.parse(hls_url);
        mVideoView.setVideoURI(uri);
        mVideoView.setBufferSize(1024 * 1024 * 20);
        mVideoView.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        mVideoView.requestFocus();
    }


    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {
        //LogUtil.i(TAG, "onBufferingUpdate = " + percent);
        mLoadingPercent.setText(CommentUtil.fillHtmlString(this, R.string.loading_percent, percent));
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        LogUtil.i(TAG, "onCompletion = " + mp.getMetaEncoding());
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        //LogUtil.i(TAG, "mp = [" + mp + "], what = [" + what + "], extra = [" + extra + "]");
        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START://开始缓冲
                LogUtil.i(TAG, "开始缓冲");
                mLoadingContainer.setVisibility(View.VISIBLE);
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END://结束缓冲
                LogUtil.i(TAG, "结束缓冲");
                mLoadingContainer.setVisibility(View.GONE);
                if (!mVideoView.isPlaying()) {
                    mVideoView.start();
                }
                break;
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED://正在缓冲的下载速率
                LogUtil.i(TAG, "正在缓冲的下载速率");
                break;
            default:
        }
        return false;
    }

    boolean mDanmuToggle = true;

    @OnClick({R.id.iv_back, R.id.iv_pause, R.id.iv_refresh, R.id.iv_danmu})
    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
            case R.id.iv_pause:
                @DrawableRes int danmuDrawableResId;
                if (mVideoView.isPlaying()) {
                    mVideoView.pause();
                    danmuDrawableResId = R.drawable.img_live_videoplay;
                    mIvPause.setImageResource(R.drawable.img_live_videoplay);
                } else {
                    danmuDrawableResId = R.drawable.img_live_videopause;
                    mVideoView.start();
                }
                mIvPause.setImageResource(danmuDrawableResId);
                break;
            case R.id.iv_refresh:
                mPresenter.getLiveVideoInfo(mRoomId);
                break;
            case R.id.iv_danmu:
                @DrawableRes int videoStateDrawableResId;
                if (mDanmuToggle) {
                    mDanmakuView.hide();
                    videoStateDrawableResId = R.drawable.pad_play_closedanmu;
                } else {
                    mDanmakuView.show();
                    videoStateDrawableResId = R.drawable.pad_play_opendanmu;
                }
                mIvDanmu.setImageResource(videoStateDrawableResId);
                mDanmuToggle = !mDanmuToggle;
                break;
            default:
        }
    }

    boolean top$bottomVisible = true;

    private void hideControl() {
        boolean TopVisible = mTopControl.getVisibility() == View.VISIBLE;
        if (TopVisible) {
            mTopControl.setVisibility(View.GONE);
            top$bottomVisible = false;
        }
        boolean bottomVisible = mBottomControl.getVisibility() == View.VISIBLE;
        if (bottomVisible) {
            mBottomControl.setVisibility(View.GONE);
            top$bottomVisible = false;
        }
    }

    private void showControl() {
        boolean TopGone = mTopControl.getVisibility() == View.GONE;
        if (TopGone) {
            mTopControl.setVisibility(View.VISIBLE);
            top$bottomVisible = true;
        }
        boolean bottomGone = mBottomControl.getVisibility() == View.GONE;
        if (bottomGone) {
            mBottomControl.setVisibility(View.VISIBLE);
            top$bottomVisible = true;
        }
    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.setPlaybackSpeed(1.0f);
        LogUtil.i(TAG, "mp = [" + mp.getTimedTextPath() + "]");
    }

    @Override
    public void onErro(String msg) {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    protected void detech() {
        if (null != mPresenter) {

            mPresenter.detattch();
        }

        if (null != mVideoView) {

            mVideoView.suspend();
        }
    }


    @Override
    protected void attach() {
        mPresenter.attach(this);
    }

    @Override
    protected int getContentViewId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        Vitamio.isInitialized(this);
        return R.layout.activity_cell_phone_live;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        RxToast.error("主播早赶来的路上");
        return true;
    }

}
