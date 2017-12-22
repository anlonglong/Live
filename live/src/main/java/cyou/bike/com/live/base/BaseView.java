package cyou.bike.com.live.base;

import android.content.Context;

/**
 * 作者：anlonglong on 2017/10/2 10:18
 */

public interface BaseView<P extends BasePresenter> {

   // public BasePresenter getPresenter();

    public void onErro(String msg);

    public void onSuccess();



}
