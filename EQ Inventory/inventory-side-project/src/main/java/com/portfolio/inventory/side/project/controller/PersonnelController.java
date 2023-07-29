package com.portfolio.inventory.side.project.controller;

import com.portfolio.inventory.side.project.model.Personnel;
import com.portfolio.inventory.side.project.service.PersonnelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    private PersonnelService personnelService;

    public PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @GetMapping
    public List<Personnel> getAll(@RequestParam(required = false) String name) {
        return personnelService.getAll(name);
    }

    @GetMapping("/{id}")
    public Personnel getById(@PathVariable int id) {
        return personnelService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personnel create(@Valid @RequestBody Personnel personnel) {
        return personnelService.create(personnel);
    }

    @PutMapping
    public Personnel update(@Valid @RequestBody Personnel personnel) {
        return personnelService.update(personnel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        personnelService.delete(id);
    }
}
