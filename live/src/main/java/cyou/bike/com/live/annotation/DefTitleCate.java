package cyou.bike.com.live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import cyou.bike.com.live.dyenmu.TitleCategory;

/**
 * Created by：anlonglong
 * on 2017/11/23 10:05
 * Email: anlonglong0721@gmail.com
 */
@Target(ElementType.PARAMETER)
@TitleType(titleCate = {TitleCategory.DIGHOTDATA,TitleCategory.FACEVALUE})
public @interface DefTitleCate {
}
