package com.github.KatarinaAet.myfirstapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.github.KatarinaAet.myfirstapplication.R.id.list;

public class ListFragment extends Fragment{

    private NoteAdapter.Listener myListener;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = getView().findViewById(list);
        final boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);
        final boolean isPhone = getResources().getBoolean(R.bool.is_phone);

        if ((isPhone && isLandscape) || (!isPhone && !isLandscape)) {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        recyclerView.setHasFixedSize(true);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 10);

        final NoteAdapter adapter = new NoteAdapter(myListener);
        recyclerView.setAdapter(adapter);
        adapter.setNoteList(NoteRepository.getNoteList());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NoteAdapter.Listener) {
            myListener = (NoteAdapter.Listener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myListener = null;
    }

}
