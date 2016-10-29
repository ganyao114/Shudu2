package com.ifanr.android.Model.Http;

import com.ifanr.android.Model.Bean.BaseResponse;
import com.ifanr.android.Model.Bean.LoginResponse;
import com.ifanr.android.Model.Bean.ShuduNumberItem;
import com.ifanr.android.Model.Bean.ShuduNumberList;
import com.ifanr.android.Model.Bean.VersionResponse;
import com.ifanr.android.Protocol.SplashProtocol;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ganyao on 2016/10/27.
 */

public class SplashModel extends BaseModel implements SplashProtocol.Model {

    public SplashProtocol.Presenter presenter;

    public SplashModel(SplashProtocol.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Subscription getAds(String action) {
        Observable<BaseResponse<VersionResponse>> request = httpApi.getVersion(action).cache();

        Subscription sub = request
                .map(new BaseHttpFunc<VersionResponse>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<VersionResponse>() {
                    @Override
                    public void call(VersionResponse response) {
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

    @Override
    public Subscription getVersion(String version) {
        Observable<BaseResponse<VersionResponse>> request = httpApi.getVersion(version).cache();

        Subscription sub = request
                .map(new BaseHttpFunc<VersionResponse>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<VersionResponse>() {
                    @Override
                    public void call(VersionResponse response) {
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

    @Override
    public Subscription getNumberList(String order, String orderBy) {
        Observable<BaseResponse<List<ShuduNumberItem>>> request = httpApi.getNumbers(order, orderBy).cache();

        Subscription sub = request
                .map(new BaseHttpFunc<List<ShuduNumberItem>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<ShuduNumberItem>>() {
                    @Override
                    public void call(List<ShuduNumberItem> response) {
                        presenter.onSuccess(new ShuduNumberList(response));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        presenter.onFailed(throwable);
                    }
                });
        return sub;
    }
}
