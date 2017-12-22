package cyou.bike.com.live.application;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by：anlonglong
 * on 2017/11/29 17:56
 * Email: anlonglong0721@gmail.com
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static CrashHandler instance = null;
    private Context mContextc;
    private Thread.UncaughtExceptionHandler mExceptionHandler;

    private CrashHandler(){

    }

    public static CrashHandler  getInstance()
    {
        if (instance == null) {
            synchronized (CrashHandler.class) {
                if (instance == null) {
                    instance = new CrashHandler();
                }
            }
        }
        return instance;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Toast.makeText(mContextc, e.getMessage(), Toast.LENGTH_SHORT).show();
        mExceptionHandler.uncaughtException(t,e);
    }

    public void init(Context context) {
       Thread.setDefaultUncaughtExceptionHandler(this);
       this.mContextc= context;
        mExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
}
