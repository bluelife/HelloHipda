package com.bluelife.mm.hipdaforum;

import android.content.Context;

import com.bluelife.mm.hipdaforum.data.source.ForumRepository;
import com.bluelife.mm.hipdaforum.executor.PostExecutionThread;
import com.bluelife.mm.hipdaforum.executor.ThreadExecutor;
import com.bluelife.mm.hipdaforum.utils.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by slomka.jin on 2016/4/8.
 */
@Module
public final class ApplicationModule {

    private final Context mContext;

    ApplicationModule(Context context) {
        mContext = context;
    }

    @Provides
    Context provideApp() {
        return mContext;
    }



}
