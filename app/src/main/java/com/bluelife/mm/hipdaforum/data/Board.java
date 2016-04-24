package com.bluelife.mm.hipdaforum.data;


import android.database.Cursor;
import android.util.Log;

import com.google.auto.value.AutoValue;

import rx.functions.Func1;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@AutoValue
public abstract class Board implements BoardModel{
    public static final Mapper<Board> MAPPER=new Mapper<>(AutoValue_Board::new);
    public static final Func1<Cursor,Board> CURSOR_MAPPER= cursor -> {
        return MAPPER.map(cursor);
    };

    public static final class Marshal extends BoardMarshal<Marshal> {
        public Marshal(BoardModel copy) {
            super(copy);
        }
    }
    public static Board create(long Id,String url,String name,String exp,String count){
        return new AutoValue_Board(Id,url,name,exp,count);
    }
    /*abstract long
    abstract String url();
    abstract String name();
    abstract String exp();
    abstract int postCountDay();*/

}
