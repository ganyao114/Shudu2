package com.ifanr.android.Presenter;

import com.ifanr.android.Model.Bean.IResponse;
import com.ifanr.android.Protocol.SplashProtocol;

import javax.inject.Inject;

/**
 * Created by ganyao on 2016/10/27.
 */

public class SplashPresenter extends BasePresenter implements SplashProtocol.Presenter {

    @Inject
    public SplashProtocol.Model model;

    @Override
    public void getAds() {
        addSubscription(model.getAds(""));
    }

    @Override
    public void getVersion() {
        addSubscription(model.getVersion("lastest"));
    }

    @Override
    public void getNumberList() {
        addSubscription(model.getNumberList("ASC", "date"));
    }

    @Override
    public void onSuccess(IResponse t) {
        switch (t.getResponseType()){
            case Ads:
                break;
            case Version:
                break;
            case NumberList:
                break;
        }
    }

    @Override
    public void onFailed(Throwable throwable) {

    }
}
