package com.bway.okhttptest.utils;

/**
 * Created by 卢程
 * 2017/7/6.
 */

public interface OkhttpCallBack {
    void isSuccess(String str);
    void isError(int code,String str);
}
