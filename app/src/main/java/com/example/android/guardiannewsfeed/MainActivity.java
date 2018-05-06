package com.example.android.guardiannewsfeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static final String LOG = MainActivity.class.getName();

    public static final String URL_LINK = "http://content.guardianapis.com/search?q=harry%20potter&api-key=57228fac-f4ff-4f95-8096-0acf0f9ca0db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
