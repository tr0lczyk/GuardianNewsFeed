package com.example.android.guardiannewsfeed;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private static final String LOG_TAG = NewsLoader.class.getName();

    private String linkUrl;

    public NewsLoader(Context context,String linkUrl) {
        super(context);
        this.linkUrl = linkUrl;
    }

    @Override
    protected void onStartLoading() {
        Log.e(LOG_TAG, "Loader started");
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        Log.e(LOG_TAG, "Loader inBackground");
        if(linkUrl == null){
            return null;
        }
        Log.e(LOG_TAG, "Loader fetching");
        List<News> newses = Networking.fetchNewsData(linkUrl);
        return newses;
    }
}
