package com.bluelife.mm.hipdaforum.data.source.mapper;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/12.
 */
public interface DataMapper<T> {
    Observable<T> transform(String txt) throws IOException;
}
