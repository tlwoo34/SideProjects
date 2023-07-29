package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRoleDao implements RoleDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRoleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> getAll() {
        List<Role> role = new ArrayList<>();
        String sql = "SELECT * FROM role;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Role exampleRole = mapRowToRole(results);
            role.add(exampleRole);
        }
        return role;
    }

    @Override
    public Role getById(int id) {
        String sql = "SELECT * FROM role WHERE id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToRole(results);
        }
        return null;
    }

    @Override
    public List<Role> getByName(String name) {
        List<Role> role = new ArrayList<>();
        String sql = "SELECT * FROM role WHERE name ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");

        while (results.next()) {
            Role testRole = mapRowToRole(results);
            role.add(testRole);
        }
        return role;
    }

    @Override
    public Role create(Role role) {
        String sql = "INSERT INTO role (name) " +
                "VALUES (?) " +
                "RETURNING id;";

        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, role.getName());
        role.setId(id);
        return role;
    }

    @Override
    public void update(Role role) {
        String sql = "UPDATE role SET name = ? WHERE id = ?;";
        jdbcTemplate.update(sql, role.getName(), role.getId());

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM role WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    private Role mapRowToRole(SqlRowSet rs) {
        Role role = new Role();
        role.setId(rs.getInt("id"));
        role.setName(rs.getString("name"));
        return role;
    }
}
