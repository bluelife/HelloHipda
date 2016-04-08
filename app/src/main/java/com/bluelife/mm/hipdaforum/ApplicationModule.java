package com.bluelife.mm.hipdaforum;

import android.content.Context;

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
    Context provideContext() {
        return mContext;
    }
}
