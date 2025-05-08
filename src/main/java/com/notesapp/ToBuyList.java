package com.notesapp;

import java.time.LocalDateTime;


public class ToBuyList extends NoteList {

    public ToBuyList(String name) {
        super(name);
    }

    public void addToBuy(String title) {
        ToBuy item = new ToBuy(title);
        this.itemList.add(item);
        this.updatedAt = LocalDateTime.now();
    }

    public void addToBuy(String title, int quantity) {
        ToBuy item = new ToBuy(title, quantity);
        this.itemList.add(item);
        this.updatedAt = LocalDateTime.now();
    }

    public void updateToBuyDetails(int idx, int option, String newValue) {
        if (idx < 0 || idx >= this.itemList.size()) {
            return; // Invalid index
        }

        ToBuy item = (ToBuy) this.itemList.get(idx);

        if (option == 1) {
            // Update the title
            item.setTitle(newValue);
        }

        this.updatedAt = LocalDateTime.now();
    }

    public void updateToBuyQuantity(int idx, int newQuantity) {
        if (idx < 0 || idx >= this.itemList.size()) {
            return; // Invalid index
        }

        ToBuy item = (ToBuy) this.itemList.get(idx);
        item.setQuantity(newQuantity);
        this.updatedAt = LocalDateTime.now();
    }

    public void toggleToBuyStatus(int idx) {
        if (idx < 0 || idx >= this.itemList.size()) {
            return; // Invalid index
        }

        ToBuy item = (ToBuy) this.itemList.get(idx);
        item.setPurchased(!item.isPurchased());
        this.updatedAt = LocalDateTime.now();
    }

    public void deleteToBuy(int idx) {
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
            sb.append("\nItem ").append(i + 1).append(":\n");
            sb.append(this.itemList.get(i).toString());
        }
        return sb.toString();
    }
}
