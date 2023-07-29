package com.portfolio.inventory.side.project.controller;


import com.portfolio.inventory.side.project.model.Role;
import com.portfolio.inventory.side.project.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public List<Role> getAll(@RequestParam(required = false) String name) {
        return roleService.getAll(name);
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable int id) {
        return roleService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Role create(@Valid @RequestBody Role role) {
        return roleService.create(role);
    }

    @PutMapping
    public Role update(@Valid @RequestBody Role role) {
        return roleService.update(role);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        roleService.delete(id);
    }

}
