package com.github.KatarinaAet.myfirstapplication;

import java.util.Date;

public class Note {
    private String id;
    private String title;
    private String text;
    private Date date;
    private int drawableIdRes;

    public Note(final String id, final String title, final String text,
                final Date date, final int drawableIdRes) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.drawableIdRes = drawableIdRes;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public int getDrawableIdRes() {
        return drawableIdRes;
    }
}
