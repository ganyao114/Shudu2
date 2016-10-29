package com.ifanr.android.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.ifanr.android.Api.ShuduDaoApi;
import com.ifanr.android.Model.Bean.IResponse;
import com.ifanr.android.Model.Bean.LoginResponse;
import com.ifanr.android.Model.Entity.Account;
import com.ifanr.android.Protocol.MainProtocol;

import javax.inject.Inject;

/**
 * Created by ganyao on 2016/10/26.
 */

public class MainPresenter extends BasePresenter implements MainProtocol.Presenter{

    @Inject
    public MainProtocol.View view;
    @Inject
    public MainProtocol.Model model;
    @Inject
    public ShuduDaoApi daoApi;

    public MainPresenter() {
    }

    @Override
    public void login(String name, String pass) {
        addSubscription(model.login(name, pass));
    }


    @Override
    public void onSuccess(IResponse t) {

    }

    @Override
    public void onFailed(Throwable throwable) {
        Toast.makeText((Context) view, "失败" , Toast.LENGTH_LONG).show();
    }
}
