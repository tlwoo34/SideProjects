package com.portfolio.inventory.side.project.controller;


import com.portfolio.inventory.side.project.model.TeamPermissions;
import com.portfolio.inventory.side.project.service.TeamPermissionsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamPermissions")
public class TeamPermissionsController {
    private TeamPermissionsService teamPermissionsService;

    public TeamPermissionsController(TeamPermissionsService teamPermissionsService) {
        this.teamPermissionsService = teamPermissionsService;
    }

    @GetMapping
    public List<TeamPermissions> getAll(@RequestParam(required = false) Integer teamId, @RequestParam(required = false) Integer inventoryId) {
        return teamPermissionsService.getAll(teamId, inventoryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamPermissions create(@RequestBody TeamPermissions teamPermissions) {
        return teamPermissionsService.create(teamPermissions);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam(required = false) Integer teamId, @RequestParam(required = false) Integer inventoryId) {
        teamPermissionsService.delete(teamId, inventoryId);
    }

}
