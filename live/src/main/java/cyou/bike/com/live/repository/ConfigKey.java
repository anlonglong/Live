package cyou.bike.com.live.repository;

import cyou.bike.com.live.utils.LogUtil;

/**
 * 作者：anlonglong on 2017/10/2 19:55
 */

public enum ConfigKey  {

    FIRSTLAUNCH,TOKEN,AUTH;

    public static ConfigKey getConfigKey(String keyStr) {
        ConfigKey key = null;
        try {
            key = valueOf(keyStr);
        }catch (Exception e) {
            LogUtil.e("ConfigKey","Not found enum = "+keyStr);
        }
        return key;
    }

    public static String getName(ConfigKey key) {
       return key.name();
    }

}
