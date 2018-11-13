package com.ma.app_android.base;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePalApplication;

/**
 * 项目名：app_android
 * 包名：com.ma.app_android.base
 * 文件名：MyApplication
 * 创建者：Mr.Ma
 * 创建时间：2018/11/13 19:23
 * 描述：TODO
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        LitePalApplication.initialize(context);
    }

    public static Context getContext(){
        return context;
    }
}
