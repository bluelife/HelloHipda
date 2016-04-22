package com.bluelife.mm.hipdaforum.data.source.local;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.util.Log;

import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.DbOpenHelper;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by slomka.jin on 2016/4/15.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ForumLocalSourceTest {

    private ForumLocalSource forumLocalSource;
    private BriteDatabase briteDatabase;

    @Before
    public void setUp() throws Exception {
        SqlBrite sqlBrite=SqlBrite.create();
        DbOpenHelper dbOpenHelper=new DbOpenHelper(InstrumentationRegistry.getTargetContext());
        briteDatabase=sqlBrite.wrapDatabaseHelper(dbOpenHelper, Schedulers.io());
        forumLocalSource=new ForumLocalSource();
        forumLocalSource.briteDatabase=briteDatabase;
    }

    @After
    public void tearDown() throws Exception {

        briteDatabase.delete(Board.TABLE_NAME,null,new String[]{});
    }

    @Test
    public void testGetBoards() throws Exception {
        final Board board1=Board.create(1,"url","name1","exp1","2");
        final Board board2=Board.create(2,"url","name2","exp2","4");
        forumLocalSource.saveBoard(board1);
        forumLocalSource.saveBoard(board2);
        Observable<List<Board>> observable=forumLocalSource.getBoards();
        List<Board> boards=observable.toBlocking().first();

        assertTrue(boards.size()>=2);
        assertTrue(boards.contains(board1));
        assertTrue(boards.contains(board2));
    }
    @Test
    public void testEmptyBoards() throws Exception{
        Observable<List<Board>> observable=forumLocalSource.getBoards();
        List<Board> boards=new ArrayList<>();
        final Board board1=Board.create(1,"url","name1","exp1","2");
        final Board board2=Board.create(2,"url","name2","exp2","4");
        boards.add(board1);
        boards.add(board2);
        Observable<List<Board>> observable1=Observable.just(boards);
        Observable<List<Board>> concat=Observable.concat(observable,observable1).first();
        List<Board> boardList=concat.toBlocking().first();
        assertThat(boardList.size(),is(2));
    }
    private Observable<List<Board>> getBoards(){
        List<Board> boards=new ArrayList<>();
        final Board board1=Board.create(1,"url","name1","exp1","2");
        final Board board2=Board.create(2,"url","name2","exp2","4");
        boards.add(board1);
        boards.add(board2);
        return Observable.just(boards);
    }

}