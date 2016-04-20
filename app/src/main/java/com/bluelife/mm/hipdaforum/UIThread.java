package com.bluelife.mm.hipdaforum;

import com.bluelife.mm.hipdaforum.executor.PostExecutionThread;
import com.bluelife.mm.hipdaforum.executor.ThreadExecutor;
import com.bluelife.mm.hipdaforum.utils.FragmentScope;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by slomka.jin on 2016/4/14.
 */

@FragmentScope
public class UIThread implements PostExecutionThread {
    @Inject
    UIThread(){

    }
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
