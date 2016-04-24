package com.bluelife.mm.hipdaforum.data.source.remote;

import android.util.Log;

import com.bluelife.mm.hipdaforum.ApplicationScope;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by slomka.jin on 2016/4/12.
 */
@ApplicationScope
public class ForumService {
    private static String BASE_URL="http://www.hi-pda.com/forum/";

    private ForumApi forumApi;

    @Inject
    public ForumService(){
        this(BASE_URL);
    }
    public ForumService(String url){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //.cookieJar(cookieJar)
                .addInterceptor(logging)
                .build();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        forumApi=retrofit.create(ForumApi.class);
    }
    public ForumApi getForumApi(){
        return forumApi;
    }
}
