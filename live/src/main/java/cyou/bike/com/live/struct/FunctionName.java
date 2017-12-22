package cyou.bike.com.live.struct;

/**
 * Created by：anlonglong
 * on 2017/11/11 18:58
 * Email: anlonglong0721@gmail.com
 */

public class FunctionName {
    /**
     * 主要是作为键来从hashMap中找对应的方法.
     */
    private String mFunName;

    public FunctionName(String funName) {
        this.mFunName = funName;
    }

    public String getFunName() {
        return mFunName;
    }
}
