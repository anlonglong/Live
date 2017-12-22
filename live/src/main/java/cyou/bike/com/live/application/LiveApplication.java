package cyou.bike.com.live.application;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.vondear.rxtools.RxTool;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import cyou.bike.com.live.BuildConfig;
import cyou.bike.com.live.constant.Constants;

import cyou.bike.com.live.greendao.DaoMaster;
import cyou.bike.com.live.greendao.DaoSession;
import cyou.bike.com.live.utils.LogUtil;

/**
 * 作者：anlonglong on 2017/10/2 10:16
 */

public class LiveApplication extends Application {

    public static LiveApplication sLiveApplication;
    private DaoSession mDaoSession;
    private Handler mHandler;

   //https://api.lwl12.com/hitokoto/main/get 获取名言的接口
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Stetho.initializeWithDefaults(this);
        RxTool.init(this);
        sLiveApplication = this;
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                LiveApplication.this.onHandMessage(msg);
            }
        };
        CrashHandler.getInstance().init(this);
        LogUtil.enable = BuildConfig.DEBUG;
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, Constants.DB_NAME);
        Database db = devOpenHelper.getWritableDb();
        if (null == mDaoSession) {
            mDaoSession = new DaoMaster(db).newSession();
        }
        QueryBuilder.LOG_SQL = BuildConfig.DEBUG;
        QueryBuilder.LOG_VALUES = BuildConfig.DEBUG;
    }

    public static LiveApplication getLiveApplication() {
        return sLiveApplication;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public Handler getHandler() {
        return mHandler;
    }

    public void onHandMessage(Message msg) {

    }
}
