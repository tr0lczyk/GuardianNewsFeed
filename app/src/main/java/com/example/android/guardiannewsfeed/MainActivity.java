package com.example.android.guardiannewsfeed;

import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderCallbacks<List<News>> {

    public static final String LOG = MainActivity.class.getName();

    private NewsAdapter newsAdapter;

    private TextView noInfoText;

    public static final String URL_LINK = "http://content.guardianapis.com/search?q=android&show-fields=byline&api-key=57228fac-f4ff-4f95-8096-0acf0f9ca0db";

    public static final int NEWS_LOADER_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()){
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, this);

        } else {
            View progressBar = findViewById(R.id.progress);
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this, "No internet Connection", Toast.LENGTH_SHORT).show();
        }
        ListView newsListView = findViewById(R.id.dynamicList);
        newsAdapter = new NewsAdapter(this, new ArrayList<News>());
        newsListView.setAdapter(newsAdapter);
        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News currentNews = newsAdapter.getItem(position);
                Uri newsUri = Uri.parse(currentNews.getNewsLink());
                Intent intent = new Intent(Intent.ACTION_VIEW, newsUri);
                startActivity(intent);
            }
        });
        noInfoText = findViewById(R.id.no_info);
        newsListView.setEmptyView(noInfoText);
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        Log.e(LOG, "Loader created");
        return new NewsLoader(this, URL_LINK);
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> newses) {
        View progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.GONE);
        noInfoText.setText(R.string.no_info);
        newsAdapter.clear();
        if(newses != null && !newses.isEmpty()){
            Log.e(LOG, "Loader load finished");
            newsAdapter.addAll(newses);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<News>> loader) {
        Log.e(LOG, "Loader reset");
        newsAdapter.clear();
    }
}
