package com.notesapp;

public class Todo extends Note {
    private String description;
    private boolean completed;

    public Todo(String title) {
        super(title);
        this.description = "";
        this.completed = false;
    }

    public String getDescription() {
        return new String(description);
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(this.getTitle());
        if (!this.description.isEmpty()) {
            sb.append("\nDescription: ").append(this.description);
        }
        sb.append("\nStatus: ").append(this.completed ? "Completed" : "Pending");
        return sb.toString();
    }
}
