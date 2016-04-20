package com.bluelife.mm.hipdaforum.data.source.local;

import android.content.Context;
import android.util.Log;

import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.Thread;
import com.bluelife.mm.hipdaforum.data.source.ForumDataSource;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.QueryObservable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@Singleton
public class ForumLocalSource implements ForumDataSource {

    @Inject
    BriteDatabase briteDatabase;
    @Inject
    public ForumLocalSource(){

    }
    @Override
    public Observable<List<Board>> getBoards() {
        Observable<List<Board>> boards=briteDatabase.createQuery(Board.TABLE_NAME,Board.SELECT_ALL).mapToList(Board.CURSOR_MAPPER);
        if(boards.toBlocking().first().size()==0){
            return Observable.empty();
        }
        else {
            return boards;
        }
    }

    @Override
    public void saveBoard(Board board) {
        long id=briteDatabase.insert(Board.TABLE_NAME,new Board.Marshal(board).asContentValues());
    }

    @Override
    public Observable<List<Thread>> getThreads() {
        return null;
    }
}
