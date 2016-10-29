package com.ifanr.android.Model.Bean;

/**
 * Created by ganyao on 2016/10/26.
 */

public class LoginResponse implements IResponse{

    @Override
    public ResponseType getResponseType() {
        return ResponseType.Login;
    }
}
