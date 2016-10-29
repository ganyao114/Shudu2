package com.ifanr.android.Presenter;

import com.ifanr.android.Model.Bean.IResponse;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by ganyao on 2016/10/26.
 */

public class BasePresenter {

    protected CompositeSubscription mCompositeSubscription;

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    //RXjava注册
    public void addSubscription(Subscription subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscriber);
    }

    public interface IBaseCallBack{
        public void onSuccess(IResponse t);
        public void onFailed(Throwable throwable);
    }

}
