package com.ifanr.android.Model.Bean;

/**
 * Created by ganyao on 2016/10/27.
 */

public class VersionResponse implements IResponse{
    @Override
    public ResponseType getResponseType() {
        return ResponseType.Version;
    }
}
