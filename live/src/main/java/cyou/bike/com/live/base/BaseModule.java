package cyou.bike.com.live.base;

/**
 * 作者：anlonglong on 2017/10/2 10:18
 */

public interface BaseModule<V extends BaseView> {

    public V getView();

}
