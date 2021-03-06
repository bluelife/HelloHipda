package com.bluelife.mm.hipdaforum.boards.usecase;

import com.bluelife.mm.hipdaforum.JobExecutor;
import com.bluelife.mm.hipdaforum.UIThread;
import com.bluelife.mm.hipdaforum.UseCase;
import com.bluelife.mm.hipdaforum.data.source.ForumRepository;
import com.bluelife.mm.hipdaforum.executor.PostExecutionThread;
import com.bluelife.mm.hipdaforum.executor.ThreadExecutor;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by slomka.jin on 2016/4/11.
 */
public class GetBoards extends UseCase<GetBoards.RequestValues> {

    ForumRepository forumRepository;
    @Inject
    public GetBoards(JobExecutor threadExecutor, UIThread postExecutionThread,ForumRepository forumRepository) {
        super(threadExecutor, postExecutionThread);
        this.forumRepository=forumRepository;
    }


    @Override
    protected Observable buildUseCaseObservable() {
        return forumRepository.getBoards();
    }


    public static class RequestValues extends UseCase.RequestValues {

    }


}
