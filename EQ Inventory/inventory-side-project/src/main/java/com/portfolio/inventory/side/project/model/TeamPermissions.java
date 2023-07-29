package com.portfolio.inventory.side.project.model;

public class TeamPermissions {
    int teamId;
    int inventoryId;

    public TeamPermissions() {
    }

    public TeamPermissions(int teamId, int inventoryId) {
        this.teamId = teamId;
        this.inventoryId = inventoryId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
}
