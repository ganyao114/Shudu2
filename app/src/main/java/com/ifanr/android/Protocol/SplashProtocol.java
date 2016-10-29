package com.ifanr.android.Protocol;

import com.ifanr.android.Model.Bean.ShuduNumberList;
import com.ifanr.android.Model.Bean.VersionResponse;
import com.ifanr.android.Model.Http.BaseModel;
import com.ifanr.android.Presenter.BasePresenter;

import rx.Subscription;

/**
 * Created by ganyao on 2016/10/27.
 */

public interface SplashProtocol {

    public interface View{
        public void onVersionResult(VersionResponse version);
        public void onVersionFailed(String msg);
        public void onDataResult(ShuduNumberList list);
        public void onDataFailed(String msg);
    }

    public interface Model{
        public Subscription getAds(String action);
        public Subscription getVersion(String version);
        public Subscription getNumberList(String order, String orderBy);
    }

    public interface Presenter extends BasePresenter.IBaseCallBack{
        public void getAds();
        public void getVersion();
        public void getNumberList();
    }

}
