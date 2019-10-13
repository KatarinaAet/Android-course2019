package com.github.KatarinaAet.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button buttonSend = findViewById(R.id.email);
        buttonSend.setOnClickListener(this);
        setTitle(getString(R.string.title_note));
        CardView cardView = findViewById(R.id.card_main);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NoteDetailActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","android-dev@yandex.ru", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Notes feedback");
        startActivity(Intent.createChooser(emailIntent, "Sending"));
    }
}
