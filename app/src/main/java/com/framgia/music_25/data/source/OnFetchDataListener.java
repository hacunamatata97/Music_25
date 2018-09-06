package com.framgia.music_25.data.source;

public interface OnFetchDataListener<T> {

    void onSuccess(T data);

    void onError(Exception e);
}
