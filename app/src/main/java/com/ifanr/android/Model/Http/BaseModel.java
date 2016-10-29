package com.ifanr.android.Model.Http;

import com.ifanr.android.Api.ShuduHttpApi;
import com.ifanr.android.Application.ShuduApplication;
import com.ifanr.android.Exception.ShuduHttpServiceException;
import com.ifanr.android.Model.Bean.BaseResponse;

import javax.inject.Inject;

import rx.functions.Func1;

/**
 * Created by ganyao on 2016/10/26.
 */

public class BaseModel {

    @Inject
    protected ShuduHttpApi httpApi;

    public BaseModel() {
        ShuduApplication.getAppComponent().inject(this);
    }

    /**
     * 返回值公共字段的处理，包括业务异常的抛出
     * @param <T>
     */
    public class BaseHttpFunc<T> implements Func1<BaseResponse<T>, T>{

        @Override
        public T call(BaseResponse<T> baseResponse) {
            int statue = baseResponse.getStatues();
            String msg = baseResponse.getMessage();
            T data = baseResponse.getData();
            if (statue != 0){
                throw new ShuduHttpServiceException(statue, msg);
            }
            return data;
        }
    }

}
