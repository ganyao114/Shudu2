package com.ifanr.android.View.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ifanr.android.Component.AppComponent;
import com.ifanr.android.Component.DaggerMainComponent;
import com.ifanr.android.Component.DaggerSplashComponent;
import com.ifanr.android.Component.MainComponent;
import com.ifanr.android.Component.SplashComponent;
import com.ifanr.android.Model.Bean.ShuduNumberList;
import com.ifanr.android.Model.Bean.VersionResponse;
import com.ifanr.android.Module.MainModule;
import com.ifanr.android.Module.SplashModule;
import com.ifanr.android.Presenter.BasePresenter;
import com.ifanr.android.Presenter.MainPresenter;
import com.ifanr.android.Presenter.SplashPresenter;
import com.ifanr.android.Protocol.SplashProtocol;
import com.ifanr.android.R;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ganyao on 2016/10/27.
 */

public class SplashActivity extends BaseActivity implements SplashProtocol.View {

    @Bind(R.id.image)
    ImageView cover;

    @Inject
    public SplashProtocol.Presenter presenter;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getNumberList();
    }


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        SplashComponent component = DaggerSplashComponent
                .builder()
                .appComponent(appComponent)
                .splashModule(new SplashModule(this))
                .build();
        component.inject(this);
        component.inject((SplashPresenter) presenter);
    }

    @Override
    public void onVersionResult(VersionResponse version) {

    }

    @Override
    public void onVersionFailed(String msg) {

    }

    @Override
    public void onDataResult(ShuduNumberList list) {

    }

    @Override
    public void onDataFailed(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BasePresenter)presenter).onUnsubscribe();
    }
}
