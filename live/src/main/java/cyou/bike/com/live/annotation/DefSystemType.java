package cyou.bike.com.live.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import cyou.bike.com.live.dyenmu.SystemType;

/**
 * Created by：anlonglong
 * on 2017/10/31 22:09
 * Email: anlonglong0721@gmail.com
 */
@OperateSystemType(type = SystemType.ANDROID)
@Target(value = ElementType.PARAMETER)
public @interface DefSystemType {
}
