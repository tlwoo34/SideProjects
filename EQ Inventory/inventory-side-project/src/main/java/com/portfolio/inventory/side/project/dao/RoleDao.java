package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAll();

    Role getById(int id);

    List<Role> getByName(String name);

    Role create(Role role);

    void update(Role role);

    void delete(int id);
}
