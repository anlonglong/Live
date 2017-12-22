package cyou.bike.com.live.repository;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * 作者：anlonglong on 2017/10/2 20:24
 */

public class ConfigKeyConverter implements PropertyConverter<ConfigKey,String> {

    @Override
    public ConfigKey convertToEntityProperty(String databaseValue) {
        return ConfigKey.getConfigKey(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(ConfigKey entityProperty) {
        return ConfigKey.getName(entityProperty);
    }
}
