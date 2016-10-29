package com.ifanr.android.Module;

import com.ifanr.android.Component.ActivityScope;
import com.ifanr.android.Model.Http.MainModel;
import com.ifanr.android.Presenter.MainPresenter;
import com.ifanr.android.Protocol.MainProtocol;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ganyao on 2016/10/26.
 */
@Module
public class MainModule {

    private MainProtocol.View view;
    private MainProtocol.Presenter presenter;
    private MainProtocol.Model model;

    public MainModule(MainProtocol.View mianActivity) {
        this.view = mianActivity;
        presenter = new MainPresenter();
        model = new MainModel(presenter);
    }

    @Provides
    @ActivityScope
    public MainProtocol.View provideMainView() {
        return view;
    }


    @Provides
    @ActivityScope
    public MainProtocol.Presenter provideMainPresenter() {
        return presenter;
    }

    @Provides
    @ActivityScope
    public MainProtocol.Model provideMainModel() {
        return model;
    }

}
