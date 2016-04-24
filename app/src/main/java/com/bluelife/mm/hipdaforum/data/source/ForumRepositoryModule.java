package com.bluelife.mm.hipdaforum.data.source;

import android.app.Application;
import android.content.Context;

import com.bluelife.mm.hipdaforum.ApplicationScope;
import com.bluelife.mm.hipdaforum.JobExecutor;
import com.bluelife.mm.hipdaforum.UIThread;
import com.bluelife.mm.hipdaforum.data.DbModule;
import com.bluelife.mm.hipdaforum.data.source.local.ForumLocalSource;
import com.bluelife.mm.hipdaforum.data.source.mapper.BoardsMapper;
import com.bluelife.mm.hipdaforum.data.source.remote.ForumRemoteSource;
import com.bluelife.mm.hipdaforum.data.source.remote.ForumService;
import com.bluelife.mm.hipdaforum.executor.PostExecutionThread;
import com.squareup.sqlbrite.BriteDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@Module
public class ForumRepositoryModule {
    @ApplicationScope
    @Provides
    @Local
    ForumDataSource providerForumLocalSource(BriteDatabase database){
        return new ForumLocalSource(database);
    }

    @ApplicationScope
    @Provides
    @Remote
    ForumDataSource providerForumRemoteSource(Application context,ForumService service){
        return new ForumRemoteSource(context,service);
    }

    @ApplicationScope
    @Provides
    BoardsMapper provideBoardsMapper(BoardsMapper boardsMapper){
        return boardsMapper;
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
