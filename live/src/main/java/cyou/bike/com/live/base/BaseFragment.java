package cyou.bike.com.live.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cyou.bike.com.live.R;
import cyou.bike.com.live.dialog.LoadingDialog;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.utils.CommentUtil;
import cyou.bike.com.live.utils.LogUtil;

/**
 * 作者：anlonglong on 2017/10/2 10:24
 *
 * 视图对用户可见
 * view已经初始化
 * 还未加载过数据
 *
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    private Handler mHandler;
    private Unbinder unbinder;
    private View rootView;
    private boolean hasLoadData,isViewPrepare;
    private LoadingDialog mLoadingDialog;

    protected abstract Class getThisClass();
    private boolean enableEventBus = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommentUtil.resetStateBar(getActivity(), R.color.colorStatueBar);
        Bundle arguments = getArguments();
        if (null != arguments) {
            onFragmentArguements(arguments);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        }else {
            rootView= inflater.inflate(getContentLayoutId(), null);
        }
        unbinder = ButterKnife.bind(this, rootView);
        this.isViewPrepare = true;
        onVisible();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        isViewPrepare = true;
    }

    //对用户是否可见,view是否加载好了,是否是第一次加载数据(只有第一次加载数据,第二次ji以后呢就不再加载数据,来加载的)
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            onVisible();
        }else {
            onInvisible();
        }
    }

    private void onInvisible() {
        LogUtil.i("onInvisible = ",this.getClass().getSimpleName()+"不可见,不能加载数据");
    }

    protected  void onVisible(){
        if (getUserVisibleHint() && !hasLoadData && isViewPrepare) {
            LogUtil.i("onVisible = ",this.getClass().getSimpleName()+"可见,加载数据");
            //Toast.makeText(getContext(), "可见切可以加载数据", Toast.LENGTH_SHORT).show()
            if (isEnableEventBus()) {
                EventBus.getDefault().register(this);
            }
            loadData(rootView);
            initListener();
            hasLoadData = true;
        }
    }



    @NonNull
    public  BasePresenter getPresenter() {
        BasePresenter presenter = InstanceProxy.getInstance().getPresenter(getThisClass());
        return presenter;
    }




    public void setEnableEventBus(boolean enableEventBus) {
        this.enableEventBus = enableEventBus;
    }

    public boolean isEnableEventBus() {
        return enableEventBus;
    }

    protected void onFragmentArguements(Bundle arguments) {
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public  <T> void onData(T t){
        eventMethod(t);
    };

    public <T> void eventMethod(T t) {

    }

    public void postEvent(Object o) {
        EventBus.getDefault().post(o);
    }

    protected abstract void loadData(View view);

    protected  void initListener() {};

    public Handler getHandler() {
        if (null == mHandler) {
            this.mHandler = new Handler(Looper.getMainLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    BaseFragment.this.handlerMessage(msg);
                }
            };
        }
        return mHandler;
    }

    public void sendEmptyMessager(int what) {
        getHandler().sendEmptyMessage(what);
    }

    public void removeMassage(int what) {
        getHandler().removeMessages(what);
    }


    public void removeCallbacksAndMessages() {
        getHandler().removeCallbacksAndMessages(null);
    }

    public void sendEmptyMessageDelayed(int what,long delatTime) {
        getHandler().sendEmptyMessageDelayed(what,delatTime);
    }

    protected void handlerMessage(Message msg) {
    }

    @LayoutRes
    protected abstract int getContentLayoutId();


    @Override
    public void onDetach() {

        super.onDetach();
    }

    @Override
    public void onDestroy() {
        if (isEnableEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        isViewPrepare = false;
        hasLoadData = false;
        detach();
        unbinder.unbind();
        super.onDestroy();
    }

    public void showLoading() {
//        Activity activity = getActivity();
//        if (null == mLoadingDialog) {
//            mLoadingDialog = new LoadingDialog(activity,false);
//        }
//
//        activity.runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mLoadingDialog.show();
//            }
//        });

    }


    public void hideLoading() {
//        Activity activity = getActivity();
//        if (null != mLoadingDialog) {
//            activity.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    mLoadingDialog.dimiss();
//                }
//            });
//        }
    }

    protected abstract void detach();

}
