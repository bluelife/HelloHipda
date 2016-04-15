package com.bluelife.mm.hipdaforum.boards;

import com.bluelife.mm.hipdaforum.boards.usecase.GetBoards;
import com.bluelife.mm.hipdaforum.data.source.ForumRepositoryComponent;
import com.bluelife.mm.hipdaforum.utils.FragmentScope;

import dagger.Component;
import dagger.Provides;

/**
 * Created by slomka.jin on 2016/4/14.
 */
@FragmentScope
@Component(dependencies = ForumRepositoryComponent.class,modules = BoardsFragmentModule.class)
public interface BoardFragmentComponent {
    @Provides
    GetBoards provideGetBoards();
}
