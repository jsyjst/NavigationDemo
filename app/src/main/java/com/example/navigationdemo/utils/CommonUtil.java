package com.example.navigationdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;

import com.example.navigationdemo.R;

/**
 * Created by 残渊 on 2018/9/15.
 */

/**
 * 公用的工具类
 */
public class CommonUtil {

    //保存夜间模式的状态
    public static void setData(Context context, boolean nightCode) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context)
                .edit();
        editor.putBoolean("NightCode", nightCode);
        editor.apply();
    }

    //得到夜间模式的状态
    public static boolean getData(Context context) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getBoolean("NightCode", false);
    }


    /**
     * 状态栏的显示和隐藏
     * @param activity
     * @param context
     * @param hide 根据hide的boolean值来决定状态栏的隐藏和显示
     */
    public static void hideStatusBar(Activity activity, Context context,boolean hide) {
        if (Build.VERSION.SDK_INT >= 22) {
            View decorView = activity.getWindow().getDecorView();
            if (hide) {
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            }else{
                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                activity.getWindow().setStatusBarColor(context.getResources().getColor(R.color.colorPrimary));
            }

        }
    }
}
