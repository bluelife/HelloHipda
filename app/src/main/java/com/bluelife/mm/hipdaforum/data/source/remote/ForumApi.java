package com.bluelife.mm.hipdaforum.data.source.remote;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/12.
 */
public interface ForumApi {
    @GET("pm.php")
    Call<ResponseBody> pm();
    //&inajax=1
    @FormUrlEncoded
    @POST("logging.php?action=login&loginsubmit=yes&inajax=1")
    Observable<ResponseBody> login(@Field("loginfield") String type, @Field("username") String name, @Field("password") String pwd);

    @GET("index.php")
    Observable<ResponseBody> getBoards();

    @GET("")
    Observable<ResponseBody> getThreads();
}
