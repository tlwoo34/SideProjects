package com.portfolio.inventory.side.project.service;

import com.portfolio.inventory.side.project.dao.TransactionsDao;
import com.portfolio.inventory.side.project.model.Transactions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionsService {
    private TransactionsDao transactionsDao;

    public TransactionsService(TransactionsDao transactionsDao) {
        this.transactionsDao = transactionsDao;
    }

    public List<Transactions> getAll() {
        return transactionsDao.getAll();
    }

    public Transactions getById(int id) {
        return transactionsDao.getById(id);
    }


    public Transactions create(Transactions transactions) {
        return transactionsDao.create(transactions);
    }

    public void delete(int id) {
        transactionsDao.deleteById(id);
    }
}
