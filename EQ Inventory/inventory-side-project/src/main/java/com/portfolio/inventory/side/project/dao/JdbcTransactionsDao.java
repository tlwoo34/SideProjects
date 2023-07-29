package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Transactions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransactionsDao implements TransactionsDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTransactionsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transactions> getAll() {
        List<Transactions> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Transactions transaction = mapRowToTransactions(results);
            transactions.add(transaction);
        }
        return transactions;
    }


    @Override
    public Transactions getById(int id) {
        String sql = "SELECT * FROM transactions WHERE id=?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToTransactions(results);
        }
        return null;
    }

    @Override
    public Transactions create(Transactions transactions) {
        String sql = "INSERT INTO transactions (personnel_id, inventory_id, quantity) " +
                "VALUES (?, ?, ?) " +
                "RETURNING id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, transactions.getPersonnelId(),
                transactions.getInventoryId(), transactions.getQuantity());

        return getById(id);
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM transactions WHERE id = ?;";
        jdbcTemplate.update(sql, id);

    }

    private Transactions mapRowToTransactions(SqlRowSet rs) {
        Transactions transactions = new Transactions();
        transactions.setId(rs.getInt("id"));
        transactions.setPersonnelId(rs.getInt("personnel_id"));
        transactions.setInventoryId(rs.getInt("inventory_id"));
        transactions.setQuantity(rs.getInt("quantity"));
        transactions.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
        return transactions;
    }
}
