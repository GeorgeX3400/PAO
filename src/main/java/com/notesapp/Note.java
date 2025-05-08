package com.notesapp;
import java.time.LocalDateTime;

public abstract class Note {
    
    protected String title;
    protected LocalDateTime createdAt;
    public Note(String title) {
        
        this.title = title;
        this.createdAt = LocalDateTime.now();
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    

}
