package cyou.bike.com.live.struct;

/**
 * Created by：anlonglong
 * on 2017/11/11 19:04
 * Email: anlonglong0721@gmail.com
 */

public abstract class FunctionHaveResultHaveParams<Result,Params> extends FunctionName {
    public FunctionHaveResultHaveParams(String funName) {
        super(funName);
    }

    public abstract  Result function(Params params);
}
