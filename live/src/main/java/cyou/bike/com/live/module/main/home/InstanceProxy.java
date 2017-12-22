package cyou.bike.com.live.module.main.home;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import cyou.bike.com.live.base.BaseActivity;
import cyou.bike.com.live.base.BaseFragment;
import cyou.bike.com.live.base.BaseModule;
import cyou.bike.com.live.base.BasePresenter;
import cyou.bike.com.live.base.BaseView;
import cyou.bike.com.live.module.main.home.activity.SwipeActivity;
import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/11/1 10:11
 * Email: anlonglong0721@gmail.com
 * desc: 这个类是用来创建 具体的view Presenter moudle的实例的
 */

//这些注解的作用是去掉各种令人不爽的下划线
@SuppressWarnings({"JavaDoc", "WeakerAccess", "Convert2Diamond", "unchecked"})
public class InstanceProxy {

    private static InstanceProxy instance = null;
    private Map mBindMap = new HashMap<Class, Object>();

    private InstanceProxy() {

    }

    public static InstanceProxy getInstance() {
        if (instance == null) {
            synchronized (InstanceProxy.class) {
                if (instance == null) {
                    instance = new InstanceProxy();
                }
            }
        }
        return instance;
    }

    /**
     * @param clazz BasePresenter实现类的Class对象
     * @param <P>
     * @return
     */
    public <P extends BasePresenter> P getPresenter(Class clazz) {
        Class pClass = getClass(clazz);
//        if (null == pClass) {
//            pClass = (Class) pClass.cast(BasePresenter.class);
//        }
        P presenter = getClassByClazz(pClass);
        if (null == presenter) {
            try {
                Object obj = pClass.newInstance();
                if (obj instanceof BasePresenter) {
                    //noinspection unchecked
                    presenter = (P) obj;
                    //noinspection unchecked
                    mBindMap.put(pClass, presenter);
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return presenter;
    }


    /**
     * @param clazz BaseModule实现类的Class对象
     * @param <M>
     * @return
     */
    public <M extends BaseModule> M getModule(Class clazz) {
        Class mClass = getClass(clazz);
        M module = getClassByClazz(mClass);
        if (null == module) {
            try {
                Object obj = mClass.newInstance();
                if (obj instanceof BaseModule) {
                    //noinspection unchecked
                    module = (M) obj;
                    //noinspection unchecked
                    mBindMap.put(mClass, module);
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return module;
    }

    /**
     * @param clazz BaseView实现类的Class对象
     * @param <V>
     * @return
     */
    public <V extends BaseView> V getView(Class clazz) {
        Class vClass = getClass(clazz);
        V view = getClassByClazz(vClass);
        if (null == view) {
            try {
                Object obj = vClass.newInstance();
                if (obj instanceof BaseView) {
                    //noinspection unchecked
                    view = (V) obj;
                    //noinspection unchecked
                    mBindMap.put(vClass, view);
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return view;
    }


    private Class getClass(Class<?> clzz) {
        Class clazz = clzz;
        //clazz 是不是BaseActivity / BaseFragment / SwipeActivity 的子类
        //A.class.isAssignableFrom(B) :B是不是A的子类
        if (BaseActivity.class.isAssignableFrom(clazz) || BaseFragment.class.isAssignableFrom(clazz) || SwipeActivity.class.isAssignableFrom(clazz)) {
            Type gen = clazz.getGenericSuperclass();
            if (gen instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) gen).getActualTypeArguments();
                if (null != types && types.length > 0) {
                    clazz = (Class) types[0];
                }
            }
        }
        return clazz;
    }

//    private Class getClass(Class<?> clzz) {
//        Class clazz = clzz;
//        if (BaseActivity.class.isAssignableFrom(clazz) || BaseFragment.class.isAssignableFrom(clazz)){
//            Type gen = clazz.getGenericSuperclass();
//            if (gen instanceof ParameterizedType) {
//                Type[] types = ((ParameterizedType) gen).getActualTypeArguments();
//                if (null != types && types.length > 0) {
//                    clazz = (Class) types[0];
//                }
//            }
//        }else if (BaseModule.class.isAssignableFrom(clazz) || BaseView.class.isAssignableFrom(clazz)) {
//            Type[] clazzGenericInterfaces = clazz.getGenericInterfaces();
//            if (null != clazzGenericInterfaces && clazzGenericInterfaces.length > 0) {
//                if (clazzGenericInterfaces[0] instanceof ParameterizedType) {
//                    Type[] actualTypeArguments = ((ParameterizedType) clazzGenericInterfaces[0]).getActualTypeArguments();
//                    clazz = (Class) actualTypeArguments[0];
//                }
//            }
//
//        }else if (BasePresenter.class.isAssignableFrom(clazz)) {
//            Type[] clazzGenericInterfaces = clazz.getGenericInterfaces();
//            if (null != clazzGenericInterfaces && clazzGenericInterfaces.length > 0) {
//                if (clazzGenericInterfaces[0] instanceof ParameterizedType) {
//                    Type[] actualTypeArguments = ((ParameterizedType) clazzGenericInterfaces[0]).getActualTypeArguments();
//                    clazz = (Class) actualTypeArguments[0];
//                }
//            }
//        }
//        return clazz;
//    }

    @SuppressWarnings("unused")
    public void cleanBindMap() {
        if (!mBindMap.isEmpty()) {
            mBindMap.clear();
        }
    }

    @SuppressWarnings("unused")
    public Map getBindMap() {
        return mBindMap;
    }

    /**
     * @param clazz 当前类的class对象
     * @param <C>
     * @return
     */
    public <C> C getClassByClazz(Class clazz) {
        C cls = null;
        LogUtil.i("InstanceProxy", "class = " + clazz.getName() + "; map size = " + mBindMap.size());
        if (mBindMap.containsKey(clazz)) {
            cls = (C) mBindMap.get(clazz);
        }
        return cls;
    }


}
