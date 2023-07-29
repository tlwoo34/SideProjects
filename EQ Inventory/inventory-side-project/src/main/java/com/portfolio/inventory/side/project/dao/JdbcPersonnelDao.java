package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Personnel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPersonnelDao implements PersonnelDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonnelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Personnel> getAll() {
        List<Personnel> personnels = new ArrayList<>();
        String sql = "SELECT * FROM personnel;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Personnel personnel = mapRowToPersonnel(results);
            personnels.add(personnel);
        }
        return personnels;
    }

    @Override
    public Personnel getById(int id) {
        String sql = "SELECT * FROM personnel WHERE id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToPersonnel(results);
        }
        return null;
    }

    @Override
    public List<Personnel> getByName(String name) {
        List<Personnel> personnels = new ArrayList<>();
        String sql = "SELECT * FROM personnel WHERE name ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
        while (results.next()) {
            Personnel personnel = mapRowToPersonnel(results);
            personnels.add(personnel);
        }
        return personnels;
    }

    @Override
    public void update(Personnel personnel) {
        String sql = "UPDATE personnel " +
                "SET name = ?, team_id = ?, role_id = ? " +
                "WHERE id = ?;";
        jdbcTemplate.update(sql, personnel.getName(), personnel.getTeamId(), personnel.getRoleId(), personnel.getId());

    }

    @Override
    public Personnel create(Personnel personnel) {
        String sql = "INSERT INTO personnel (name, team_id, role_id) " +
                "VALUES (?, ?, ?) " +
                "RETURNING id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, personnel.getName(), personnel.getTeamId(),
                personnel.getRoleId());
        personnel.setId(id);
        return personnel;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Personnel " +
                "WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    private Personnel mapRowToPersonnel(SqlRowSet rs) {
        Personnel personnel = new Personnel();
        personnel.setId(rs.getInt("id"));
        personnel.setName(rs.getString("name"));
        personnel.setTeamId(rs.getInt("team_id"));
        personnel.setRoleId(rs.getInt("role_id"));
        return personnel;
    }
}
