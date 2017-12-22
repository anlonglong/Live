package cyou.bike.com.live;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by：anlonglong
 * on 2017/11/19 18:20
 * Email: anlonglong0721@gmail.com
 */

public class AppExecutors {
    private Executor mExecutor;
    public AppExecutors(Executor executor) {
        this.mExecutor = executor;
    }

    public AppExecutors(){
        this(Executors.newSingleThreadExecutor());
    }

    public void executor(Runnable command) {
        mExecutor.execute(command);
    }

    public static class MyExec implements Executor{

        public MyExec() {}

        @Override
        public void execute(@NonNull Runnable command) {
            new Thread(command).start();//会开启线程
            command.run();//不会开启线程
        }

    }
    class Socket implements Runnable {
        private String mString;
        private ExecutorService mExecutorService;

        public Socket(String str,int size) {
            this.mString = str;
            mExecutorService = Executors.newFixedThreadPool(size);
        }

        @Override
        public void run() {
            for(;;) {
                mExecutorService.execute(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }
    }
}
