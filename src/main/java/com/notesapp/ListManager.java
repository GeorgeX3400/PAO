package com.notesapp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListManager {
    private List<NoteList> lists;

    public ListManager() {
        this.lists = new ArrayList<>();
    }

    
    public void addList(NoteList list) {
        this.lists.add(list);
        sortLists();
    }

    public boolean removeList(int index) {
        if (index < 0 || index >= this.lists.size()) {
            return false;
        }

        this.lists.remove(index);
        return true;
    }

    
    public NoteList getList(int index) {
        if (index < 0 || index >= this.lists.size()) {
            return null;
        }

        return this.lists.get(index);
    }

    
    public List<NoteList> getAllLists() {
        return new ArrayList<>(this.lists);
    }

    
    public int getListCount() {
        return this.lists.size();
    }

    
    private void sortLists() {
        this.lists.sort(new Comparator<NoteList>() {
            @Override
            public int compare(NoteList list1, NoteList list2) {
                // Compare in descending order (newest first)
                return list2.updatedAt.compareTo(list1.updatedAt);
            }
        });
    }

    
    public StudyNotes createStudyNotes(String name) {
        StudyNotes list = new StudyNotes(name);
        addList(list);
        return list;
    }

    
    public ToDoList createToDoList(String name) {
        ToDoList list = new ToDoList(name);
        addList(list);
        return list;
    }

    
    public ToBuyList createToBuyList(String name) {
        ToBuyList list = new ToBuyList(name);
        addList(list);
        return list;
    }

    
    public boolean updateListName(int index, String newName) {
        NoteList list = getList(index);
        if (list == null) {
            return false;
        }

        list.setName(newName);
        sortLists();
        return true;
    }

    @Override
    public String toString() {
        if (this.lists.isEmpty()) {
            return "No lists available";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(" Lists:\n");

        for (int i = 0; i < this.lists.size(); i++) {
            NoteList list = this.lists.get(i);
            sb.append("List ").append(i + 1).append(": ").append(list.getName())
                    .append(" (Last updated: ").append(list.updatedAt).append(")\n");
        }

        return sb.toString();
    }
}
