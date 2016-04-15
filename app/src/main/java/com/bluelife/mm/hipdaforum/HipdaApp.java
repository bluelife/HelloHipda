package com.bluelife.mm.hipdaforum;

import android.app.Application;
import android.content.Context;

/**
 * Created by slomka.jin on 2016/4/14.
 */
public class HipdaApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static HipdaApp get(Context context){
        return (HipdaApp) context.getApplicationContext();
    }
}
