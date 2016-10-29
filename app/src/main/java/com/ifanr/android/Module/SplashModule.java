package com.ifanr.android.Module;

import com.ifanr.android.Component.ActivityScope;
import com.ifanr.android.Model.Http.MainModel;
import com.ifanr.android.Model.Http.SplashModel;
import com.ifanr.android.Presenter.MainPresenter;
import com.ifanr.android.Presenter.SplashPresenter;
import com.ifanr.android.Protocol.MainProtocol;
import com.ifanr.android.Protocol.SplashProtocol;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ganyao on 2016/10/27.
 */
@Module
public class SplashModule {

    private SplashProtocol.View view;
    private SplashProtocol.Presenter presenter;
    private SplashProtocol.Model model;

    public SplashModule(SplashProtocol.View view) {
        this.view = view;
        this.presenter = new SplashPresenter();
        model = new SplashModel(presenter);
    }

    @Provides
    @ActivityScope
    public SplashProtocol.View provideSplashView() {
        return view;
    }


    @Provides
    @ActivityScope
    public SplashProtocol.Presenter provideMainPresenter() {
        return presenter;
    }

    @Provides
    @ActivityScope
    public SplashProtocol.Model provideMainModel() {
        return model;
    }
}
