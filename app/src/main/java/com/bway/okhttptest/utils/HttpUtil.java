package com.bway.okhttptest.utils;

import android.view.View;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 卢程
 * 2017/7/6.
 */

public class HttpUtil {
    public void getUrlConnect(String url, final OkhttpCallBack okhttpCallBack){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                okhttpCallBack.isError(500,e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                okhttpCallBack.isSuccess(response.body().string().toString());
            }
        });
    }
}
