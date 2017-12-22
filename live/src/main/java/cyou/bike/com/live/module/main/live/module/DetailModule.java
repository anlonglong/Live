package cyou.bike.com.live.module.main.live.module;

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.home.InstanceProxy;
import cyou.bike.com.live.module.main.live.annotation.ViewCreator;
import cyou.bike.com.live.module.main.live.bean.DetailBean;
import cyou.bike.com.live.module.main.live.contract.DetailContract;
import cyou.bike.com.live.module.main.live.fragment.DetailFragment;
import cyou.bike.com.live.module.main.live.presenter.DetailPresenter;
import cyou.bike.com.live.net.api.home.HomeApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by：anlonglong
 * on 2017/12/17 12:32
 * Email: anlonglong0721@gmail.com
 */
public class DetailModule implements DetailContract.Module {

    private  DetailContract.View mView;
    private Context mContext = LiveApplication.getLiveApplication();


    public DetailModule(DetailContract.View view) {
        mView = view;
    }

    @Override
    public DetailContract.View getView() {
        //下面这种方法创建的view对象,相当于new一个DetailPresenter对象,然后在调用DetailPresenter里面的view,每次调用这个方法,都会重新new 一个DetailPresenter,所以有可能这样获取到的view为空

      return (DetailContract.View) InstanceProxy.getInstance().getPresenter(DetailPresenter.class).getView();
    }

    @Override
    public void getDetail(String tagId,int offset,int limit) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.name());
        wrapper.putParams("aid",SystemType.ANDROID.name().concat("1"));
        wrapper.putParams("time",System.currentTimeMillis()+"");
        wrapper.putParams("offset",""+offset);
        wrapper.putParams("limit",""+limit);
        wrapper.setUrl(HomeApi.LIVE_URL+"/"+tagId);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<DetailBean>() {
            @Override
            public void onFailure(Call call, IOException e) {
                mView.onErro(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, DetailBean data) throws IOException {
                //下面这样获取到的DetailFragment实例里面的控件都是null;
//                Class<DetailFragment> aClass = DetailFragment.class;
//                ViewCreator annotation = aClass.getAnnotation(ViewCreator.class);
//                if (null != annotation) {
//                    Class<?> value = annotation.value();
//                    try {
//                        DetailFragment detailFragment = (DetailFragment) value.newInstance();
//                        detailFragment.onDetail(data);
//                    } catch (InstantiationException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } finally {
//
//                    }
//                }

                mView.onSuccess();
                mView.onDetail(data);
            }
        });
    }
}
