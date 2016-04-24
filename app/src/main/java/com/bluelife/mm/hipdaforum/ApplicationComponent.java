package com.bluelife.mm.hipdaforum;

import com.bluelife.mm.hipdaforum.data.DbModule;
import com.bluelife.mm.hipdaforum.data.source.ForumRepository;
import com.bluelife.mm.hipdaforum.data.source.ForumRepositoryModule;
import com.squareup.sqlbrite.BriteDatabase;

import dagger.Component;
import dagger.Module;

/**
 * Created by slomka.jin on 2016/4/14.
 */
@ApplicationScope
@Component(modules = {ApplicationModule.class,ForumRepositoryModule.class,DbModule.class})
public interface ApplicationComponent {
    ForumRepository getForumRepository();
    //BriteDatabase  getBriteDatabase();
}
