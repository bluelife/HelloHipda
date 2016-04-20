package com.bluelife.mm.hipdaforum;

import android.app.Application;
import android.content.Context;


import com.bluelife.mm.hipdaforum.data.source.DaggerForumRepositoryComponent;
import com.bluelife.mm.hipdaforum.data.source.ForumRepositoryComponent;
import com.bluelife.mm.hipdaforum.data.source.ForumRepositoryModule;

/**
 * Created by slomka.jin on 2016/4/14.
 */
public class HipdaApp extends Application {

    private ForumRepositoryComponent forumRepositoryComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        forumRepositoryComponent= DaggerForumRepositoryComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .forumRepositoryModule(new ForumRepositoryModule())
                .build();
    }

    public static HipdaApp get(Context context){
        return (HipdaApp) context.getApplicationContext();
    }

    public ForumRepositoryComponent getForumRepositoryComponent(){
        return forumRepositoryComponent;
    }

}
