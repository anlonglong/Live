package cyou.bike.com.live.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.avi.AVLoadingIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cyou.bike.com.live.R;
import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/11/2 14:15
 * Email: anlonglong0721@gmail.com
 */

public class LoadingDialog extends AppCompatDialogFragment {


    private Activity mActivity;
    @BindView(R.id.iv_loading)
    ImageView mLoading;
    Unbinder unbinder;
    private Dialog mDialog;
    private long mlastTime;

    public LoadingDialog(Activity activity, boolean cancable) {
        this.mActivity = activity;
        setCancelable(cancable);
    }

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        if (null == mDialog) {
            mDialog = super.onCreateDialog(savedInstanceState);
            mDialog.setContentView(R.layout.loading_layout);
            mDialog.setCanceledOnTouchOutside(false);
            setUpWindow(mDialog);
            View view = View.inflate(mActivity, R.layout.loading_layout, null);
            mDialog.setContentView(view);
            unbinder = ButterKnife.bind(this, view);
        }
        return mDialog;
    }

    private void setUpWindow(Dialog dialog) {
            Window window = dialog.getWindow();
            WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
            WindowManager manager = (WindowManager) mActivity.getSystemService(Context.WINDOW_SERVICE);
            Point outSize = new Point();
            Display display = manager != null ? manager.getDefaultDisplay() : null;
            display.getRealSize(outSize);
            //attributes.width = outSize.x;
            attributes.gravity = Gravity.CENTER;

    }

//    public void showWithMessage(String msg) {
//        show();
//    }
    
    public void showLoading() {
        show();
        ((AnimationDrawable) mLoading.getDrawable()).start();
    }

    private synchronized void show() {
        if (mActivity instanceof AppCompatActivity) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - mlastTime < 1000 || mActivity.isDestroyed() || mActivity.isFinishing()) {
                return;
            }
            FragmentManager manager = ((AppCompatActivity) mActivity).getSupportFragmentManager();
            try {
                    if (this.isAdded()) {
                        manager.beginTransaction().remove(this).commitAllowingStateLoss();
                    }

                    this.show(manager, null);
                    mlastTime = System.currentTimeMillis();

            } catch (Exception e) {
                LogUtil.e("", e.getMessage(), e);
            }

        } else {
            throw new IllegalArgumentException("only support AppCompativity and it sub-calss");
        }
    }


    public synchronized void dimiss() {
        if (null != mActivity && !mActivity.isFinishing() && !mActivity.isDestroyed()) {
            if (!this.isVisible()) {
                ((AnimationDrawable) mLoading.getDrawable()).stop();
                this.dismiss();
            }
        }
    }

    public boolean isHide() {
        return this.isHidden();
    }

    public boolean isShown() {
        return null != mDialog && mDialog.isShowing();
    }


    @Override
    public void onDestroyView() {
        try{
            unbinder.unbind();
        }catch (Exception e) {
            LogUtil.e("LoadingDialog",e.getMessage(),e);
        }
        super.onDestroyView();
    }
}
