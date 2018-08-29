package com.framgia.music_25.screen.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.framgia.music_25.R;
import com.framgia.music_25.data.source.local.GenreTitle;
import com.framgia.music_25.screen.BaseFragment;
import java.util.Arrays;
import java.util.List;

/**
 * Home Screen.
 */
public class HomeFragment extends BaseFragment
        implements HomeContract.View, GenreAdapter.OnGenreClickListener {

    private RecyclerView mRecyclerGenres;
    private HomeContract.Presenter mPresenter;
    private Context mContext;
    private List<String> mGenreTitles;

    public HomeFragment() {
        mGenreTitles = Arrays.asList(GenreTitle.GENRE_TITLES);
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new HomePresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupRecycler();
    }

    private void initViews(View view) {
        mRecyclerGenres = view.findViewById(R.id.recycler_genres);
    }

    private void setupRecycler() {
        GenreAdapter genreAdapter = new GenreAdapter(mContext, mGenreTitles, this);
        mRecyclerGenres.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerGenres.setAdapter(genreAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
        super.onStop();
    }

    @Override
    public void onGenreClick(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
    }
}
