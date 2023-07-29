package com.portfolio.inventory.side.project.dao;

import com.portfolio.inventory.side.project.model.TeamPermissions;

import java.util.List;

public interface TeamPermissionsDao {
    List<TeamPermissions> getAll();

    List<TeamPermissions> getByTeamId(int teamId);

    List<TeamPermissions> getByInventoryId(int inventoryId);

    List<TeamPermissions> getByTeamIdAndInventoryId(int teamId, int inventoryId);

    TeamPermissions create(TeamPermissions teamPermissions);

    void delete(TeamPermissions teamPermissions);

    void deleteByTeamId(int teamId);

    void deleteByInventoryId(int inventoryId);
}
