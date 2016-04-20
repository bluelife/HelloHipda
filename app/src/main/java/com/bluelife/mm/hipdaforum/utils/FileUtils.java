package com.bluelife.mm.hipdaforum.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by slomka.jin on 2016/4/20.
 */
public class FileUtils {

    public static String readTextFromRes(Object obj,String fileName,String charset){
        InputStream inputStream=obj.getClass().getClassLoader().getResourceAsStream(fileName);
        return readText(inputStream,charset);
    }
    public static String readText(InputStream inputStream,String charset){
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        String content="";
        try {
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
            content=result.toString(charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
