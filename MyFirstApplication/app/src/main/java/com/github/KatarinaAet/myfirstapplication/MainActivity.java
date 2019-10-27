package com.github.KatarinaAet.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getString(R.string.title_note));

        final RecyclerView recyclerView = findViewById(R.id.list);
        final boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);
        if (isLandscape){
            System.out.println("yes");
            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else{
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 3);

        final NoteAdapter adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNoteList(NoteRepository.getNoteList());
    }

}
