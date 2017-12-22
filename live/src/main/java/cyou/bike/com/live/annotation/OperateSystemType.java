package cyou.bike.com.live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cyou.bike.com.live.dyenmu.SystemType;

/**
 * Created by：anlonglong
 * on 2017/10/31 22:06
 * Email: anlonglong0721@gmail.com
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.ANNOTATION_TYPE)
public @interface OperateSystemType {
    SystemType[] type() default SystemType.ANDROID;
}
