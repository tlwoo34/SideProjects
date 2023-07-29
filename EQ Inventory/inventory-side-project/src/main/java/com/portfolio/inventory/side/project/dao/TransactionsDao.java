package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Transactions;

import java.util.List;

public interface TransactionsDao {
    List<Transactions> getAll();

    Transactions getById(int id);

    Transactions create(Transactions transactions);

    void deleteById(int id);
}
