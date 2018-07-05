package com.example.eduard.roomtest;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {
    private static MyApp app;
    private static AppDatabase appDb;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        app = this;
    }

    public static Context getAppContext() {
        return app.getApplicationContext();
    }

    public static synchronized AppDatabase getDb() {
        if (appDb == null) {
            appDb = AppDatabase.Companion.create();
        }
        return appDb;
    }
}
