package com.bluelife.mm.hipdaforum.data.source.mapper;

import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.utils.FileUtils;

import org.junit.Test;
import org.mockito.internal.matchers.Equals;

import java.util.List;

import rx.Observable;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by slomka.jin on 2016/4/19.
 */
public class BoardsMapperTest {

    @Test
    public void testTransform() throws Exception {
        String txt= FileUtils.readTextFromRes(this,"boards.txt","gbk");
        BoardsMapper mapper=new BoardsMapper();
        Observable<List<Board>> observable=mapper.transform(txt);
        List<Board> boards=observable.toBlocking().first();
        Board board=boards.get(0);
        assertThat(boards.size(),is(16));
        assertThat(board.url(),equalTo("forumdisplay.php?fid=5"));
    }
}