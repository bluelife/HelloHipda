package com.bluelife.mm.hipdaforum.boards;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bluelife.mm.hipdaforum.HipdaApp;
import com.bluelife.mm.hipdaforum.R;
import com.bluelife.mm.hipdaforum.data.Board;
import com.bluelife.mm.hipdaforum.data.DaggerDbComponent;
import com.bluelife.mm.hipdaforum.data.DbModule;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by slomka.jin on 2016/4/14.
 */
public class BoardsFragment extends Fragment implements BoardsContract.View{

    @Bind(R.id.boards_list)
    RecyclerView boardsListView;
    @Bind(R.id.boards_bar)
    ProgressBar progressBar;
    @Bind(R.id.load_error_layout)
    LinearLayout loadErrorLayout;
    @Bind(R.id.error_txt)
    TextView errorText;
    private BoardsContract.Present present;
    private BoardListAdapter boardListAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static BoardsFragment newInstance(){
        return new BoardsFragment();
    }
    @Override
    public void onResume() {
        present.loadBoards(true);
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
        present=DaggerBoardFragmentComponent.builder().boardsFragmentModule(new BoardsFragmentModule(this))
                .dbComponent(DaggerDbComponent.builder().dbModule(new DbModule()).build())
                .forumRepositoryComponent(((HipdaApp)getActivity().getApplication()).getForumRepositoryComponent())
                .build()
                .getBoardsPresent();
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        boardsListView.setLayoutManager(layoutManager);
        boardListAdapter=new BoardListAdapter();
        boardsListView.setAdapter(boardListAdapter);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showBoards(List<Board> boards) {
        boardListAdapter.setBoards(boards);
    }

    @Override
    public void showLoadingError(String error) {
        loadErrorLayout.setVisibility(View.VISIBLE);
        errorText.setText(error);
    }
}
