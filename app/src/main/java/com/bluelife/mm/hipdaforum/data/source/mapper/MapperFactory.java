package com.bluelife.mm.hipdaforum.data.source.mapper;

/**
 * Created by HiWin10 on 2016/4/23.
 */
public class MapperFactory {

    public static DataMapper create(@MapperType int type){
        switch (type){
            case MapperType.BOARD:
                return new BoardsMapper();
            case MapperType.POST:
                return null;
            case MapperType.THREAD:
                return new ThreadMapper();
            default:
                return null;
        }
    }
}
