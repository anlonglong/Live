package cyou.bike.com.live.struct;

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


    private Map<String,FunctionNoResultNoParams> mFunctionNoResultNoParams;
    private Map<String,FunctionNoResultHaveParams> mFunctionNoResultHaveParamss;
    private Map<String,FunctionHaveResultHaveParams> mFunctionHaveResultHaveParams;
    private Map<String,FunctionHaveResultNoParams> mFunctionHaveResultNoParams;


    private FunctionManagers(){
        mFunctionNoResultNoParams = new HashMap<>();
        mFunctionNoResultHaveParamss = new HashMap<>();
        mFunctionHaveResultHaveParams = new HashMap<>();
        mFunctionHaveResultNoParams = new HashMap<>();
    }

    public static FunctionManagers getInstance()
    {
        if (instance == null) {
            synchronized (FunctionManagers.class) {
                if (instance == null) {
                    instance = new FunctionManagers();
                }
            }
        }
        return instance;
    }

    public FunctionManagers addFunction(FunctionNoResultNoParams functionNoResultNoParams){
        if (null!= mFunctionNoResultNoParams) {
            mFunctionNoResultNoParams.put(functionNoResultNoParams.getFunName(),functionNoResultNoParams);
        }
        return this;
    }

    @NonNull
    public FunctionManagers addFunction(FunctionHaveResultNoParams functionHaveResultNoParams) {
        if (null!= mFunctionNoResultNoParams) {
            mFunctionHaveResultNoParams.put(functionHaveResultNoParams.getFunName(),functionHaveResultNoParams);
        }
        return this;
    }

    @NonNull
    public FunctionManagers addFuncation(FunctionName function) {
        if (function instanceof FunctionNoResultNoParams) {
            mFunctionNoResultNoParams.put(function.getFunName(), (FunctionNoResultNoParams) function);
        }else if (function instanceof FunctionHaveResultNoParams) {
            mFunctionHaveResultNoParams.put(function.getFunName(), (FunctionHaveResultNoParams) function);
        }else if (function instanceof FunctionNoResultHaveParams) {
            mFunctionNoResultHaveParamss.put(function.getFunName(), (FunctionNoResultHaveParams) function);
        }else if (function instanceof FunctionHaveResultHaveParams) {
            mFunctionHaveResultHaveParams.put(function.getFunName(), (FunctionHaveResultHaveParams) function);
        }
        return this;
    }

    /**
     * 无参数无返回值得接口
     * @param name
     */
    public void invoke(@NonNull String name) {
           if (!TextUtils.isEmpty(name)) {
               if (null != mFunctionNoResultNoParams) {
                   if (mFunctionNoResultNoParams.containsKey(name)) {
                       mFunctionNoResultNoParams.get(name).function();
                   }
               }else {
                   throw  new InterfaceNotFoundException("interface name = "+name+" is not fuond");
               }
           }else {
               throw new NameEmptyException("name is empty = "+name);
           }
    }

    /**
     * 有参数无返回值的接口
     * @param name
     * @param clazz 参数类型的.class对象
     * @param <Result> 返回值类型
     * @return
     */
    public <Result> Result invoke(String name,Class<Result> clazz){
        Result result= null;
        if (!TextUtils.isEmpty(name)) {
        if (null != mFunctionHaveResultNoParams) {
            if (mFunctionHaveResultNoParams.containsKey(name)) {
                 result =clazz.cast(mFunctionHaveResultNoParams.get(name).function());
            }
        }else {
            throw  new InterfaceNotFoundException("interface name = "+name+" is not fuond");
        }
        }else {
            throw new NameEmptyException("name is empty = "+name);
        }
        return result;
    }

    public <Result,Params> Result invoke(String name,Class<Result> resultClass,Class<Params> paramsClass){
        Result result = null;
        if (TextUtils.isEmpty(name)) {
            if (null != mFunctionHaveResultHaveParams) {
                if (null != mFunctionHaveResultHaveParams) {
                    if (mFunctionHaveResultHaveParams.containsKey(name)) {
                        result =resultClass.cast(mFunctionHaveResultHaveParams.get(name).function(paramsClass));
                    }
                }else {
                    throw  new InterfaceNotFoundException("interface name = "+name+" is not fuond");
                }
            }
        }else {
            throw new NameEmptyException("name is empty = "+name);
        }
        return result;
    }





}
