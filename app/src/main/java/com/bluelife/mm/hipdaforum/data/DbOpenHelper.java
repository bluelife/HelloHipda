package com.bluelife.mm.hipdaforum.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by slomka.jin on 2016/4/13.
 */
public class DbOpenHelper extends SQLiteOpenHelper {
    private final static int VERSION=1;

    public DbOpenHelper(Context context){
        super(context,null,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Board.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
