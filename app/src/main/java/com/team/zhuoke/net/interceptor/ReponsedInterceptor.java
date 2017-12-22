package com.team.zhuoke.net.interceptor;

import com.team.zhuoke.utils.LogUtil;

import java.io.IOException;
import java.net.InetAddress;

import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 作者：anlonglong on 2017/9/30 15:37
 */

public class ReponsedInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());

        return proceed;
    }
}
