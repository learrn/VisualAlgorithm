package com.example.xjc.visualalgorithm.utils;

import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;

public class MeasureUtils {

    public static int getScreenWidth(Context context){
        DisplayMetrics dm =context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context){
        DisplayMetrics dm =context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }
}
