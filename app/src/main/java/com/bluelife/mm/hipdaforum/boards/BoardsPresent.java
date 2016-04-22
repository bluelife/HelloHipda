package com.bluelife.mm.hipdaforum.boards;

import com.bluelife.mm.hipdaforum.DefaultSubscriber;
import com.bluelife.mm.hipdaforum.boards.usecase.GetBoards;
import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.ErrorMessageFactory;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by slomka.jin on 2016/4/14.
 */
public class BoardsPresent implements BoardsContract.Present {
    private final BoardsContract.View view;

    private final GetBoards getBoards;

    @Inject
    public BoardsPresent(BoardsContract.View view, GetBoards getBoards) {
        this.view = view;
        this.getBoards = getBoards;
    }

    @Override
    public void loadBoards(boolean forceUpdate) {
        view.showProgress();
        getBoards.run(new BoardsSubscriber());
    }

    @Override
    public void subscribe() {
        loadBoards(false);
    }

    @Override
    public void unsubscribe() {
        getBoards.unsubscribe();
    }

    private final class BoardsSubscriber extends DefaultSubscriber<List<Board>> {
        @Override
        public void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onNext(List<Board> boards) {
            view.hideProgress();
            view.showBoards(boards);
        }

        @Override
        public void onError(Throwable e) {

            //String error= ErrorMessageFactory.create(,e)
            //view.showLoadingError();
        }
    }
}
