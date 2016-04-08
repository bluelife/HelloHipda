package com.bluelife.mm.hipdaforum.data.source;

import com.bluelife.mm.hipdaforum.data.Board;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@Singleton
public class ForumRepository implements ForumDataSource {

    private final ForumDataSource forumLocalSource;

    @Inject
    public ForumRepository(@Remote ForumDataSource forumLocalSource, @Local ForumDataSource forumRemoteSource) {
        this.forumLocalSource = forumLocalSource;
        this.forumRemoteSource = forumRemoteSource;
    }

    private final ForumDataSource forumRemoteSource;

    @Override
    public Observable<List<Board>> getBoards() {
        return null;
    }
}
