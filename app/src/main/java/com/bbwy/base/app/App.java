package com.bbwy.base.app;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;


import io.objectbox.BoxStore;

public class App extends Application {
    public static SQLiteDatabase database;
    private static BoxStore mBoxStore;
    private static  App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MultiDex.install(this);
    }
    public static App getInstance(){
        return instance;
    }
}
