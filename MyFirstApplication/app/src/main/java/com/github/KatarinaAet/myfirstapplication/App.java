package com.github.KatarinaAet.myfirstapplication;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NoteRepository.init(this);
    }
}
