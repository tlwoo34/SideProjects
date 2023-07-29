package com.portfolio.inventory.side.project.controller;

import com.portfolio.inventory.side.project.model.Inventory;
import com.portfolio.inventory.side.project.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<Inventory> getAll() {
        return inventoryService.getAll();
    }

    @GetMapping("/{id}")
    public Inventory getById(@PathVariable int id) {
        return inventoryService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory create(@Valid @RequestBody Inventory inventory) {
        return inventoryService.create(inventory);
    }

    @PutMapping
    public Inventory update(@Valid @RequestBody Inventory inventory) {
        return inventoryService.update(inventory);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id) {
        inventoryService.deleteById(id);
    }

}
