package com.framgia.music_25.data.source.remote;

import android.os.AsyncTask;
import com.framgia.music_25.data.model.Track;
import com.framgia.music_25.data.source.OnFetchDataListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class TrackAsyncTask extends AsyncTask<String, Void, List<Track>> {

    private OnFetchDataListener<List<Track>> mOnFetchDataListener;
    private Exception mException;

    public TrackAsyncTask(OnFetchDataListener<List<Track>> onFetchDataListener) {
        mOnFetchDataListener = onFetchDataListener;
    }

    @Override
    protected List<Track> doInBackground(String... urls) {
        List<Track> tracks = new ArrayList<>();
        try {
            String json = DataParser.getJsonFromUrl(urls[0]);
            tracks = DataParser.parseJson(json);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tracks;
    }

    @Override
    protected void onPostExecute(List<Track> tracks) {
        super.onPostExecute(tracks);
        if (mOnFetchDataListener != null) {
            if (mException == null) {
                mOnFetchDataListener.onSuccess(tracks);
            } else {
                mOnFetchDataListener.onError(mException);
            }
        }
    }
}
