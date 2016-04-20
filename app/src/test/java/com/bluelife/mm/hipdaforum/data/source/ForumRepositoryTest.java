package com.bluelife.mm.hipdaforum.data.source;

import com.bluelife.mm.hipdaforum.data.Board;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by slomka.jin on 2016/4/18.
 */
public class ForumRepositoryTest {

    @Mock
    ForumDataSource localSource;
    @Mock
    ForumDataSource remoteSource;
    private ForumRepository forumRepository;
    private Observable<List<Board>> observable;
    private Board board1;
    private Board board2;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        forumRepository=new ForumRepository(localSource,remoteSource);
        List<Board> boards=new ArrayList<>();
        board1=Board.create(1,"url","name1","exp","2");
        board2=Board.create(2,"url","name2","exp","4");
        boards.add(board1);
        boards.add(board2);
        observable=Observable.just(boards);
    }

    @Test
    public void getBoards_cached(){


    }

    @Test
    public void getBoards_firstReturnRemote(){
        Observable<List<Board>> emptyObservable=Observable.empty();
        when(remoteSource.getBoards()).thenReturn(observable);
        when(localSource.getBoards()).thenReturn(emptyObservable);
        Observable<List<Board>> boardsObservable=forumRepository.getBoards();
        List<Board> boards=boardsObservable.toBlocking().first();
        assertThat(boards.size(),is(2));
        assertThat(boards,containsInAnyOrder(board1,board2));
        verify(localSource,atLeast(2)).saveBoard(any(Board.class));

    }
    @Test
    public void getBoards_returnLocal(){
        Observable<List<Board>> emptyObservable=Observable.empty();
        when(remoteSource.getBoards()).thenReturn(emptyObservable);
        when(localSource.getBoards()).thenReturn(observable);
        Observable<List<Board>> boardsObservable=forumRepository.getBoards();
        List<Board> boards=boardsObservable.toBlocking().first();
        assertThat(boards.size(),is(2));
        assertThat(boards,containsInAnyOrder(board1,board2));
    }

    @Test
    public void getBoards_returnCache(){

    }

    @Test
    public void testGetBoards() throws Exception {

    }

    @Test
    public void testGetThreads() throws Exception {

    }
}