package cyou.bike.com.live.module.main.live.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cyou.bike.com.live.base.BaseFragment;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by：anlonglong
 * on 2017/12/17 16:32
 * Email: anlonglong0721@gmail.com
 */
@Retention(RUNTIME)
@Target({TYPE})
public @interface ViewCreator {
    Class<? extends BaseFragment> value() ;
}
