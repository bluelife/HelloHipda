package com.bluelife.mm.hipdaforum.executor;

import com.bluelife.mm.hipdaforum.UIThread;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by slomka.jin on 2016/4/21.
 */
public class MockPostThread extends UIThread {

    @Override
    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
