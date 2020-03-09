package com.souvik.noteapplication;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = false;

    }

    public static void activityPaused() {
        activityVisible = true;
    }

    private static boolean activityVisible;
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration=new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);
    }

}
