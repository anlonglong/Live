package cyou.bike.com.live.module.videocontroller.cellphonelive;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cyou.bike.com.live.R;
import cyou.bike.com.live.base.BaseActivity;
import cyou.bike.com.live.utils.LogUtil;
import io.vov.vitamio.utils.ScreenResolution;


/**
 * Created by：anlonglong
 * on 2017/12/6 17:48
 * Email: anlonglong0721@gmail.com
 */

public class Voice$Lightness extends GestureDetector.SimpleOnGestureListener {
    private String TAG = "Voice$Lightness";
    private  Handler mHandler;
    private  RelativeLayout mControlCenter;
    private  TextView mTvControlName;
    private  TextView mTvControl;
    private  ImageView mIvControlImg;
    private  AudioManager audiomanager;
    private  int mShowVolume;
    private  int mShowLightness;

    /**
     * 用来判断手势触摸屏幕的位置
     **/
    private  double mWidth;
    private int maxVolume;
    private  BaseActivity mActivity;

    public Voice$Lightness(Handler handler, RelativeLayout controlCenter, TextView tvControlName, TextView tvControl, ImageView ivControlImg, BaseActivity activity) {
        mHandler = handler;
        mControlCenter = controlCenter;
        mTvControlName = tvControlName;
        mTvControl = tvControl;
        mIvControlImg = ivControlImg;
        mWidth = ScreenResolution.getResolution(tvControl.getContext()).first;
        audiomanager = (AudioManager) controlCenter.getContext().getSystemService(Context.AUDIO_SERVICE);
        maxVolume = audiomanager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        mActivity = activity;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        float x = e1.getX();
        float disX = Math.abs(distanceX);
        float disY = Math.abs(distanceY);
        LogUtil.i(TAG, "disX = " + disX + ", disY = " + disY);
        if (disX < disY) {
              int FLAG_ADD = 1;
            if (distanceY > 0) { //上滑
                if (x >= mWidth * 0.65) {
                    //shengyin+
                    changedVoice(FLAG_ADD);
                } else {
                    //guangxin+
                    changedLight(FLAG_ADD);
                }
            } else { //下滑
                int FLAG_SUB = -1;
                if (x >= mWidth * 0.65) {
                    //shengyin-
                    changedVoice(FLAG_SUB);
                } else {
                    //guangxin-
                    changedLight(FLAG_SUB);
                }
            }

        } else {
            // TODO: 2017/12/6 快进和快退的逻辑
        }
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    private void changedVoice(int falg_voice) {
        mShowVolume += falg_voice;
        if (mShowVolume > 100) {
            mShowVolume = 100;
        } else if (mShowVolume < 0) {
            mShowVolume = 0;
        }
        setControlState(true);
    }

    private void setControlState(boolean isFromVoice) {
        mTvControlName.setText(isFromVoice ? "音量" : "亮度");
        mIvControlImg.setImageResource(isFromVoice ? R.drawable.img_volume : R.drawable.img_light);
        mTvControl.setText(isFromVoice ? mShowVolume + "%" : mShowLightness * 100 / 255 + "%");
        if (isFromVoice) {
            audiomanager.setStreamVolume(AudioManager.STREAM_MUSIC, mShowVolume * (maxVolume / 100), 0);
        } else {
            WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
            lp.screenBrightness = mShowLightness / 255f;
            mActivity.getWindow().setAttributes(lp);
            mHandler.removeMessages(0x01);
        }
        mControlCenter.setVisibility(View.VISIBLE);
        mHandler.sendEmptyMessageDelayed(0x01, 1000);
    }

    private void changedLight(int falg_sub) {
        mShowLightness += falg_sub;
        if (mShowLightness > 255) {
            mShowLightness = 255;
        } else if (mShowLightness < 0) {
            mShowLightness = 0;
        }
        setControlState(false);
    }

    public void handlerMessager(Message message) {
        switch (message.what) {
            case 0x01:
                mControlCenter.setVisibility(View.GONE);
                break;
        }
    }
}
