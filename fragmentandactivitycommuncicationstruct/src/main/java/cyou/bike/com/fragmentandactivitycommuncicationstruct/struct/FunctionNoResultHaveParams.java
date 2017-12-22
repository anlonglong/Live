package cyou.bike.com.fragmentandactivitycommuncicationstruct.struct;

/**
 * Created by：anlonglong
 * on 2017/11/11 19:02
 * Email: anlonglong0721@gmail.com
 */

public abstract class FunctionNoResultHaveParams<Params> extends FunctionName {
    public FunctionNoResultHaveParams(String funName) {
        super(funName);
    }

    public abstract void function(Params params);
}
