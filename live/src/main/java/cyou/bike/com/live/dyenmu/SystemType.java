package cyou.bike.com.live.dyenmu;

import cyou.bike.com.live.utils.LogUtil;

/**
 * Created by：anlonglong
 * on 2017/10/31 22:01
 * Email: anlonglong0721@gmail.com
 */

public enum SystemType {

    ANDROID("android");

    private  String mSystemType;

    SystemType(String sys_type) {
        this.mSystemType = sys_type;
    }

    public String getSystemType() {
        return mSystemType;
    }

    public static SystemType fromName(String systemType) {
        SystemType sysType = null;
        try {
            sysType = valueOf(systemType);
        }catch (Exception e) {
            LogUtil.e("SystemType","not found system type ,"+systemType,e);
        }
        return sysType;
    }

}
