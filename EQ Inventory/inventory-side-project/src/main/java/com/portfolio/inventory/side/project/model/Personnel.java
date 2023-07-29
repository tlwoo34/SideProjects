package com.portfolio.inventory.side.project.model;

import jakarta.validation.constraints.NotNull;

/**
 * Model class about personnel who are able to access/receive equipment.
 * <p>
 * Contains the individuals id, their name, what specific team they are associated with, and what role they have
 * on that team.
 */
public class Personnel {
    int id;
    @NotNull
    String name;
    int teamId;
    @NotNull
    int roleId;

    public Personnel() {
    }

    ;

    public Personnel(int id, String name, int teamId, int roleId) {
        this.id = id;
        this.name = name;
        this.teamId = teamId;
        this.roleId = roleId;
    }

    public Personnel(int id, String name, int roleId) {
        this.id = id;
        this.name = name;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
