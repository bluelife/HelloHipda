package com.bluelife.mm.hipdaforum.data.source.mapper;

import android.util.Log;

import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.utils.StringFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/12.
 */
public class BoardsMapper implements DataMapper<List<Board>> {
    @Override
    public Observable<List<Board>> transform(String body) throws IOException{

        Document document= Jsoup.parse(body);

        Elements boardElements=document.select("div[class=mainbox list]");
        List<Board> boardList=new ArrayList<>();
        for (int i = 0; i < boardElements.size(); i++) {
            Element catelog=boardElements.get(i);
            String catelogName=catelog.select("h3").text();
            Elements boards=catelog.select("tbody");
            for (int j = 0; j < boards.size(); j++) {

                Element board=boards.get(j);
                String title=board.select("h2 a").text();
                String url=board.select("h2 a").attr("href");
                String exp=board.select("p").text();
                String nums=board.select("td[class=forumnums]").text();
                String count=board.select("h2 em strong").text();
                Board boardItem=Board.create(j,url,title,exp,count);
                boardList.add(boardItem);
            }
        }
        return Observable.just(boardList);
    }
}
