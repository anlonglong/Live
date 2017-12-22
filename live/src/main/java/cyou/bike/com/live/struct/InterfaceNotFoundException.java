package cyou.bike.com.live.struct;

/**
 * Created by：anlonglong
 * on 2017/11/11 19:45
 * Email: anlonglong0721@gmail.com
 */

 class InterfaceNotFoundException extends RuntimeException {

    String mString;

    InterfaceNotFoundException(String msg) {
        this.mString = msg;
    }


}
