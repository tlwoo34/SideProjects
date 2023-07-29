package com.portfolio.inventory.side.project.service;

import com.portfolio.inventory.side.project.dao.TeamDao;
import com.portfolio.inventory.side.project.model.Team;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamService {
    private TeamDao teamDao;

    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public List<Team> getAll(String name) {
        if (name != null) {
            return teamDao.getByName(name);
        }
        return teamDao.getAll();
    }

    public Team getById(int id) {
        return teamDao.getById(id);
    }

    public Team create(Team team) {
        return teamDao.create(team);
    }

    public Team update(Team team) {
        if (getById(team.getId()) == null) {
            return create(team);
        }
        teamDao.update(team);
        return team;
    }

    public void delete(int id) {
        teamDao.delete(id);
    }
}
