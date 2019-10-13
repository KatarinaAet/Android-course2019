package com.github.KatarinaAet.myfirstapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class NoteDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note1);
        this.setTitle(getString(R.string.note_detail_title));

    }
}
