package com.bluelife.mm.hipdaforum.boards;

import com.bluelife.mm.hipdaforum.JobExecutor;
import com.bluelife.mm.hipdaforum.UIThread;
import com.bluelife.mm.hipdaforum.UseCase;
import com.bluelife.mm.hipdaforum.boards.usecase.GetBoards;
import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.source.ForumDataSource;
import com.bluelife.mm.hipdaforum.data.source.ForumRepository;
import com.bluelife.mm.hipdaforum.executor.MockPostThread;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by slomka.jin on 2016/4/21.
 */
public class BoardsPresentTest {

    @Mock
    private BoardsContract.View view;
    @Mock
    private ForumRepository forumRepository;

    private GetBoards getBoards;
    @Mock
    ForumDataSource localSource;
    @Mock
    ForumDataSource remoteSource;
    private BoardsPresent boardsPresent;
    private Observable<List<Board>> observable;
    private Board board1;
    private Board board2;
    private List<Board> boards;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        boards=new ArrayList<>();
        board1=Board.create(1,"url","name1","exp","2");
        board2=Board.create(2,"url","name2","exp","4");
        boards.add(board1);
        boards.add(board2);
        observable=Observable.just(boards);
        //stub(forumRepository.getBoards()).toReturn(observable);
        doReturn(observable).when(forumRepository).getBoards();
        getBoards=new GetBoards(new JobExecutor(),new MockPostThread(),forumRepository);

        boardsPresent=new BoardsPresent(view,getBoards);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testLoadBoards() throws Exception {
        boardsPresent.loadBoards(true);
        verify(forumRepository).getBoards();
        verify(view).showProgress();
        verify(view).hideProgress();
        ArgumentCaptor<List> showBoardsArgumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(view).showBoards(showBoardsArgumentCaptor.capture());
        assertEquals(boards,showBoardsArgumentCaptor.getValue());
        //assertThat(showBoardsArgumentCaptor.getValue(),assertEquals(boards));
    }

    @Test
    public void testSubscribe() throws Exception {

    }

    @Test
    public void testUnsubscribe() throws Exception {

    }
}