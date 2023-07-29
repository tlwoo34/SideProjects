package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.TeamPermissions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTeamPermissionsDao implements TeamPermissionsDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTeamPermissionsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<TeamPermissions> getAll() {
        List<TeamPermissions> teamPermissions = new ArrayList<>();
        String sql = "SELECT * FROM team_permissions;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            TeamPermissions teamPermission = mapRowToTeamPermissions(results);
            teamPermissions.add(teamPermission);
        }
        return teamPermissions;
    }

    @Override
    public List<TeamPermissions> getByTeamIdAndInventoryId(int teamId, int inventoryId) {
        List<TeamPermissions> teamPermissions = new ArrayList<>();
        String sql = "SELECT * FROM team_permissions WHERE team_id = ? AND inventory_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamId, inventoryId);

        while (results.next()) {
            TeamPermissions teamPermission = mapRowToTeamPermissions(results);
            teamPermissions.add(teamPermission);
        }
        return teamPermissions;
    }

    @Override
    public List<TeamPermissions> getByTeamId(int teamId) {
        List<TeamPermissions> teamPermissions = new ArrayList<>();
        String sql = "SELECT * FROM team_permissions WHERE team_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, teamId);

        while (results.next()) {
            TeamPermissions teamPermission = mapRowToTeamPermissions(results);
            teamPermissions.add(teamPermission);
        }
        return teamPermissions;
    }

    @Override
    public List<TeamPermissions> getByInventoryId(int inventoryId) {
        List<TeamPermissions> teamPermissions = new ArrayList<>();
        String sql = "SELECT * FROM team_permissions WHERE inventory_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, inventoryId);

        while (results.next()) {
            TeamPermissions teamPermission = mapRowToTeamPermissions(results);
            teamPermissions.add(teamPermission);
        }
        return teamPermissions;
    }

    @Override
    public TeamPermissions create(TeamPermissions teamPermissions) {
        String sql = "INSERT INTO team_permissions (team_id, inventory_id) " +
                "VALUES (?, ?) ";
        jdbcTemplate.update(sql, teamPermissions.getTeamId(), teamPermissions.getInventoryId());
        return teamPermissions;
    }

    @Override
    public void delete(TeamPermissions teamPermissions) {
        String sql = "DELETE FROM team_permissions WHERE team_id = ? AND inventory_id = ?;";
        jdbcTemplate.update(sql, teamPermissions.getTeamId(), teamPermissions.getInventoryId());
    }

    @Override
    public void deleteByTeamId(int teamId) {
        String sql = "DELETE FROM team_permissions WHERE team_id =?;";
        jdbcTemplate.update(sql, teamId);
    }

    @Override
    public void deleteByInventoryId(int inventoryId) {
        String sql = "DELETE FROM team_permissions WHERE inventory_id =?;";
        jdbcTemplate.update(sql, inventoryId);
    }

    private TeamPermissions mapRowToTeamPermissions(SqlRowSet rs) {
        TeamPermissions teamPermissions = new TeamPermissions();
        teamPermissions.setTeamId(rs.getInt("team_id"));
        teamPermissions.setInventoryId(rs.getInt("inventory_id"));
        return teamPermissions;
    }

}
