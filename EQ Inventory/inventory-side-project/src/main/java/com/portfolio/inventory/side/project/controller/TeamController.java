package com.portfolio.inventory.side.project.controller;

import com.portfolio.inventory.side.project.model.Team;
import com.portfolio.inventory.side.project.service.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/team")
public class TeamController {
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping
    public List<Team> getAll(@RequestParam(required = false) String name) {
        return teamService.getAll(name);
    }

    @GetMapping("/{id}")
    public Team getById(@PathVariable int id) {
        return teamService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Team create(@Valid @RequestBody Team team) {
        return teamService.create(team);
    }

    @PutMapping
    public Team update(@Valid @RequestBody Team team) {
        return teamService.update(team);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        teamService.delete(id);
    }
}
