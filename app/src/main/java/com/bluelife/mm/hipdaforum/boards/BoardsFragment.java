package com.bluelife.mm.hipdaforum.boards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelife.mm.hipdaforum.R;
import com.bluelife.mm.hipdaforum.data.Board;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by slomka.jin on 2016/4/14.
 */
public class BoardsFragment extends Fragment implements BoardsContract.View{

    private BoardsContract.Present present;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static BoardsFragment newInstance(){
        return new BoardsFragment();
    }
    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        present.unsubscribe();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.board_fragment,container,false);

        ButterKnife.bind(this,root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showBoards(List<Board> boards) {

    }

    @Override
    public void showLoadingError(String error) {

    }
}
