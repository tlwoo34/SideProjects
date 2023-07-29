package com.portfolio.inventory.side.project.controller;

import com.portfolio.inventory.side.project.model.RolePermissions;
import com.portfolio.inventory.side.project.service.RolePermissionsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rolePermissions")
public class RolePermissionsController {

    private RolePermissionsService rolePermissionsService;

    public RolePermissionsController(RolePermissionsService rolePermissionsService) {
        this.rolePermissionsService = rolePermissionsService;
    }

    @GetMapping
    public List<RolePermissions> getAll(@RequestParam(required = false) Integer roleId, @RequestParam(required = false) Integer inventoryId) {
        return rolePermissionsService.getAll(roleId, inventoryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RolePermissions create(@RequestBody RolePermissions rolePermissions) {
        return rolePermissionsService.create(rolePermissions);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam(required = false) Integer roleId, @RequestParam(required = false) Integer inventoryId) {
        rolePermissionsService.delete(roleId, inventoryId);
    }
}
