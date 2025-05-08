package com.notesapp;

public class ToBuy extends Note {
    private int quantity;
    private boolean purchased;

    public ToBuy(String title) {
        super(title);
        this.quantity = 1;
        this.purchased = false;
    }

    public ToBuy(String title, int quantity) {
        super(title);
        this.quantity = quantity;
        this.purchased = false;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Title: ").append(this.getTitle());
        sb.append("\nQuantity: ").append(this.quantity);
        sb.append("\nStatus: ").append(this.purchased ? "Purchased" : "Not Purchased");
        return sb.toString();
    }
}
