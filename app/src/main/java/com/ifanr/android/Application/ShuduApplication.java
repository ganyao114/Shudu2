package com.ifanr.android.Application;

import android.app.Application;
import android.content.Context;


import com.ifanr.android.Component.AppComponent;
import com.ifanr.android.Component.DaggerAppComponent;
import com.ifanr.android.Module.AppModule;
import com.ifanr.android.Module.ShuduServiceModule;

/**
 * Created by ganyao on 2016/10/26.
 */

public class ShuduApplication extends Application{

    private static AppComponent appComponent;

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        createAppComp();
    }

    public static Context getContext(){
        return context;
    }

    private void createAppComp(){
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .shuduServiceModule(new ShuduServiceModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
