package com.bluelife.mm.hipdaforum.data.source.mapper;

import com.bluelife.mm.hipdaforum.data.Thread;
import com.bluelife.mm.hipdaforum.utils.StringFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/13.
 */
public class ThreadMapper implements DataMapper<List<Thread>> {
    @Override
    public Observable<List<Thread>> transform(String body) throws IOException {
        Document document= Jsoup.parse(body);
        List<Thread> threads=new ArrayList<>();
        return Observable.from(threads).toList();
    }
}
