package cyou.bike.com.fragmentandactivitycommuncicationstruct.struct;

/**
 * Created by：anlonglong
 * on 2017/11/11 19:39
 * Email: anlonglong0721@gmail.com
 */

public class NameEmptyException extends RuntimeException {
    String mString;
    public NameEmptyException(String msg) {
        this.mString = msg;
    }

}
