package cyou.bike.com.live.repository;


import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * 作者：anlonglong on 2017/10/2 11:51
 */
@Entity(nameInDb = "config")
public class Config {
    /**
     * 6. 主键限制
     眼下，实体必须具有long或Long属性作为其主键。
     这是Android和SQLite的推荐做法。
     如果想要用其他字段作为主键,请将主键属性定义为其它属性，但为其创建唯一索引：
     @Id
     private Long id;
     @Index(unique = true)
     private String key;
     */

    @Id(autoincrement = true)
    private Long id = System.nanoTime();
    
    @Convert(converter = ConfigKeyConverter.class,columnType = String.class)
    @NotNull
    @Index(unique = true)//强制所有的key都是唯一的.
    private ConfigKey key;

    private String value;

    @Generated(hash = 844858158)
    public Config(Long id, @NotNull ConfigKey key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public Config(ConfigKey key, String value) {
        this.key = key;
        this.value = value;
    }

    @Generated(hash = 589037648)
    public Config() {
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ConfigKey getKey() {
        return this.key;
    }

    public void setKey(ConfigKey key) {
        this.key = key;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Config{" +
                "id=" + id +
                ", key=" + key +
                ", value='" + value + '\'' +
                '}';
    }
}
