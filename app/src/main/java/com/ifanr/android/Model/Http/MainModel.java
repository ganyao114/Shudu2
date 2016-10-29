package com.ifanr.android.Model.Http;

import com.ifanr.android.Model.Bean.BaseResponse;
import com.ifanr.android.Model.Bean.LoginResponse;
import com.ifanr.android.Protocol.MainProtocol;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ganyao on 2016/10/26.
 */

public class MainModel extends BaseModel implements MainProtocol.Model {

    @Inject
    public MainProtocol.Presenter presenter;

    public MainModel(MainProtocol.Presenter presenter) {
        super();
        this.presenter = presenter;
    }
    @Override
    public Subscription login(String name, String pass) {
        Observable<BaseResponse<LoginResponse>> request = httpApi.login(name, pass).cache();

        Subscription sub = request
                .map(new BaseHttpFunc<LoginResponse>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LoginResponse>() {
                    @Override
                    public void call(LoginResponse response) {
                        presenter.onSuccess(response);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        presenter.onFailed(throwable);
                    }
                });
        return  sub;
    }
}
