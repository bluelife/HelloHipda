package com.bluelife.mm.hipdaforum.thread;

import com.bluelife.mm.hipdaforum.DefaultSubscriber;
import com.bluelife.mm.hipdaforum.data.Thread;
import com.bluelife.mm.hipdaforum.thread.usecase.GetThread;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by HiWin10 on 2016/4/24.
 */
public class ThreadPresent implements ThreadContract.Present {
    private final ThreadContract.View view;
    private final GetThread getThread;
    private String threadId;

    @Inject
    public ThreadPresent(ThreadContract.View view, GetThread getThread) {
        this.view = view;
        this.getThread = getThread;
    }

    @Override
    public void loadThreads(boolean forceUpdate) {
        GetThread.RequestValues requestValues=new GetThread.RequestValues(threadId);
        getThread.setRequestValues(requestValues);
        getThread.run(new ThreadSubscriber());
    }

    private final class ThreadSubscriber extends DefaultSubscriber<List<Thread>> {
        @Override
        public void onNext(List<Thread> threads) {
            view.showThreads(threads);
        }

        @Override
        public void onCompleted() {
            super.onCompleted();
            view.hideProgress();
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            view.showLoadingError("");
        }
    }
}
