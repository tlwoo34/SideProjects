package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Inventory;

import java.util.List;

public interface InventoryDao {
    List<Inventory> getAll();

    Inventory getById(int id);

    Inventory create(Inventory inventory);

    void update(Inventory inventory);

    void deleteById(int id);

}