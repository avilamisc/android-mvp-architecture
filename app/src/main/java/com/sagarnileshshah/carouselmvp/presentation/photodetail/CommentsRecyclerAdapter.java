package com.sagarnileshshah.carouselmvp.presentation.photodetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sagarnileshshah.carouselmvp.R;
import com.sagarnileshshah.carouselmvp.data.models.comment.Comment;
import com.sagarnileshshah.carouselmvp.presentation.photos.PhotosRecyclerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CommentsRecyclerAdapter extends
        RecyclerView.Adapter<CommentsRecyclerAdapter.ViewHolder> {

    private List<Comment> comments;


    public CommentsRecyclerAdapter(List<Comment> comments) {
        this.comments = comments;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvContent)
        TextView tvContent;

        @BindView(R.id.tvAuthor)
        TextView tvAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public CommentsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_comment, parent, false);

        CommentsRecyclerAdapter.ViewHolder viewHolder = new CommentsRecyclerAdapter.ViewHolder(
                view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CommentsRecyclerAdapter.ViewHolder viewHolder, int position) {

        Comment comment = comments.get(position);

        viewHolder.tvContent.setText(comment.getContent());
        viewHolder.tvAuthor.setText(comment.getRealname());

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }


}
