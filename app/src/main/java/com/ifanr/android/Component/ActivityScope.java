package com.ifanr.android.Component;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ganyao on 2016/10/26.
 */
@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
