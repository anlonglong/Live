package com.team.zhuoke.ui.popup;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.team.zhuoke.R;
import com.team.zhuoke.utils.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.basepopup.BasePopupWindow;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class LoginPopWindow extends BasePopupWindow implements View.OnClickListener{



    TextView mTvLoginWay;
    ImageView mBtnClosePopup;
    TextView mTvLoginWx;

    TextView mTvLoginQq;

    TextView mTvLoginWb;

    TextView mTvLoginDouyu;

    TextView mTvRegister;

    RelativeLayout mLlLogin;
    private OnItemClickListener mOnItemClickListener;
    private View mView;


    private void init() {
        mTvLoginWay = findView(R.id.tv_login_way);
        mBtnClosePopup = findView(R.id.btn_close_popup);
        mBtnClosePopup.setOnClickListener(this);
        mTvLoginWx = findView(R.id.tv_login_wx);
        mTvLoginWx.setOnClickListener(this);
        mTvLoginQq = findView(R.id.tv_login_qq);
        mTvLoginQq.setOnClickListener(this);
        mTvLoginWb = findView(R.id.tv_login_wb);
        mTvLoginWb.setOnClickListener(this);
        mTvLoginDouyu = findView(R.id.tv_login_douyu);
        mTvLoginDouyu.setOnClickListener(this);
        mTvRegister = findView(R.id.tv_register);
        mTvRegister.setOnClickListener(this);
        mLlLogin = findView(R.id.ll_login);
        mLlLogin.setOnClickListener(this);
    }
    //    @BindView(R.id.ll_login)
//    LinearLayout llLogin;
    public LoginPopWindow(Activity context) {
        super(context);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    protected Animation initShowAnimation() {
        AnimationSet set = new AnimationSet(true);
        AlphaAnimation alph = new AlphaAnimation(0.7f,1.0f);
        ScaleAnimation scal = new ScaleAnimation(0.5f,1.0f,0.5f,1.0f,Animation.ABSOLUTE,getPopupViewHeight()/2,Animation.ABSOLUTE,getPopupViewHeight()/2);
        RotateAnimation rota =new RotateAnimation(0,360,getScreenWidth()/2,getScreenHeight()/2);
        LogUtil.i("xxxx",""+getScreenWidth()/2+"..."+getScreenHeight()/2);
        set.addAnimation( alph);
        set.addAnimation(rota);
        set.addAnimation(scal);
        set.setDuration(1500);
        return set;
    }


    @Override
    protected Animation initExitAnimation() {
        AnimationSet set = new AnimationSet(true);
        AlphaAnimation alph = new AlphaAnimation(1.0f,0.2f);
        ScaleAnimation scal = new ScaleAnimation(1f,0.0f,1f,0.0f,Animation.ABSOLUTE,getPopupViewHeight()/2,Animation.ABSOLUTE,getPopupViewHeight()/2);
        RotateAnimation rota =new RotateAnimation(0,360,getScreenWidth()/2,getScreenHeight()/2);
        LogUtil.i("xxxx",""+getScreenWidth()/2+"..."+getScreenHeight()/2);
        set.addAnimation( alph);
        set.addAnimation(rota);
        set.addAnimation(scal);
        set.setDuration(1500);
        return set;
    }

    @Override
    public View getClickToDismissView() {
        return null;
    }

    @Override
    public View onCreatePopupView() {
        mView = createPopupById(R.layout.popup_login);
        init();
        return mView;
    }


    private <T> T findView(@IdRes int id) {
        return (T)mView.findViewById(id);
    }

    @Override
    public View initAnimaView() {
//        btnClosePopup.setOnClickListener(this);
        return mView;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login_wx:
                if (null != mOnItemClickListener)
                    mOnItemClickListener.loginByWX();
                break;
            case R.id.tv_login_qq:
                if (null != mOnItemClickListener)
                    mOnItemClickListener.loginByQQ();
                break;
            case R.id.tv_login_wb:
                if (null != mOnItemClickListener)
                    mOnItemClickListener.loginByWB();
                break;
            case R.id.tv_login_douyu:
                if (null != mOnItemClickListener)
                    mOnItemClickListener.loginByDouyu();
                break;
            case R.id.tv_register:
                if (null != mOnItemClickListener)
                    mOnItemClickListener.registe();
                break;
            case R.id.btn_close_popup:
                dismiss();
                break;
        }
    }
}
