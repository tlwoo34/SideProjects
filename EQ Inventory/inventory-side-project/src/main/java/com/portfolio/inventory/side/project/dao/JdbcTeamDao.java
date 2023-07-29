package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Team;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTeamDao implements TeamDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTeamDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Team> getAll() {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Team team = mapRowToTeam(results);
            teams.add(team);
        }
        return teams;
    }

    @Override
    public Team getById(int id) {
        String sql = "SELECT * FROM team WHERE id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        if (results.next()) {
            return mapRowToTeam(results);
        }
        return null;
    }

    @Override
    public List<Team> getByName(String name) {
        List<Team> teams = new ArrayList<>();
        String sql = "SELECT * FROM team WHERE name ILIKE ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");

        while (results.next()) {
            Team team = mapRowToTeam(results);
            teams.add(team);
        }
        return teams;
    }

    @Override
    public Team create(Team team) {
        String sql = "INSERT INTO team (name) " +
                "VALUES (?) " +
                "RETURNING id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, team.getName());
        team.setId(id);
        return team;
    }

    @Override
    public void update(Team team) {
        String sql = "UPDATE team SET name = ? WHERE id = ?;";
        jdbcTemplate.update(sql, team.getName(), team.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM team WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    private Team mapRowToTeam(SqlRowSet rs) {
        Team team = new Team();
        team.setId(rs.getInt("id"));
        team.setName(rs.getString("name"));
        return team;
    }
}
