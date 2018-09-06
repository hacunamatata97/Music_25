package com.framgia.music_25.screen.home;

import com.framgia.music_25.data.model.Track;
import com.framgia.music_25.data.repository.TrackRepository;
import com.framgia.music_25.data.source.OnFetchDataListener;
import java.util.List;

/**
 * Listens to user actions from the UI ({@link HomeFragment}), retrieves the data and updates
 * the UI as required.
 */
final class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mViewHome;
    private TrackRepository mTrackRepository;
    private List<Track> mTracks;

    public HomePresenter(HomeContract.View viewHome, TrackRepository trackRepository) {
        mViewHome = viewHome;
        mTrackRepository = trackRepository;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void loadTracksByGenre(String genre) {
        mTrackRepository.getTracks(genre, new OnFetchDataListener<List<Track>>() {
            @Override
            public void onSuccess(List<Track> data) {
                mTracks = data;
            }

            @Override
            public void onError(Exception e) {

            }
        });
    }

    @Override
    public List<Track> getTracks() {
        return mTracks;
    }
}
