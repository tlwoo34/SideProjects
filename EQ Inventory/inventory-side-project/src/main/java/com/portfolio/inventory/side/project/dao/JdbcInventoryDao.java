package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Inventory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInventoryDao implements InventoryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcInventoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Inventory> getAll() {
        List<Inventory> inventory = new ArrayList<>();
        String sql = "SELECT * FROM inventory";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Inventory inv = mapRowToInventory(results);
            inventory.add(inv);
        }
        return inventory;
    }

    @Override
    public Inventory getById(int id) {
        String sql = "SELECT * FROM inventory WHERE id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToInventory(results);
        }
        return null;
    }

    @Override
    public Inventory create(Inventory inventory) {
        String sql = "INSERT INTO inventory (name, upc, quantity) " +
                "VALUES (?, ?, ?) " +
                " RETURNING id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, inventory.getName(), inventory.getUpc(),
                inventory.getQuantity());
        inventory.setId(id);

        return inventory;
    }

    @Override
    public void update(Inventory inventory) {
        String sql = "UPDATE inventory " +
                "SET quantity = ?, name = ?, upc = ? " +
                "WHERE id = ?;";
        jdbcTemplate.update(sql, inventory.getQuantity(), inventory.getName(), inventory.getId());
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM inventory " +
                "WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    private Inventory mapRowToInventory(SqlRowSet rs) {
        Inventory inventory = new Inventory();
        inventory.setId(rs.getInt("id"));
        inventory.setName(rs.getString("name"));
        inventory.setUpc(rs.getDouble("upc"));
        inventory.setQuantity(rs.getInt("quantity"));
        return inventory;
    }
}
