package com.ifanr.android.Module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ganyao on 2016/10/26.
 */
@Module
public class AppModule {

    private Application globalApp;

    public AppModule(Application globalApp) {
        this.globalApp = globalApp;
    }

    @Provides
    @Singleton
    public Context providContext(){
        return globalApp;
    }

}
