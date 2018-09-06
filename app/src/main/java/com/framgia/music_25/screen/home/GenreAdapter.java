package com.framgia.music_25.screen.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.framgia.music_25.R;
import com.framgia.music_25.utils.StringUtils;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {

    private Context mContext;
    private List<String> mGenreList;
    private HomeContract.Presenter mHomePresenter;
    private OnGenreClickListener mClickListener;

    public GenreAdapter(Context context, List<String> genreList, HomeContract.Presenter homePresenter,
            OnGenreClickListener onGenreClickListener) {
        mContext = context;
        mGenreList = genreList;
        mHomePresenter = homePresenter;
        mClickListener = onGenreClickListener;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_genre, parent, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        holder.bindData(mContext, position, mClickListener);
    }

    @Override
    public int getItemCount() {
        return mGenreList != null ? mGenreList.size() : 0;
    }

    class GenreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mGenreName;
        private TextView mSeeAll;
        private RecyclerView mRecyclerSongs;
        private OnGenreClickListener mListener;

        private GenreViewHolder(View itemView) {
            super(itemView);
            mGenreName = itemView.findViewById(R.id.text_genre_name);
            mSeeAll = itemView.findViewById(R.id.text_see_all);
            mRecyclerSongs = itemView.findViewById(R.id.recycler_tracks_in_genre);
        }

        private void bindData(Context context, int position, OnGenreClickListener listener) {
            mListener = listener;
            String name = mGenreList.get(position);
            mGenreName.setText(StringUtils.capitalize(name));
            mSeeAll.setOnClickListener(this);
            setupSongRecycler(context, name);
        }

        private void setupSongRecycler(Context context, String genreName) {
            mHomePresenter.loadTracksByGenre(genreName);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) mListener.onGenreClick(mGenreName.getText().toString());
        }
    }

    public interface OnGenreClickListener {
        void onGenreClick(String name);
    }
}
