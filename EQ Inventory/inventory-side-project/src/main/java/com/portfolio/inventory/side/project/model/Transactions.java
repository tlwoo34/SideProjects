package com.portfolio.inventory.side.project.model;

import java.time.LocalDateTime;

public class Transactions {
    int id;
    int personnelId;
    int inventoryId;
    int quantity;
    LocalDateTime timestamp;

    public Transactions() {
    }

    public Transactions(int id, int personnelId, int inventoryId, int quantity, LocalDateTime timestamp) {
        this.id = id;
        this.personnelId = personnelId;
        this.inventoryId = inventoryId;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(int personnelId) {
        this.personnelId = personnelId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
