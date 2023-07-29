package com.portfolio.inventory.side.project.controller;


import com.portfolio.inventory.side.project.model.Transactions;
import com.portfolio.inventory.side.project.service.TransactionsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
    private TransactionsService transactionsService;

    public TransactionsController(TransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping
    public List<Transactions> getAll() {
        return transactionsService.getAll();
    }

    @GetMapping("/{id}")
    public Transactions getById(@PathVariable int id) {
        return transactionsService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transactions create(@Valid @RequestBody Transactions transactions) {
        return transactionsService.create(transactions);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        transactionsService.delete(id);
    }
}
