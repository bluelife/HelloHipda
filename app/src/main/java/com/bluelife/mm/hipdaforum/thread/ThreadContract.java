package com.bluelife.mm.hipdaforum.thread;

import com.bluelife.mm.hipdaforum.data.Thread;

import java.util.List;

/**
 * Created by HiWin10 on 2016/4/23.
 */
public interface ThreadContract {
    interface View{

        void showProgress();
        void hideProgress();
        void showLoadingError(String error);
        void showThreads(List<Thread> threads);
    }
    interface Present{
        void loadThreads(boolean forceUpdate);
    }
}
