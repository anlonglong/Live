package cyou.bike.com.live.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cyou.bike.com.live.module.main.home.InstanceProxy;

/**
 * 作者：anlonglong on 2017/10/2 10:23
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity  {
    private Handler mHandler;
    private Unbinder mBind;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (isPlayActivity()) {
//            CheckVitamioLibs();
//        }
        setContentView(getContentViewId());
        mBind = ButterKnife.bind(this);
        initListener();
        onEvent();
        attach();
    }

    protected boolean isPlayActivity() {
        return false;
    }

    protected void CheckVitamioLibs() {

    }

    protected abstract void attach();


    protected abstract int getContentViewId();

    public Handler getHandler(){
        if (null == mHandler) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    BaseActivity.this.handlerMessager(msg);
                }
            };
        }
        return this.mHandler;
    }

    @Override
    protected void onDestroy() {
        mBind.unbind();
        detech();
        super.onDestroy();
    }


    public void sendEmptyMessager(int what) {
        getHandler().sendEmptyMessage(what);
    }

    public void removeMassage(int what) {
        getHandler().removeMessages(what);
    }

    public void sendEmptyMessageDelay(int waht,long delatTime){
        getHandler().sendEmptyMessageAtTime(waht,delatTime);
    };


    public void removeCallbacksAndMessages() {
        getHandler().removeCallbacksAndMessages(null);
    }


    protected abstract void detech();

    protected  void handlerMessager(Message msg) {};

    protected abstract void initListener();

    protected abstract void onEvent();

    protected BasePresenter getPresenter() {
        return InstanceProxy.getInstance().getPresenter(getClass());
    }

}
