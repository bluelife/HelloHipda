package com.bluelife.mm.hipdaforum.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;

/**
 * Created by slomka.jin on 2016/4/12.
 */
public class StringFormat {

    public static String fromGBK(ResponseBody body) throws IOException{
        return body.source().readString(Charset.forName("GBK"));
    }
}
