package com.team.zhuoke.view.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.team.zhuoke.R;
import com.team.zhuoke.utils.SharedPreferenceUtils;

public class SplashActivity extends AppCompatActivity {
    Handler handler;
    Intent intent;
    private boolean isFirst;
    public static final String IS_FIRST = "isFirst";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
//        这步取值操作不能放在run中，否则会执行两次导致页面跳转出错
        isFirst = SharedPreferenceUtils.getBooleanData(IS_FIRST, true);
//        LogUtils.e("isFirst=" + isFirst);
        handler = new Handler();
//        使用lamb代替new Runnable
        handler.postDelayed(() -> {
//                LogUtils.e(Thread.currentThread().getName() + "++++");
            if (isFinishing()) {
                return;
            }
            if (isFirst) {
                GuideActivity.start(SplashActivity.this);
                SharedPreferenceUtils.setBooleanData(IS_FIRST, false);
            } else {
                MainActivity.start(SplashActivity.this);
            }
        }, 3000);//3000毫秒的延时是为了展示splash页面

    }
}
