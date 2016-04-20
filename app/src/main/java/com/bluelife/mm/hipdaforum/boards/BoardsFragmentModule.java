package com.bluelife.mm.hipdaforum.boards;

import com.bluelife.mm.hipdaforum.boards.usecase.GetBoards;

import dagger.Module;
import dagger.Provides;

/**
 * Created by slomka.jin on 2016/4/14.
 */
@Module
public class BoardsFragmentModule {

    private final BoardsContract.View view;

    BoardsFragmentModule(BoardsContract.View view){
        this.view=view;
    }

    @Provides
    BoardsContract.View provideView(){
        return view;
    }
    /*@Provides
    BoardsPresent provideBoardspresent(BoardsPresent present){return present;};*/
}
