package com.portfolio.inventory.side.project.service;

import com.portfolio.inventory.side.project.dao.RoleDao;
import com.portfolio.inventory.side.project.model.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleService {
    private RoleDao roleDao;

    public RoleService(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> getAll(String name) {
        if (name != null) {
            return roleDao.getByName(name);
        }
        return roleDao.getAll();
    }

    public Role getById(int id) {
        return roleDao.getById(id);
    }
    
    public Role create(Role role) {
        return roleDao.create(role);
    }

    public Role update(Role role) {
        if (getById(role.getId()) == null) {
            return create(role);
        }
        roleDao.update(role);
        return role;
    }

    public void delete(int id) {
        roleDao.delete(id);
    }
}
