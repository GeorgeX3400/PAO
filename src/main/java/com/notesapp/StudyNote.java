package com.notesapp;

import java.util.ArrayList;
import java.util.List;

public class StudyNote extends Note {
    List<String> bulletPoints;

    public StudyNote(String title) {
        super(title);
        this.bulletPoints = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(this.getTitle()).append("\n");
        for (int i = 0; i < bulletPoints.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(bulletPoints.get(i)).append("\n");
        }
        return sb.toString();
    }

    public void addNote(String bulletPoint) {
        this.bulletPoints.add(bulletPoint);
    }

    public void deleteNote(int idx) {
        this.bulletPoints.remove(idx);
    }

    public void updateNote(int idx, String newBulletPoint) {
        this.bulletPoints.set(idx, newBulletPoint);
    }
}
