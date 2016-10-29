package com.ifanr.android.Api;

import com.ifanr.android.Model.Bean.BaseResponse;
import com.ifanr.android.Model.Bean.LoginResponse;
import com.ifanr.android.Model.Bean.ShuduNumberItem;
import com.ifanr.android.Model.Bean.ShuduNumberList;
import com.ifanr.android.Model.Bean.VersionResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ganyao on 2016/10/26.
 */

public interface ShuduHttpApi {
    /**
     * login
     * @param name
     * @param pass
     * @return
     */
    @GET("/login")
    Observable<BaseResponse<LoginResponse>> login(@Query("name") String name, @Query("pass") String pass);

    /**
     * getVersion
     * @param version
     * @return
     */
    @GET("/version")
    Observable<BaseResponse<VersionResponse>> getVersion(@Query("version") String version);

    /**
     * getNumbers
     * @param order
     * @param orderBy
     * @return
     */
    @GET("api/getnub")
    Observable<BaseResponse<List<ShuduNumberItem>>> getNumbers(@Query("order") String order, @Query("orderby")String orderBy);
}
