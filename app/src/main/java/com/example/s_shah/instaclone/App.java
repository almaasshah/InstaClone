package com.example.s_shah.instaclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("EOVbRBUKJusykxihiyM7A1fsc5LbG1m2te67yb6C")
                // if defined
                .clientKey("emcqmjy9UV9AfDfxnbCrF0fT4A32sMIg5hQCBu8T")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}