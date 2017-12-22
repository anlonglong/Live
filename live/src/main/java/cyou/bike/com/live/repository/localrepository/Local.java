package cyou.bike.com.live.repository.localrepository;

import android.text.TextUtils;

import org.greenrobot.greendao.DaoException;

import java.util.ArrayList;
import java.util.List;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.greendao.ConfigDao;
import cyou.bike.com.live.repository.Config;
import cyou.bike.com.live.repository.ConfigKey;
import cyou.bike.com.live.repository.IData;
import cyou.bike.com.live.utils.LogUtil;


/**
 * 作者：anlonglong on 2017/10/2 16:07
 * <p>
 * http://blog.csdn.net/wurensen/article/details/47905519
 */

public class Local implements IData {

    private static final String TAG = Local.class.getSimpleName();
    private ConfigDao mConfigDao;


    public Local() {
        mConfigDao = LiveApplication.getLiveApplication().getDaoSession().getConfigDao();
    }

    public boolean isFirstLauncher(ConfigKey key, boolean defaultValue) {
        //boolean value = defaultValue;
        //Config load = load(key);
        // value = TextUtils.equals(load.getValue()==null?"true":"false",String.valueOf(defaultValue));
        boolean b = loadBooleanValue(key, defaultValue);
        LogUtil.i(TAG, "isFirstLauncher = " + b);
        return b;
    }

    public boolean loadBooleanValue(ConfigKey key, boolean defaultValue) {
        boolean value = defaultValue;
        Config load = load(key);
        if (null == load.getValue()) {
            return true;
        } else {
            try {
                value = Boolean.parseBoolean(load.getValue());
            } catch (Exception e) {
                LogUtil.e(TAG, "boolean 解析异常 = " + load.getValue());
            }
        }

        return value;
    }


    public void saveBooleanValue(ConfigKey key, boolean value) {
        Config config = new Config();
        config.setKey(key);
        config.setValue(String.valueOf(value));
        mConfigDao.insertOrReplace(config);
    }

    public void saveStringValue(ConfigKey key, String value) {
        save(key, value);
    }

    public String loadStringValue(ConfigKey key, String defaultValue) {
        String value = defaultValue;
        Config config = load(key);
        value = config.getValue();
        if (TextUtils.isEmpty(value)) {
            LogUtil.i(TAG,"根据键: "+key.name()+" ,没有找到对用的值");
        }
        return value;
    }


    @Override
    public void save(ConfigKey key, String value) {
        Config config = new Config();
        config.setKey(key);
        config.setValue(value);
        save(config);
    }

    @Override
    public void save(Config t) {
        long l = mConfigDao.insertOrReplace(t);
        LogUtil.i(TAG,"rowId  = "+l);
    }

    @Override
    public Config load(ConfigKey key) {
        Config config = null;
        try {
            config = mConfigDao.queryBuilder().where(ConfigDao.Properties.Key.eq(key.name())).build().uniqueOrThrow();
        } catch (DaoException e) {
            LogUtil.e(TAG, "执行查//"+key.name()+"//询语句的时候出现错误,错误信息 = " + e.getMessage());
            config = new Config();
            config.setKey(key);
        }
        return config;
    }

    public String loadByKey(ConfigKey key, String defValue) {
        String value = defValue;
        Config load = load(key);
        value = load.getValue();
        return value;
    }

    @Override
    public List<Config> loadAll() {
        List<Config> configList = mConfigDao.loadAll();
        return configList == null ? new ArrayList<Config>() : configList;
    }

    @Override
    public void delete(ConfigKey key) {
        Config config = load(key);
        if (null == config) {
            config = new Config();
            config.setKey(key);
        }
        mConfigDao.deleteInTx(config);
    }

    @Override
    public void deteleAll() {
        mConfigDao.deleteAll();
    }
}
