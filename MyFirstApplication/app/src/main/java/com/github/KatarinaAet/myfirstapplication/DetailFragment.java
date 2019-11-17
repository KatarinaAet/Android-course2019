package com.github.KatarinaAet.myfirstapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.github.KatarinaAet.myfirstapplication.R.id.image;
import static com.github.KatarinaAet.myfirstapplication.R.id.text;

public class DetailFragment extends Fragment {

    private static final String ID_KEY = "ID_KEY";

    private String mId;

    public DetailFragment() {}

    public static DetailFragment newInstance(String id) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ID_KEY, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mId = getArguments().getString(ID_KEY);
        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_note1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Note note = NoteRepository.getNoteById(mId);

        final TextView textView = getView().findViewById(text);
        textView.setText(note.getText());

        final ImageView imgView = getView().findViewById(image);
        imgView.setImageResource(note.getDrawableIdRes());
    }
}
