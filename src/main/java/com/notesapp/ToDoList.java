package com.notesapp;

import java.time.LocalDateTime;

public class ToDoList extends NoteList {
    public ToDoList(String name) {
        super(name);
    }

    public void addToDo(String title) {
        Todo todo = new Todo(title);
        this.itemList.add(todo);
        this.updatedAt = LocalDateTime.now();
    }

    public void updateToDo(int idx, int option, String newValue) {
        if (idx < 0 || idx >= this.itemList.size()) {
            return; // Invalid index
        }

        Todo todo = (Todo) this.itemList.get(idx);

        if (option == 1) {
            // Update the title
            todo.setTitle(newValue);
        } else if (option == 2) {
            // Update the description
            todo.setDescription(newValue);
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void toggleToDoStatus(int idx) {
        if (idx < 0 || idx >= this.itemList.size()) {
            return; // Invalid index
        }

        Todo todo = (Todo) this.itemList.get(idx);
        todo.setCompleted(!todo.isCompleted());
        this.updatedAt = LocalDateTime.now();
    }

    public void deleteToDo(int idx) {
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
            sb.append("\nTodo ").append(i + 1).append(":\n");
            sb.append(this.itemList.get(i).toString());
        }
        return sb.toString();
    }
}
