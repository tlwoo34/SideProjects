package com.portfolio.inventory.side.project.service;

import com.portfolio.inventory.side.project.dao.RolePermissionsDao;
import com.portfolio.inventory.side.project.model.RolePermissions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolePermissionsService {
    private RolePermissionsDao rolePermissionsDao;

    public RolePermissionsService(RolePermissionsDao rolePermissionsDao) {
        this.rolePermissionsDao = rolePermissionsDao;
    }

    public List<RolePermissions> getAll(Integer roleId, Integer inventoryId) {
        if (roleId != null && inventoryId != null) {
            return rolePermissionsDao.getByRoleIdAndInventoryId(roleId, inventoryId);
        } else if (roleId != null) {
            return getByRoleId(roleId);
        } else if (inventoryId != null) {
            return getByInventoryId(inventoryId);
        }
        return rolePermissionsDao.getAll();
    }

    public List<RolePermissions> getByRoleId(int roleId) {
        return rolePermissionsDao.getByRoleId(roleId);
    }

    public List<RolePermissions> getByInventoryId(int inventoryId) {
        return rolePermissionsDao.getByInventoryId(inventoryId);
    }

    public RolePermissions create(RolePermissions rolePermissions) {
        return rolePermissionsDao.create(rolePermissions);
    }

    public void delete(Integer roleId, Integer inventoryId) {
        if (roleId != null && inventoryId != null) {
            rolePermissionsDao.delete(new RolePermissions(roleId, inventoryId));
        } else if (inventoryId != null) {
            deleteByInventoryId(inventoryId);
        } else if (roleId != null) {
            deleteByRoleId(roleId);
        } else {
            RolePermissions rolePermissions = new RolePermissions(roleId, inventoryId);
            rolePermissionsDao.delete(rolePermissions);
        }
    }

    public void deleteByRoleId(int roleId) {
        rolePermissionsDao.deleteByRoleId(roleId);
    }

    public void deleteByInventoryId(int inventoryId) {
        rolePermissionsDao.deleteByInventoryId(inventoryId);
    }
}
