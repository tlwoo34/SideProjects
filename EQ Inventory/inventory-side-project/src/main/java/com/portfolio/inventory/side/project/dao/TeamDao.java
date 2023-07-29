package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.Team;

import java.util.List;

public interface TeamDao {
    List<Team> getAll();

    Team getById(int id);

    List<Team> getByName(String name);

    Team create(Team team);

    void update(Team team);

    void delete(int id);


}
