package com.framgia.music_25.data.source.remote;

import com.framgia.music_25.data.model.Track;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class DataParser {

    private static final String REQUEST_TYPE = "GET";
    private static final int READ_TIMEOUT = 20000;
    private static final int CONNECT_TIMEOUT = 10000;
    private static final String NEXT_LINE = "\n";

    public static String getJsonFromUrl(String path) throws IOException {
        URL url = new URL(path);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(REQUEST_TYPE);
        urlConnection.setReadTimeout(READ_TIMEOUT);
        urlConnection.setConnectTimeout(CONNECT_TIMEOUT);
        urlConnection.connect();
        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append(NEXT_LINE);
        }
        bufferedReader.close();
        inputStreamReader.close();
        urlConnection.disconnect();
        return stringBuilder.toString();
    }

    public static List<Track> parseJson(String json) throws JSONException {
        List<Track> trackList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            Track track = new Track(jsonArray.getJSONObject(i));
            trackList.add(track);
        }
        return trackList;
    }
}
