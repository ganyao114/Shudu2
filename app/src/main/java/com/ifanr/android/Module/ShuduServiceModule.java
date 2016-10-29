package com.ifanr.android.Module;

import com.ifanr.android.Api.IfanrAdsApi;
import com.ifanr.android.Api.ShuduDaoApi;
import com.ifanr.android.Api.ShuduDaoRealmImpl;
import com.ifanr.android.Api.ShuduHttpApi;
import com.ifanr.android.Application.ShuduApplication;
import com.ifanr.android.Application.Static;
import com.ifanr.android.Model.Entity.Account;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ganyao on 2016/10/26.
 */
@Module
public class ShuduServiceModule {

    public static final HttpUrl PRODUCTION_API_URL = HttpUrl.parse(Static.URL);
    public static final HttpUrl PRODUCTION_ADS_URL = HttpUrl.parse(Static.ADS_URL);

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new BasicParamsInterceptor(Static.APP_KEY, Static.SECRET))
                .connectTimeout(5 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(10 * 1000, TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }

    @Provides
    @Singleton
    public HttpUrl provideBaseUrl() {
        return PRODUCTION_API_URL;
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder().client(provideOkHttpClient())
                .baseUrl(provideBaseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public ShuduHttpApi provideHttpApi() {
        return provideRetrofit().create(ShuduHttpApi.class);
    }

    @Provides
    @Singleton
    public IfanrAdsApi provideAdsApi(){
        Retrofit retrofit = new Retrofit.Builder().client(provideOkHttpClient())
                .baseUrl(PRODUCTION_ADS_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(IfanrAdsApi.class);
    }

    @Provides
    @Singleton
    public ShuduDaoApi provideDaoApi(){
        return new ShuduDaoRealmImpl(Realm.getInstance(new RealmConfiguration.Builder(ShuduApplication.getContext())
                .name("myOtherRealm.realm")
                .build()));
    }

    @Provides
    @Singleton
    public Account provideAccount(){
        return new Account();
    }

    /**
     * 公共参数拦截器
     */
    public static class BasicParamsInterceptor implements Interceptor{

        private String appkey;
        private String secret;

        public BasicParamsInterceptor(String appkey, String secret) {
            this.appkey = appkey;
            this.secret = secret;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request oldRequest = chain.request();
            String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
            String singStr = "123";
            String sign = "123";

            HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                    .newBuilder()
                    .scheme(oldRequest.url().scheme())
                    .host(oldRequest.url().host())
                    .addQueryParameter("key", appkey)
                    .addQueryParameter("sign", sign)
                    .addQueryParameter("time", timestamp);

            Request newRequest = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(authorizedUrlBuilder.build())
                    .build();

            return chain.proceed(newRequest);
        }
    }

}
