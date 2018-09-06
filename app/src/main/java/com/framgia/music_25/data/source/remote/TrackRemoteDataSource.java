package com.framgia.music_25.data.source.remote;

import com.framgia.music_25.data.model.SoundCloudApi;
import com.framgia.music_25.data.model.Track;
import com.framgia.music_25.data.source.OnFetchDataListener;
import com.framgia.music_25.data.source.TrackDataSource;
import java.util.List;

public class TrackRemoteDataSource implements TrackDataSource.RemoteDataSource<List<Track>> {

    private static TrackRemoteDataSource sInstance;

    public static synchronized TrackRemoteDataSource getInstance() {
        if (sInstance == null) {
            synchronized (TrackRemoteDataSource.class) {
                sInstance = new TrackRemoteDataSource();
            }
        }
        return sInstance;
    }

    @Override
    public void getTracks(String genre, OnFetchDataListener<List<Track>> onFetchDataListener) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SoundCloudApi.BASE_URL)
                .append(SoundCloudApi.QUERY_TRACKS)
                .append(SoundCloudApi.QUERY_GENRE)
                .append(genre)
                .append(SoundCloudApi.QUERY_LIMIT)
                .append(SoundCloudApi.LIMIT)
                .append(SoundCloudApi.CLIENT_ID)
                .append(SoundCloudApi.API_KEY);
        String url = stringBuilder.toString();
        new TrackAsyncTask(onFetchDataListener).execute(url);
    }
}
