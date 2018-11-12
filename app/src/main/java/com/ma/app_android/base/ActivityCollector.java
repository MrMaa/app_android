package com.ma.app_android.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名：app_android
 * 包名：com.ma.app_android.base
 * 文件名：ActivityCollector
 * 创建者：Mr.Ma
 * 创建时间：2018/11/12 22:33
 * 描述：TODO
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
    }



}
