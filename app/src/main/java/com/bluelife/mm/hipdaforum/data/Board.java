package com.bluelife.mm.hipdaforum.data;


import com.google.auto.value.AutoValue;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@AutoValue
public abstract class Board {
    static Board create(String url,String name,int count){
        return new AutoValue_Board(url,name,count);
    }
    abstract String url();
    abstract String name();
    abstract int postCountDay();

}
