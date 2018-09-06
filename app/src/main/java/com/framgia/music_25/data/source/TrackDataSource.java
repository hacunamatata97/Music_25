package com.framgia.music_25.data.source;

public interface TrackDataSource {

    interface RemoteDataSource<T> extends TrackDataSource {

       void getTracks(String genre, OnFetchDataListener<T> onFetchDataListener);
    }
}
