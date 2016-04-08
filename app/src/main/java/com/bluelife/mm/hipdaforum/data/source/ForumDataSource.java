package com.bluelife.mm.hipdaforum.data.source;

import com.bluelife.mm.hipdaforum.data.Board;

import java.util.List;

import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/8.
 */
public interface ForumDataSource {

    Observable<List<Board>> getBoards();

}
