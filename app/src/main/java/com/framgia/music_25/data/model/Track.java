package com.framgia.music_25.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public class Track implements Parcelable {
    private int mId;
    private String mName;
    private String mArtworkUrl;
    private int mDuration;
    private boolean mDownloadable;
    private String mStreamUrl;
    private String mDownloadUrl;
    private String mOriginalFormat;
    private int mSize;

    public static final Parcelable.Creator<Track> CREATOR = new Parcelable.Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel source) {
            return new Track(source);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    protected Track(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mArtworkUrl = in.readString();
        mDuration = in.readInt();
        mStreamUrl = in.readString();
        mDownloadable = in.readByte() != 0;
        mDownloadUrl = in.readString();
        mOriginalFormat = in.readString();
        mSize = in.readInt();
    }

    public Track(JSONObject jsonObject) throws JSONException {
        mId = jsonObject.getInt(JsonParamKey.SONG_ID);
        mName = jsonObject.getString(JsonParamKey.SONG_NAME);
        mArtworkUrl = jsonObject.getString(JsonParamKey.SONG_ARTWORK_URL);
        mDuration = jsonObject.getInt(JsonParamKey.SONG_DURATION);
        mStreamUrl = jsonObject.getString(JsonParamKey.SONG_STREAM_URL);
        mDownloadable = jsonObject.getBoolean(JsonParamKey.SONG_DOWNLOADABLE);
        mDownloadUrl = jsonObject.getString(JsonParamKey.SONG_DOWNLOAD_URL);
        mOriginalFormat = jsonObject.getString(JsonParamKey.SONG_ORIGINAL_FORMAT);
        mSize = jsonObject.getInt(JsonParamKey.SONG_ORIGINAL_CONTENT_SIZE);
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    public int getDuration() {
        return mDuration;
    }

    public String getStreamUrl() {
        return mStreamUrl;
    }

    public boolean isDownloadable() {
        return mDownloadable;
    }

    public String getDownloadUrl() {
        return mDownloadUrl;
    }

    public String getOriginalFormat() {
        return mOriginalFormat;
    }

    public int getSize() {
        return mSize;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
        dest.writeString(mArtworkUrl);
        dest.writeInt(mDuration);
        dest.writeString(mStreamUrl);
        dest.writeByte(mDownloadable ? (byte) 1 : (byte) 0);
        dest.writeString(mDownloadUrl);
        dest.writeString(mOriginalFormat);
        dest.writeInt(mSize);
    }

    private class JsonParamKey {
        private static final String SONG_ID = "id";
        private static final String SONG_NAME = "title";
        private static final String SONG_ARTWORK_URL = "artwork_url";
        private static final String SONG_DURATION = "duration";
        private static final String SONG_STREAM_URL = "stream_url";
        private static final String SONG_DOWNLOADABLE = "downloadable";
        private static final String SONG_DOWNLOAD_URL = "download_url";
        private static final String SONG_ORIGINAL_FORMAT = "original_format";
        private static final String SONG_ORIGINAL_CONTENT_SIZE = "original_content_size";
    }
}
