package com.bluelife.mm.hipdaforum.data;

import com.google.auto.value.AutoValue;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@AutoValue
public abstract class Thread {
    abstract String type();
    abstract String id();
    abstract String title();
    abstract String url();
    static Thread create(String type,String id,String title,String url){
        return new AutoValue_Thread(type,id,title,url);
    }
}
