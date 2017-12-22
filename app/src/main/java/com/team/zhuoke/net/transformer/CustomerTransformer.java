package com.team.zhuoke.net.transformer;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by：anlonglong
 * on 2017/11/17 10:08
 * Email: anlonglong0721@gmail.com
 */

public class CustomerTransformer<T,R> implements Observable.Transformer<T,R> {
    @Override
    public Observable<R> call(Observable<T> tObservable) {
        return tObservable.map(new Func1<T, R>() {
            @Override
            public R call(T t) {
                return null;
            }
        });
    }
}
