package com.github.KatarinaAet.myfirstapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    public interface Listener{
        void onNoteClick(String id);
    }
    private Listener myListener;

    private List<Note> noteList = new ArrayList<>();
    public NoteAdapter(Listener listener){
        super();
        myListener = listener;
    }

    public void setNoteList(final List<Note> noteList) {
        this.noteList = noteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.activity_note_list, parent,
                false
        );
        return new NoteViewHolder(view, myListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final NoteViewHolder holder, final int position) {
        holder.bind(noteList.get(position));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDateFormat SDF = new SimpleDateFormat("yyyy.MM.dd",
                Locale.ENGLISH);

        private TextView noteTitleTextView;
        private TextView noteTextTextView;
        private TextView noteDateTextView;
        private ImageView noteImageView;
        private String id;

        public NoteViewHolder(final View itemView, final Listener listener) {
            super(itemView);
            myListener = listener;
            noteTextTextView = itemView.findViewById(R.id.text_small);
            noteTitleTextView = itemView.findViewById(R.id.title);
            noteTextTextView = itemView.findViewById(R.id.text_small);
            noteDateTextView = itemView.findViewById(R.id.date);
            noteImageView = itemView.findViewById(R.id.image_small);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    if (listener != null){
                        listener.onNoteClick(id);
                    }
                }
            });
        }

        public void bind(final Note note) {
            noteTitleTextView.setText(note.getTitle());
            noteTextTextView.setText(note.getText());
            noteDateTextView.setText(SDF.format(note.getDate()));
            noteImageView.setImageResource(note.getDrawableIdRes());
            id = note.getId();
        }
    }
}