package com.portfolio.inventory.side.project.service;

import com.portfolio.inventory.side.project.dao.InventoryDao;
import com.portfolio.inventory.side.project.model.Inventory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InventoryService {
    private InventoryDao inventoryDao;

    public InventoryService(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    public List<Inventory> getAll() {
        return inventoryDao.getAll();
    }

    public Inventory getById(int id) {
        return inventoryDao.getById(id);
    }

    public Inventory create(Inventory inventory) {
        return inventoryDao.create(inventory);
    }

    public Inventory update(Inventory inventory) {

        if (getById(inventory.getId()) == null) {
            return create(inventory);
        }

        inventoryDao.update(inventory);
        return inventory;
    }

    public void deleteById(int id) {
        inventoryDao.deleteById(id);
    }


}
