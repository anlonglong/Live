package com.team.zhuoke.net.callback;

import com.team.zhuoke.utils.LogUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/11/24 上午10:56
 **/
public  abstract class RxSubscriber<T> extends ErrorSubscriber<T> {

    public static final String TAG = RxSubscriber.class.getSimpleName();

    /**
     *  开始请求网络
     */
    @Override
    public void onStart() {
        super.onStart();
        // todo some common as show loadding  and check netWork is NetworkAvailable
        LogUtil.i(TAG,"开始请求网络-------------------");
    }
    /**
     *   请求网络完成
     */
    @Override
    public void onCompleted() {
        LogUtil.i(TAG,"请求网络完成-----------------");
    }
    /**
     *  获取网络数据
     * @param t
     */
    @Override
    public void onNext(T t) {
          LogUtil.i(TAG,"获取网络数据");
          onSuccess(t);
    }
    public abstract  void onSuccess(T t);

}