package com.bluelife.mm.hipdaforum.data.source.remote;

import android.content.Context;
import android.util.Log;

import com.bluelife.mm.hipdaforum.ApplicationScope;
import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.Thread;
import com.bluelife.mm.hipdaforum.data.source.ForumDataSource;
import com.bluelife.mm.hipdaforum.data.source.mapper.BoardsMapper;
import com.bluelife.mm.hipdaforum.data.source.mapper.DataMapper;
import com.bluelife.mm.hipdaforum.data.source.mapper.MapperFactory;
import com.bluelife.mm.hipdaforum.data.source.mapper.MapperType;
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
@ApplicationScope
public class ForumRemoteSource implements ForumDataSource {
    //@Inject
    ForumService forumService;

    @Inject
    public ForumRemoteSource(Context context,ForumService service){
        forumService=service;
    }
    @Override
    public Observable<List<Board>> getBoards() {

       /* Observable<List<Board>> boards=forumService.getForumApi().getBoards()
                .flatMap(body -> {
                    try {

                        String html=StringFormat.fromGBK(body);
                        Log.w("ssss",html);
                        return boardsMapper.transform(html);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return Observable.error(e);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        return Observable.error(e);
                    }
                });*/
        return getSource(forumService.getForumApi().getBoards(), MapperFactory.create(MapperType.BOARD));
    }

    @Override
    public void saveBoard(Board board) {

    }

    @Override
    public Observable<List<Thread>> getThreads(String id) {
        return getSource(forumService.getForumApi().getThreads(id),MapperFactory.create(MapperType.THREAD));
    }

    private <T> Observable<T> getSource(Observable<ResponseBody> observable, DataMapper<T> mapper){
        Observable<T> resultObservable=observable.flatMap(responseBody -> {
            try {
                String html=StringFormat.fromGBK(responseBody);
                return mapper.transform(html);
            }
            catch (IOException e){
                e.printStackTrace();
                return Observable.error(e);
            }

        });
        return resultObservable;
    }
}
