package com.bluelife.mm.hipdaforum.thread.usecase;

import com.bluelife.mm.hipdaforum.JobExecutor;
import com.bluelife.mm.hipdaforum.UIThread;
import com.bluelife.mm.hipdaforum.UseCase;
import com.bluelife.mm.hipdaforum.data.source.ForumRepository;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by HiWin10 on 2016/4/23.
 */
public class GetThread extends UseCase<GetThread.RequestValues> {
    ForumRepository forumRepository;

    @Inject
    public GetThread(JobExecutor threadExecutor, UIThread postExecutionThread,ForumRepository repository) {
        super(threadExecutor, postExecutionThread);
        forumRepository=repository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return forumRepository.getThreads(getRequestValues().id);
    }
    public static class RequestValues extends UseCase.RequestValues {
        private final String id;

        public RequestValues(String fid) {
            id = fid;
        }
    }
}
