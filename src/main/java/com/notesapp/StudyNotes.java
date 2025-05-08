package com.notesapp;

import java.time.LocalDateTime;

public class StudyNotes extends NoteList {

    public StudyNotes(String name) {
        super(name);
    }

    void addStudyNote(String title) {
        StudyNote st = new StudyNote(title);
        this.itemList.add(st);
        this.updatedAt = LocalDateTime.now();
    }

    void updateStudyNote(int idx, int option, String newOption) {
        if (idx < 0 || idx >= this.itemList.size()) {
            return; // Invalid index
        }

        StudyNote note = (StudyNote) this.itemList.get(idx);

        if (option == 1) {
            // Update the title
            note.setTitle(newOption);
        } else if (option == 2) {
            // Add a new bullet point
            note.addNote(newOption);
        } else if (option == 3) {
            
            String[] parts = newOption.split(":", 2);
            if (parts.length == 2) {
                try {
                    int bulletIdx = Integer.parseInt(parts[0]);
                    String newContent = parts[1];
                    note.updateNote(bulletIdx, newContent);
                } catch (NumberFormatException e) {
                    // Invalid format
                }
            }
        }

        this.updatedAt = LocalDateTime.now();
    }

    void deleteStudyNote(int idx) {
        if (idx < 0 || idx >= this.itemList.size()) {
            return; // Invalid index
        }

        this.itemList.remove(idx);
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ").append(this.getName()).append(" ===\n");
        for (int i = 0; i < this.itemList.size(); i++) {
            sb.append("\nNote ").append(i + 1).append(":\n");
            sb.append(this.itemList.get(i).toString());
        }
        return sb.toString();
    }
}
