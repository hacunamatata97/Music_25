package com.framgia.music_25.data.repository;

import com.framgia.music_25.data.model.Track;
import com.framgia.music_25.data.source.OnFetchDataListener;
import com.framgia.music_25.data.source.TrackDataSource;
import java.util.List;

public class TrackRepository implements TrackDataSource.RemoteDataSource<List<Track>> {

    private static TrackRepository sInstance;
    private RemoteDataSource<List<Track>> mRemoteDataSource;

    private TrackRepository(RemoteDataSource<List<Track>> remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public static TrackRepository getInstance(RemoteDataSource<List<Track>> remoteDataSource) {
        if (sInstance == null) {
            sInstance = new TrackRepository(remoteDataSource);
        }
        return sInstance;
    }

    @Override
    public void getTracks(String genre, OnFetchDataListener<List<Track>> onFetchDataListener) {
        mRemoteDataSource.getTracks(genre, onFetchDataListener);
    }
}
