package cyou.bike.com.live.module.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import cyou.bike.com.live.R;
import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.module.guide.GuideActivity;
import cyou.bike.com.live.module.main.MainActivity;
import cyou.bike.com.live.repository.Config;
import cyou.bike.com.live.repository.ConfigKey;
import cyou.bike.com.live.repository.daggerProvider.RepositoryModule;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        RepositoryModule rm = RepositoryModule.getInstance();
        /**
         * 测试封装的数据库操作类是否可用
         */
        rm.save(ConfigKey.TOKEN,"89175431_12_cd2cb4963d259081_1_54371072");
        rm.save(ConfigKey.AUTH,"43b3facb607f9f0251a49182491bdceb");
        boolean isFirst = rm.isFirstLauncher(ConfigKey.FIRSTLAUNCH, true);
        toGuideOrMainActivity(isFirst);
    }

    private void toGuideOrMainActivity(final boolean isFirstLaunch) {
        LiveApplication.getLiveApplication().getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstLaunch) {
                    GuideActivity.start(SplashActivity.this);
                } else {
                    MainActivity.start(SplashActivity.this,true);
                }
            }
        }, 1000);
    }
}
