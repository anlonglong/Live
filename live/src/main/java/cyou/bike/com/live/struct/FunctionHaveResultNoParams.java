package cyou.bike.com.live.struct;

/**
 * Created by：anlonglong
 * on 2017/11/11 19:03
 * Email: anlonglong0721@gmail.com
 */

public abstract class FunctionHaveResultNoParams<Result> extends FunctionName {
    public FunctionHaveResultNoParams(String funName) {
        super(funName);
    }

    public abstract  Result function();
}
