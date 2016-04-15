package com.bluelife.mm.hipdaforum.data.source;

import com.bluelife.mm.hipdaforum.ApplicationComponent;
import com.bluelife.mm.hipdaforum.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@Singleton
@Component(dependencies = ApplicationComponent.class,modules = {ForumRepositoryModule.class})
public interface ForumRepositoryComponent {

    ForumRepository getForumRepository();
}
