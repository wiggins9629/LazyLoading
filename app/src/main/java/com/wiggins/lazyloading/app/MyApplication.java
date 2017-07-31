package com.wiggins.lazyloading.app;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
