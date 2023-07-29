package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.RolePermissions;

import java.util.List;

public interface RolePermissionsDao {
    List<RolePermissions> getAll();

    List<RolePermissions> getByRoleId(int roleId);

    List<RolePermissions> getByInventoryId(int inventoryId);

    List<RolePermissions> getByRoleIdAndInventoryId(int roleId, int inventoryId);

    RolePermissions create(RolePermissions rolePermissions);

    void delete(RolePermissions rolePermissions);

    void deleteByRoleId(int roleId);

    void deleteByInventoryId(int inventoryId);
}
