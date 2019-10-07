package com.github.KatarinaAet.myfirstapplication;

import android.app.Activity;
import android.os.Bundle;

public class Note1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note1);
        this.setTitle("Note 1");

    }
}
