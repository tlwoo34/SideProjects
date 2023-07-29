package com.portfolio.inventory.side.project.service;

import com.portfolio.inventory.side.project.dao.TeamPermissionsDao;
import com.portfolio.inventory.side.project.model.TeamPermissions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamPermissionsService {
    private TeamPermissionsDao teamPermissionsDao;

    public TeamPermissionsService(TeamPermissionsDao teamPermissionsDao) {
        this.teamPermissionsDao = teamPermissionsDao;
    }

    public List<TeamPermissions> getAll(Integer teamId, Integer inventoryId) {
        if (teamId != null && inventoryId != null) {
            return teamPermissionsDao.getByTeamIdAndInventoryId(teamId, inventoryId);
        } else if (inventoryId != null) {
            return getByInventoryId(inventoryId);
        } else if (teamId != null) {
            return getByTeamId(teamId);
        }
        return teamPermissionsDao.getAll();
    }

    public List<TeamPermissions> getByTeamId(int teamId) {
        return teamPermissionsDao.getByTeamId(teamId);
    }

    public List<TeamPermissions> getByInventoryId(int inventoryId) {
        return teamPermissionsDao.getByInventoryId(inventoryId);
    }

    public TeamPermissions create(TeamPermissions teamPermission) {
        return teamPermissionsDao.create(teamPermission);
    }

    public void delete(Integer teamId, Integer inventoryId) {
        if (teamId != null && inventoryId != null) {
            teamPermissionsDao.delete(new TeamPermissions(teamId, inventoryId));
        } else if (inventoryId != null) {
            deleteByInventoryId(inventoryId);
        } else if (teamId != null) {
            deleteByTeamId(teamId);
        } else {
            TeamPermissions teamPermissions = new TeamPermissions(teamId, inventoryId);
            teamPermissionsDao.delete(teamPermissions);
        }
    }

    public void deleteByTeamId(int teamId) {
        teamPermissionsDao.deleteByTeamId(teamId);
    }

    public void deleteByInventoryId(int inventoryId) {
        teamPermissionsDao.deleteByInventoryId(inventoryId);
    }
}
