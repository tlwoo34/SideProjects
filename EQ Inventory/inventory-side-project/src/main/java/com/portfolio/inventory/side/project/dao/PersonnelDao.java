package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Personnel;

import java.util.List;

public interface PersonnelDao {
    List<Personnel> getAll();

    Personnel getById(int id);

    List<Personnel> getByName(String name);

    void update(Personnel personnel);

    Personnel create(Personnel personnel);

    void delete(int id);


}
