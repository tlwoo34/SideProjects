package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.RolePermissions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRolePermissionsDao implements RolePermissionsDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcRolePermissionsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RolePermissions> getAll() {
        List<RolePermissions> rolePermissions = new ArrayList<>();
        String sql = "SELECT * FROM role_permissions;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            RolePermissions rolePermission = mapRowToRolePermissions(results);
            rolePermissions.add(rolePermission);
        }
        return rolePermissions;
    }

    @Override
    public List<RolePermissions> getByRoleIdAndInventoryId(int roleId, int inventoryId) {
        List<RolePermissions> rolePermissions = new ArrayList<>();
        String sql = "SELECT * FROM role_permissions WHERE role_id = ? AND inventory_id =?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, roleId, inventoryId);


        while (results.next()) {
            RolePermissions rolePermission = mapRowToRolePermissions(results);
            rolePermissions.add(rolePermission);
        }
        return rolePermissions;
    }


    @Override
    public List<RolePermissions> getByRoleId(int roleId) {
        List<RolePermissions> rolePermissions = new ArrayList<>();
        String sql = "SELECT * FROM role_permissions WHERE role_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, roleId);


        while (results.next()) {
            RolePermissions rolePermission = mapRowToRolePermissions(results);
            rolePermissions.add(rolePermission);
        }
        return rolePermissions;
    }

    @Override
    public List<RolePermissions> getByInventoryId(int inventoryId) {
        List<RolePermissions> rolePermissions = new ArrayList<>();
        String sql = "SELECT * FROM role_permissions WHERE inventory_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, inventoryId);


        while (results.next()) {
            RolePermissions rolePermission = mapRowToRolePermissions(results);
            rolePermissions.add(rolePermission);
        }
        return rolePermissions;
    }

    @Override
    public RolePermissions create(RolePermissions rolePermissions) {
        String sql = "INSERT INTO role_permissions (role_id, inventory_id) " +
                "VALUES (?, ?) ";
        jdbcTemplate.update(sql, rolePermissions.getRoleId(), rolePermissions.getInventoryId());
        return rolePermissions;
    }

    @Override
    public void delete(RolePermissions rolePermissions) {
        String sql = "DELETE FROM role_permissions WHERE role_id = ? AND inventory_id = ?;";
        jdbcTemplate.update(sql, rolePermissions.getRoleId(), rolePermissions.getInventoryId());
    }

    @Override
    public void deleteByRoleId(int roleId) {
        String sql = "DELETE FROM role_permissions WHERE role_id =?;";
        jdbcTemplate.update(sql, roleId);
    }

    @Override
    public void deleteByInventoryId(int inventoryId) {
        String sql = "DELETE FROM role_permissions WHERE inventory_id =?;";
        jdbcTemplate.update(sql, inventoryId);
    }


    private RolePermissions mapRowToRolePermissions(SqlRowSet rs) {
        RolePermissions rolePermissions = new RolePermissions();
        rolePermissions.setRoleId(rs.getInt("role_id"));
        rolePermissions.setInventoryId(rs.getInt("inventory_id"));
        return rolePermissions;
    }


}
