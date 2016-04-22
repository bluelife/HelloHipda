package com.bluelife.mm.hipdaforum.boards;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluelife.mm.hipdaforum.R;
import com.bluelife.mm.hipdaforum.data.Board;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by slomka.jin on 2016/4/21.
 */
public class BoardListAdapter extends RecyclerView.Adapter<BoardListAdapter.BoardViewHolder> {
    private List<Board> boards=new ArrayList<>();
    @Override
    public BoardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.board_list_item,parent,false);
        BoardViewHolder viewHolder=new BoardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BoardViewHolder holder, int position) {
        holder.bind(boards.get(position));
    }
    public void setBoards(List<Board> boardList){
        boards=boardList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return boards.size();
    }

    public static class BoardViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.board_name)
        TextView boardName;
        @Bind(R.id.board_exp)
        TextView boardExp;
        public BoardViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void bind(Board board){
            boardName.setText(board.name());
            boardExp.setText(board.exp());
        }
    }
}
