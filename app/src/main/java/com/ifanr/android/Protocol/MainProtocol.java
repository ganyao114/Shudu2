package com.ifanr.android.Protocol;

import com.ifanr.android.Model.Bean.LoginResponse;
import com.ifanr.android.Presenter.BasePresenter;

import rx.Subscription;

/**
 * Created by ganyao on 2016/10/26.
 */

public interface MainProtocol {

    public interface View{
        public void onLoginSuccess();
        public void onLoginedFailed();
    }

    public interface Presenter extends BasePresenter.IBaseCallBack{
        public void login(String name, String pass);
    }

    public interface Model{
        /**
         * login
         * @param name
         * @param pass
         */
        Subscription login(String name, String pass);
    }

}
