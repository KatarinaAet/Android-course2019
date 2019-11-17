package com.github.KatarinaAet.myfirstapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class HostActivity extends AppCompatActivity implements NoteAdapter.Listener {

    private static final String NOTE_ID_KEY = "NOTE_ID_KEY";
    private static final String TAG_LIST = "TAG_LIST";
    private static final String TAG_INFO = "TAG_INFO";

    private String noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_activity);

        if (savedInstanceState == null) {
            noteId = null;
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.hostMainContainer, ListFragment.newInstance(), TAG_LIST)
                    .addToBackStack(null)
                    .commit();
        } else {
            noteId = savedInstanceState.getString(NOTE_ID_KEY, null);
        }

        updateTitle();
    }

    public void onNoteClick(final String id) {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.findFragmentByTag(TAG_INFO) != null) {
            fm.popBackStack();
        }

        fm.beginTransaction()
                .replace(R.id.hostDetailContainer, DetailFragment.newInstance(id), TAG_INFO)
                .addToBackStack(null)
                .commit();

        noteId = id;
        updateTitle();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (noteId != null) {
            outState.putString(NOTE_ID_KEY, noteId);
        }
        super.onSaveInstanceState(outState);
    }

    private void updateTitle() {
        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);
        boolean isPhone = getResources().getBoolean(R.bool.is_phone);
        if ((noteId == null) || (isLandscape && !isPhone)) {
            setTitle(R.string.title_note);
        } else {
            Note note = NoteRepository.getNoteById(noteId);
            if (note != null) {
                setTitle(note.getTitle());
            }
        }
    }
}
