package com.bluelife.mm.hipdaforum.boards;

import com.bluelife.mm.hipdaforum.ApplicationComponent;
import com.bluelife.mm.hipdaforum.data.DbComponent;
import com.bluelife.mm.hipdaforum.data.DbModule;
import com.bluelife.mm.hipdaforum.utils.FragmentScope;
import com.squareup.sqlbrite.BriteDatabase;

import dagger.Component;

/**
 * Created by slomka.jin on 2016/4/14.
 */
@FragmentScope
@Component(dependencies = {ApplicationComponent.class,DbComponent.class},modules = BoardsFragmentModule.class)
public interface BoardFragmentComponent {
    BoardsPresent getBoardsPresent();
    //BriteDatabase getBriteDatabase();
}
