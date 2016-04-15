package com.bluelife.mm.hipdaforum.executor;

import rx.Scheduler;

/**
 * Created by slomka.jin on 2016/4/12.
 */
public interface PostExecutionThread {
    Scheduler getScheduler();
}