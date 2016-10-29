package com.ifanr.android.Component;

import android.content.Context;

import com.ifanr.android.Api.IfanrAdsApi;
import com.ifanr.android.Api.ShuduDaoApi;
import com.ifanr.android.Api.ShuduHttpApi;
import com.ifanr.android.Model.Entity.Account;
import com.ifanr.android.Model.Http.BaseModel;
import com.ifanr.android.Module.AppModule;
import com.ifanr.android.Module.ShuduServiceModule;
import com.ifanr.android.Presenter.BasePresenter;
import com.ifanr.android.View.Activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ganyao on 2016/10/26.
 */
@Singleton
@Component(modules = {AppModule.class, ShuduServiceModule.class})
public interface AppComponent {

    void inject(BaseActivity activity);

    void inject(BaseModel model);

    void inject(BasePresenter presenter);

    Context globalContext();

    ShuduHttpApi httpApi();

    IfanrAdsApi adsApi();

    ShuduDaoApi daoApi();

    Account account();
}
