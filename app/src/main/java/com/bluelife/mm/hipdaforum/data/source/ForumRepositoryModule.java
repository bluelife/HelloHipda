package com.bluelife.mm.hipdaforum.data.source;

import android.content.Context;

import com.bluelife.mm.hipdaforum.JobExecutor;
import com.bluelife.mm.hipdaforum.UIThread;
import com.bluelife.mm.hipdaforum.data.source.local.ForumLocalSource;
import com.bluelife.mm.hipdaforum.data.source.remote.ForumRemoteSource;
import com.bluelife.mm.hipdaforum.executor.PostExecutionThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@Module
public class ForumRepositoryModule {
    @Singleton
    @Provides
    @Local
    ForumDataSource providerForumLocalSource(){
        return new ForumLocalSource();
    }

    @Singleton
    @Provides
    @Remote
    ForumDataSource providerForumRemoteSource(Context context){
        return new ForumRemoteSource(context);
    }
    @Provides
    PostExecutionThread provideUiThread(UIThread uiThread){
        return uiThread;
    }
    @Provides
    JobExecutor provideThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }
}
