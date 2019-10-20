package com.github.KatarinaAet.myfirstapplication;

import android.content.Context;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NoteRepository {
    private static final Map<String, Note> NOTE_LIST = new LinkedHashMap<>();
    public NoteRepository(final Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 10, 20);
        final Date date = calendar.getTime();
        int[] titlesIds;
        titlesIds = new int[]{
                R.string.peak1,
                R.string.peak2,
                R.string.peak3,
                R.string.peak4,
                R.string.peak5
        };
        int[] textsIds;
        textsIds = new int[]{
                R.string.info,
                R.string.info2,
                R.string.info3,
                R.string.info4,
                R.string.info5
        };
        int[] drawableIds;
        drawableIds = new int[]{
                R.drawable.snowy_peak1,
                R.drawable.snowy_peak2,
                R.drawable.snowy_peak3,
                R.drawable.snowy_peak4,
                R.drawable.snowy_peak5
        };

        for (int i = 0; i < 5; ++i) {
            String id = "id" + i;
            NOTE_LIST.put(id, new Note(id,
                    context.getString(titlesIds[i]),
                    context.getString(textsIds[i]),
                    date,
                    drawableIds[i]));

        }
    }

    public static List<Note> getNoteList() {
        return new ArrayList<>(NOTE_LIST.values());
    }

    public static Note getNoteById(final String id) {
        return NOTE_LIST.get(id);
    }

}