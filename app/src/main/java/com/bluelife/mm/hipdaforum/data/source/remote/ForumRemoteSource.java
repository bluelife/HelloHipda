package com.bluelife.mm.hipdaforum.data.source.remote;

import android.content.Context;

import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.source.ForumDataSource;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/8.
 */
public class ForumRemoteSource implements ForumDataSource {

    @Inject
    public ForumRemoteSource(Context context){

    }
    @Override
    public Observable<List<Board>> getBoards() {
        return null;
    }
}
