package com.example.navigationdemo.application;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.example.navigationdemo.utils.CommonUtil;

/**
 * Created by 残渊 on 2018/10/31.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        if (CommonUtil.getData(this)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }
}
