package com.ifanr.android.Component;

import com.ifanr.android.Model.Http.MainModel;
import com.ifanr.android.Module.MainModule;
import com.ifanr.android.Presenter.MainPresenter;
import com.ifanr.android.View.Activity.MainActivity;

import dagger.Component;

/**
 * Created by ganyao on 2016/10/26.
 */
@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity view);

    void inject(MainPresenter presenter);

    void inject(MainModel model);

}
