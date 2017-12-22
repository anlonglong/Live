package cyou.bike.com.fragmentandactivitycommuncicationstruct.struct;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by：anlonglong
 * on 2017/11/11 19:05
 * Email: anlonglong0721@gmail.com
 */

public class FunctionManagers {

    private static FunctionManagers instance = null;

    private Map<String, FunctionNoResultNoParams> mFunctionNoResultNoParams;
    private Map<String, FunctionNoResultHaveParams> mFunctionNoResultHaveParamss;
    private Map<String, FunctionHaveResultHaveParams> mFunctionHaveResultHaveParams;
    private Map<String, FunctionHaveResultNoParams> mFunctionHaveResultNoParams;


    private FunctionManagers() {
        mFunctionNoResultNoParams = new HashMap<>();
        mFunctionNoResultHaveParamss = new HashMap<>();
        mFunctionHaveResultHaveParams = new HashMap<>();
        mFunctionHaveResultNoParams = new HashMap<>();
    }

    public static FunctionManagers getInstance() {
        if (instance == null) {
            synchronized (FunctionManagers.class) {
                if (instance == null) {
                    instance = new FunctionManagers();
                }
            }
        }
        return instance;
    }

    public FunctionManagers addFunction(FunctionNoResultNoParams functionNoResultNoParams) {
        if (null != mFunctionNoResultNoParams) {
            mFunctionNoResultNoParams.put(functionNoResultNoParams.getFunName(), functionNoResultNoParams);
        }
        return this;
    }

    @NonNull
    public FunctionManagers addFunction(FunctionHaveResultNoParams functionHaveResultNoParams) {
        if (null != mFunctionNoResultNoParams) {
            mFunctionHaveResultNoParams.put(functionHaveResultNoParams.getFunName(), functionHaveResultNoParams);
        }
        return this;
    }

    @NonNull
    public FunctionManagers addFuncation(FunctionName function) {
        if (function instanceof FunctionNoResultNoParams) {
            mFunctionNoResultNoParams.put(function.getFunName(), (FunctionNoResultNoParams) function);
        } else if (function instanceof FunctionHaveResultNoParams) {
            mFunctionHaveResultNoParams.put(function.getFunName(), (FunctionHaveResultNoParams) function);
        } else if (function instanceof FunctionNoResultHaveParams) {
            mFunctionNoResultHaveParamss.put(function.getFunName(), (FunctionNoResultHaveParams) function);
        } else if (function instanceof FunctionHaveResultHaveParams) {
            mFunctionHaveResultHaveParams.put(function.getFunName(), (FunctionHaveResultHaveParams) function);
        }
        return this;
    }


    /**
     * 无参数无返回值得接口
     *
     * @param name
     */
    public void invoke(@NonNull String name) {
        if (!TextUtils.isEmpty(name)) {
            if (null != mFunctionNoResultNoParams) {
                if (mFunctionNoResultNoParams.containsKey(name)) {
                    mFunctionNoResultNoParams.get(name).function();
                }
            } else {
                throw new InterfaceNotFoundException("interface name = " + name + " is not fuond");
            }
        } else {
            throw new NameEmptyException("name is empty = " + name);
        }
    }


    /**
     * 有参数有返回值的接口
     *
     * @param name        map中的名字
     * @param resultClass 返回值类型的class的对象
     * @param paramsClass 参数累类的class对象
     * @param <Result>
     * @param <Params>
     * @return
     */
    public <Result, Params> Result invoke(String name, Params paramsClass, Class<Result> resultClass) {
        Result result = null;
        if (TextUtils.isEmpty(name)) {
            if (null != mFunctionHaveResultHaveParams) {
                if (null != mFunctionHaveResultHaveParams) {
                    if (mFunctionHaveResultHaveParams.containsKey(name)) {
                        result = resultClass.cast(mFunctionHaveResultHaveParams.get(name).function(paramsClass));
                    }
                } else {
                    throw new InterfaceNotFoundException("interface name = " + name + " is not fuond");
                }
            }
        } else {
            throw new NameEmptyException("name is empty = " + name);
        }
        return result;
    }


    /**
     * 无参数有返回值的接口
     *
     * @param name     map中的名字
     * @param <Result> 返回值类型
     * @return
     */
    public <Result> Result invoke(String name,Class<Result> clazz) {
        Result result = null;
        if (TextUtils.isEmpty(name)) {
            if (null != mFunctionHaveResultNoParams) {
                if (mFunctionHaveResultNoParams.containsKey(name)) {
                    result = clazz.cast(mFunctionHaveResultNoParams.get(name).function());
                } else {
                    throw new InterfaceNotFoundException("interface name = " + name + " is not fuond");
                }
            }
        } else {
            throw new NameEmptyException("name is empty = " + name);
        }
        return result;
    }


    /**
     * 有参数无返回值的接口
     *
     * @param name
     * @param clazz 参数类型的.class对象
     * @return
     */
    public <Params> void invoke(String name, Params clazz) {
        if (!TextUtils.isEmpty(name)) {
            if (null != mFunctionNoResultHaveParamss) {
                if (mFunctionNoResultHaveParamss.containsKey(name)) {
                    mFunctionNoResultHaveParamss.get(name).function(clazz);
                }
            } else {
                throw new InterfaceNotFoundException("interface name = " + name + " is not fuond");
            }
        } else {
            throw new NameEmptyException("name is empty = " + name);
        }
    }


    /**
     * 函数的返回值并不参与函数的方法签名生成.
     */

    /**http://blog.csdn.net/imzoer/article/details/8039369
     * jvm规定，函数的返回值并不参与“函数签名”的生成，
     * 那么仅仅改变了函数返回值，从而让不能编译的代码通过了编译并且能正常执行了，这不是很矛盾吗？
     原因在于，虽然函数的返回值不参与函数签名的生成，但是在class文件中，
     只要描述符不完全一致的两个方法就能共存于一个class文件中。
     【java代码中，函数的特征签名仅仅包括方法名称、参数类型以及参数顺序。
     但在字节码中，特征签名还包括了方法的返回值以及受查异常表，这就是为什么在class文件中，
     其他都相同仅仅返回值不同的两个方法能共存的原因】
     */

}
