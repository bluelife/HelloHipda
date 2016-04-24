package com.bluelife.mm.hipdaforum.boards;

import com.bluelife.mm.hipdaforum.BasePresenter;
import com.bluelife.mm.hipdaforum.BaseView;
import com.bluelife.mm.hipdaforum.data.Board;

import java.util.List;

/**
 * Created by slomka.jin on 2016/4/11.
 */
public interface BoardsContract {
    interface View{

        void showProgress();
        void hideProgress();
        void showLoadingError(String error);
        void showBoards(List<Board> boards);
    }

    interface Present extends BasePresenter{
        void loadBoards(boolean forceUpdate);
        void openThread(Board board);
    }
}
