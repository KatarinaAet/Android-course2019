package com.github.KatarinaAet.myfirstapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NoteDetailActivity extends AppCompatActivity {
    private static final String ID_KEY = "ID_KEY";

    public static Intent getIntent(final Context context, final String id) {
        final Intent intent = new Intent(context, NoteDetailActivity.class);
        intent.putExtra(ID_KEY, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note1);

        final String id = getIntent().getStringExtra(ID_KEY);
        final Note note = NoteRepository.getNoteById(id);

        setTitle(note.getTitle());

        final TextView textView = findViewById(R.id.text);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(note.getText());

        final ImageView imgView = findViewById(R.id.image);
        imgView.setImageResource(note.getDrawableIdRes());
    }
}
