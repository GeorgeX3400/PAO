package com.notesapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class NoteList {
    protected String name;
    protected List<Note> itemList;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

    public NoteList(String name) {
        this.name = name;
        this.itemList = new ArrayList<>();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getName() {
        return new String(name);
    }

    public void setName(String newName) {
        this.name = newName;
        this.updatedAt = LocalDateTime.now();
    }

}
