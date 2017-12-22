package cyou.bike.com.live.repository;

import java.util.List;

/**
 * 作者：anlonglong on 2017/10/3 13:18
 */

public interface IData {

    void save(Config t);

    void save(ConfigKey key, String value);


    Config load(ConfigKey key);

    List<Config> loadAll();

    void delete(ConfigKey key);

    void deteleAll();

}
