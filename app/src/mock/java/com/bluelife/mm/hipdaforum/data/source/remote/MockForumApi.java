package com.bluelife.mm.hipdaforum.data.source.remote;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/12.
 */
public class MockForumApi implements ForumApi {

    private BehaviorDelegate<ForumApi> delegate;

    public MockForumApi(BehaviorDelegate<ForumApi> delegate) {
        this.delegate = delegate;
    }

    @Override
    public Call<ResponseBody> pm() {
        return null;
    }

    @Override
    public Observable<ResponseBody> login(@Field("loginfield") String type, @Field("username") String name, @Field("password") String pwd) {
        return null;
    }

    @Override
    public Observable<ResponseBody> getBoards() {
        return null;
        //return delegate.returningResponse().getBoards();
    }

    @Override
    public Observable<ResponseBody> getThreads() {
        return null;
    }
    //&inajax=1


}
