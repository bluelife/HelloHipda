package com.bluelife.mm.hipdaforum;

import android.app.Application;
import android.content.Context;

import com.bluelife.mm.hipdaforum.data.DbModule;

/**
 * Created by slomka.jin on 2016/4/14.
 */
public class HipdaApp extends Application {

    private ApplicationComponent applicationComponent;
    //private ForumRepositoryComponent forumRepositoryComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent=DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        /*forumRepositoryComponent= DaggerForumRepositoryComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .forumRepositoryModule(new ForumRepositoryModule())
                .build();*/
    }

    public static HipdaApp get(Context context){
        return (HipdaApp) context.getApplicationContext();
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
    /*public ForumRepositoryComponent getForumRepositoryComponent(){
        return forumRepositoryComponent;
    }*/

}
