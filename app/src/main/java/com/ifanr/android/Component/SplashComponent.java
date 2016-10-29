package com.ifanr.android.Component;

import com.ifanr.android.Model.Http.MainModel;
import com.ifanr.android.Model.Http.SplashModel;
import com.ifanr.android.Module.SplashModule;
import com.ifanr.android.Presenter.MainPresenter;
import com.ifanr.android.Presenter.SplashPresenter;
import com.ifanr.android.Protocol.SplashProtocol;
import com.ifanr.android.View.Activity.MainActivity;
import com.ifanr.android.View.Activity.SplashActivity;

import dagger.Component;

/**
 * Created by ganyao on 2016/10/27.
 */
@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {

    void inject(SplashActivity view);

    void inject(SplashPresenter presenter);

    void inject(SplashModel model);

}
