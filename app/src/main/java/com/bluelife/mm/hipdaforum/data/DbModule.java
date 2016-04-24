package com.bluelife.mm.hipdaforum.data;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import com.bluelife.mm.hipdaforum.ApplicationScope;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by slomka.jin on 2016/4/13.
 */
@Module
public class DbModule {
    @Provides
    @ApplicationScope
    SQLiteOpenHelper provideOpenHelper(Application application){
        return new DbOpenHelper(application);
    }

    @Provides
    @ApplicationScope
    SqlBrite provideSqlBrite(){
        return SqlBrite.create(new SqlBrite.Logger() {
            @Override
            public void log(String message) {
                Timber.tag("database").v(message);
            }
        });

    }
    @Provides
    @ApplicationScope
    BriteDatabase provideDatabase(SqlBrite sqlBrite,SQLiteOpenHelper helper){
        BriteDatabase database=sqlBrite.wrapDatabaseHelper(helper, Schedulers.io());
        database.setLoggingEnabled(true);
        return database;
    }
}
