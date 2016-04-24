package com.bluelife.mm.hipdaforum.data.source;

import android.util.Log;

import com.bluelife.mm.hipdaforum.ApplicationScope;
import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.Thread;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@ApplicationScope
public class ForumRepository implements ForumDataSource {

    private final ForumDataSource forumLocalSource;
    private final ForumDataSource forumRemoteSource;
    private List<Board> cachedBoards;
    private List<Thread> cachedThreads;
    @Inject
    public ForumRepository(@Local ForumDataSource forumLocalSource, @Remote ForumDataSource forumRemoteSource) {
        this.forumLocalSource = forumLocalSource;
        this.forumRemoteSource = forumRemoteSource;
        cachedBoards=new ArrayList<>();
        cachedThreads=new ArrayList<>();
    }



    @Override
    public Observable<List<Board>> getBoards() {
        Observable<List<Board>> cachedBoradsObservable=cachedBoards.size()==0?Observable.empty():Observable.just(cachedBoards);
        Observable<List<Board>> localBoards=forumLocalSource.getBoards();
        Observable<List<Board>> remoteBoards=forumRemoteSource.getBoards();
        Observable<List<Board>> remoteBoardsWithLocalUpdate=remoteBoards
                .flatMap(Observable::from).doOnNext(board -> {
                    cachedBoards.add(board);
                    forumLocalSource.saveBoard(board);
                    System.out.println("dddd");
                }).toList();
        Log.w("ssssrr",cachedBoards.size()+"");
        return Observable.concat(cachedBoradsObservable,localBoards,remoteBoardsWithLocalUpdate).first();
        //return remoteBoardsWithLocalUpdate;
    }

    @Override
    public void saveBoard(Board board) {

    }

    @Override
    public Observable<List<Thread>> getThreads(String id) {
        Observable<List<Thread>> cachedThreadList=Observable.from(cachedThreads).toList();
        Observable<List<Thread>> localThreads=forumLocalSource.getThreads(id);
        Observable<List<Thread>> remoteThreads=forumRemoteSource.getThreads(id);
        Observable<List<Thread>> remoteThreadsWithLocalUpdate=remoteThreads
                .flatMap(Observable::from).doOnNext(thread -> {
                    cachedThreads.add(thread);
                }).toList();
        return Observable.concat(cachedThreadList,localThreads,remoteThreadsWithLocalUpdate).first();
    }
}
