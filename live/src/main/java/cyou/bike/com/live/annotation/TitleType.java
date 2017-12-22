package cyou.bike.com.live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cyou.bike.com.live.dyenmu.TitleCategory;

/**
 * Created by：anlonglong
 * on 2017/11/23 10:00
 * Email: anlonglong0721@gmail.com
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.ANNOTATION_TYPE)
public @interface TitleType {
    TitleCategory[] titleCate() default {};
}
