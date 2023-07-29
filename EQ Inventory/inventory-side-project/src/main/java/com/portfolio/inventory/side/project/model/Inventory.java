package com.portfolio.inventory.side.project.model;

import jakarta.validation.constraints.NotNull;

/**
 * Model class representing equipment inventory.
 * <p>
 * Contains information about the equipment in inventory - Id, name of the equipment, the upc #, and the amount in
 * inventory.
 */
public class Inventory {
    int id;
    @NotNull
    String name;
    @NotNull
    double upc;
    int quantity;

    public Inventory() {
    }

    public Inventory(int id, String name, double upc, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUpc() {
        return upc;
    }

    public void setUpc(double upc) {
        this.upc = upc;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "inventory {" +
                "id=" + id +
                ", name'" + name + '\'' +
                ", upc'" + upc + '\'' +
                ", quantity'" + quantity + '\'' +
                '}';
    }
}
