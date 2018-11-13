package com.ma.app_android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 项目名：app_android
 * 包名：com.ma.app_android.util
 * 文件名：HttpUtil
 * 创建者：Mr.Ma
 * 创建时间：2018/11/13 19:30
 * 描述：TODO
 */
public class HttpUtil {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }


}
