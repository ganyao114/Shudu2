package com.ifanr.android.Model.Bean;

/**
 * Created by ganyao on 2016/10/27.
 */

public interface IResponse {

    public ResponseType getResponseType();

    enum ResponseType{
        Ads,
        Version,
        NumberList,
        Login
    }
}
