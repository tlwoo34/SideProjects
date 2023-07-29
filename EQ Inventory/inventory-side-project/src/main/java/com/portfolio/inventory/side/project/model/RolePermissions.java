package com.portfolio.inventory.side.project.model;

public class RolePermissions {
    int roleId;
    int inventoryId;

    public RolePermissions() {
    }

    public RolePermissions(int roleId, int inventoryId) {
        this.roleId = roleId;
        this.inventoryId = inventoryId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
}
