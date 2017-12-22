package cyou.bike.com.live.repository.daggerProvider;

import java.util.HashMap;
import java.util.List;

import cyou.bike.com.live.repository.Config;
import cyou.bike.com.live.repository.ConfigKey;
import cyou.bike.com.live.repository.IData;
import cyou.bike.com.live.repository.localrepository.Local;
import cyou.bike.com.live.repository.remoterepository.Remote;

/**
 * 作者：anlonglong on 2017/10/3 13:28
 */
//@Module
public class RepositoryModule implements IData {

    private static RepositoryModule instance = null;
    private Local mLocal;
    private Remote mRemote;
    private HashMap<String, Config> mCache = new HashMap<>();

    private RepositoryModule() {
        mLocal = new Local();
        mRemote = new Remote();
    }

    public static RepositoryModule getInstance() {
        if (instance == null) {
            synchronized (RepositoryModule.class) {
                if (instance == null) {
                    instance = new RepositoryModule();
                }
            }
        }
        return instance;
    }

    public Local getlocal() {
        return mLocal;
    }

    public Remote getRemote() {
        return mRemote;
    }


    public boolean isFirstLauncher(ConfigKey key, boolean defaultValue) {
        return mLocal.isFirstLauncher(key,defaultValue);
    }


    @Override
    public void save(Config f) {
        mCache.put(f.getKey().name(), f);
        mLocal.save(f);
    }

    public void saveBooleanValue(ConfigKey key,boolean value) {
        mCache.put(key.name(),new Config(key,String.valueOf(value)));
        mLocal.saveBooleanValue(key,value);
    }

    @Override
    public void save(ConfigKey key, String value) {
        Config config = new Config();
        config.setKey(key);
        config.setValue(value);
        mCache.put(key.name(), config);
        mLocal.save(key, value);
    }

    public String loadByKey(ConfigKey key,String defVale) {
        String value = defVale;
        if (mCache.containsKey(key.name())) {
            value = mCache.get(key.name()).getValue();
        }else {
            value = mLocal.loadByKey(key,defVale);
        }
        return value;
    }



    @Override
    public Config load(ConfigKey key) {
        Config config = null;
        if (mCache.containsKey(key.name())) {
            config = mCache.get(key.name());
        } else {
            config = mLocal.load(key);
        }
        return config;
    }

    @Override
    public List<Config> loadAll() {
        return mLocal.loadAll();
    }

    @Override
    public void delete(ConfigKey key) {
        if (mCache.containsKey(key.name())) {
            mCache.remove(key.name());
        }
        mLocal.delete(key);
    }

    @Override
    public void deteleAll() {
        mCache.clear();
        mLocal.deteleAll();
    }
}
