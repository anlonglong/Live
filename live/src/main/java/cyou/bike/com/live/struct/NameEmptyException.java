package cyou.bike.com.live.struct;

import android.content.pm.PackageManager;

/**
 * Created by：anlonglong
 * on 2017/11/11 19:39
 * Email: anlonglong0721@gmail.com
 */

public class NameEmptyException extends RuntimeException {
    String mString;
    protected NameEmptyException(String msg) {
        super(msg);
        this.mString = msg;
    }

}
