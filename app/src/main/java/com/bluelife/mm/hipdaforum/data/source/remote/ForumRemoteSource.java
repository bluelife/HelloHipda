package com.bluelife.mm.hipdaforum.data.source.remote;

import android.content.Context;

import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.Thread;
import com.bluelife.mm.hipdaforum.data.source.ForumDataSource;
import com.bluelife.mm.hipdaforum.data.source.mapper.BoardsMapper;
import com.bluelife.mm.hipdaforum.data.source.mapper.ThreadMapper;
import com.bluelife.mm.hipdaforum.utils.StringFormat;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@Singleton
public class ForumRemoteSource implements ForumDataSource {

    @Inject
    BoardsMapper boardsMapper;
    @Inject
    ThreadMapper threadMapper;

    @Inject
    ForumService forumService;

    @Inject
    public ForumRemoteSource(Context context){

    }
    @Override
    public Observable<List<Board>> getBoards() {
        Observable<List<Board>> boards=forumService.getForumApi().getBoards()
                .flatMap(body -> {
                    try {
                        return boardsMapper.transform(body);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Observable.error(e);
                    }
                });
        return boards;
    }

    @Override
    public void saveBoard(Board board) {

    }

    @Override
    public Observable<List<Thread>> getThreads() {
        Observable<List<Thread>> threads=forumService.getForumApi().getThreads()
                .flatMap(body -> {
                    try {
                        return threadMapper.transform(body);
                    }
                    catch (IOException e){
                        e.printStackTrace();
                        return Observable.error(e);
                    }
                });
        return threads;
    }
}
