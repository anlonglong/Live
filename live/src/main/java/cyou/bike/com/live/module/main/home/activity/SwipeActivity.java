package cyou.bike.com.live.module.main.home.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by：anlonglong
 * on 2017/12/13 21:53
 * Email: anlonglong0721@gmail.com
 */

public abstract class SwipeActivity<P extends BasePresenter> extends SwipeBackActivity {
    private Handler mHandler;
    private Unbinder mBind;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        setSwipeBackEnable(true);
        SwipeBackLayout swipeBackLayout = getSwipeBackLayout();
        swipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        swipeBackLayout.setEdgeSize(200);
        mBind = ButterKnife.bind(this);
        initListener();
        loadData(getIntent());
    }



    protected abstract int getContentViewId();

    public Handler getHandler(){
        if (null == mHandler) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    SwipeActivity.this.handlerMessager(msg);
                }
            };
        }
        return this.mHandler;
    }

    @Override
    protected void onDestroy() {
        mBind.unbind();
        detach();
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


    protected abstract void detach();

    protected  void handlerMessager(Message msg) {};

    protected abstract void initListener();

    protected abstract void loadData(Intent intent);

    protected BasePresenter getPresenter() {
        return InstanceProxy.getInstance().getPresenter(getClass());
    }

}
