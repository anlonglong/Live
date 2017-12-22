package cyou.bike.com.live.base;

/**
 * 作者：anlonglong on 2017/10/2 10:18
 */
public interface BasePresenter<V extends BaseView,M extends BaseModule> {

    public V getView();

    public M getModule();

    public void attach(V view);

    public void detattch();

    public boolean isAttach();

}
