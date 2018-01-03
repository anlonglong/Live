package cyou.bike.com.live.module.main.video.module;/**
 * Created by anlonglong on 2017/12/31.
 */

import android.content.Context;

import java.io.IOException;

import cyou.bike.com.live.application.LiveApplication;
import cyou.bike.com.live.base.BaseHttpOutput;
import cyou.bike.com.live.dyenmu.SystemType;
import cyou.bike.com.live.module.main.video.bean.AuthorList;
import cyou.bike.com.live.module.main.video.contract.AuthorListContract;
import cyou.bike.com.live.net.api.home.VideoApi;
import cyou.bike.com.live.net.http.DYHttpRequest;
import cyou.bike.com.live.net.http.HttpListener;
import cyou.bike.com.live.net.http.HttpMethod;
import cyou.bike.com.live.net.http.RequestWrapper;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by anlonglong
 * <p>
 * On 2017/12/31 at 11:33
 * <p>
 * Email : anlonglong0721@gamil.com
 */
public class AuthorListModule implements AuthorListContract.Module {
    private  AuthorListContract.View mView;
    private Context mContext = LiveApplication.getLiveApplication();

    public AuthorListModule(AuthorListContract.View view) {
        this.mView = view;
    }

    @Override
    public AuthorListContract.View getView() {
        return mView;
    }

    @Override
    public void getAuthorVidList(String upId, int offset, int limit) {
        RequestWrapper wrapper = new RequestWrapper(mContext);
        wrapper.putParams("client_sys", SystemType.ANDROID.getSystemType());
        wrapper.putParams("offset", offset);
        wrapper.putParams("limit", limit);
        wrapper.putParams("up_id", upId);
        wrapper.setUrl(VideoApi.GET_AUTHOR_VID_LIST);
        DYHttpRequest.getRequest().setRequestWrapper(wrapper).doRequest(HttpMethod.GET, new HttpListener<AuthorList>() {
            @Override
            public void onFailure(Call call, IOException e) {
                mView.onErro(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response, AuthorList data) throws IOException {
                mView.onAuthorList(data);
            }
        });
    }
}
