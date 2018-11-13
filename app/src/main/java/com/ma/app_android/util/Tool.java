package com.ma.app_android.util;

import android.widget.Toast;

import com.ma.app_android.base.MyApplication;

/**
 * 项目名：app_android
 * 包名：com.ma.app_android.util
 * 文件名：Tool
 * 创建者：Mr.Ma
 * 创建时间：2018/11/13 22:31
 * 描述：TODO
 */
public class Tool {
    public void showToast(String text) {
        Toast.makeText(MyApplication.getContext(), text, Toast.LENGTH_SHORT).show();
    }
}
