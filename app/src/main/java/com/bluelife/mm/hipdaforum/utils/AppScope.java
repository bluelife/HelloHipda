package com.bluelife.mm.hipdaforum.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import javax.inject.Singleton;

/**
 * Created by slomka.jin on 2016/4/14.
 */
@Scope
@Singleton
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
