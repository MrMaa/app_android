package com.ma.app_android.util;

import android.util.Log;

/**
 * 项目名：app_android
 * 包名：com.ma.app_android.util
 * 文件名：L
 * 创建者：Mr.Ma
 * 创建时间：2018/11/12 22:28
 * 描述：TODO
 */
public class L {
    //开关
    public static final boolean DEBUG = true;
    //TAG
    public static final String TAG = "app_android";
    //5个等级 DIWEF
    public static void d(String text){
        if (DEBUG){
            Log.d(TAG,text);
        }
    }
    public static void i(String text){
        if (DEBUG){
            Log.i(TAG,text);
        }
    }
    public static void w(String text){
        if (DEBUG){
            Log.w(TAG,text);
        }
    }
    public static void e(String text){
        if (DEBUG){
            Log.e(TAG,text);
        }
    }
}
