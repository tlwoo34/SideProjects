package com.portfolio.inventory.side.project.service;

import com.portfolio.inventory.side.project.dao.PersonnelDao;
import com.portfolio.inventory.side.project.model.Personnel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonnelService {
    private PersonnelDao personnelDao;

    public PersonnelService(PersonnelDao personnelDao) {
        this.personnelDao = personnelDao;
    }

    /**
     * Return all personnel filtered by arguments
     *
     * @param name a specific personnel name
     * @return a list of personnel
     */
    public List<Personnel> getAll(String name) {
        if (name != null) {
            return personnelDao.getByName(name);
        }
        return personnelDao.getAll();
    }

    public Personnel getById(int id) {
        return personnelDao.getById(id);
    }


    public Personnel create(Personnel personnel) {
        return personnelDao.create(personnel);
    }

    public Personnel update(Personnel personnel) {
        if (getById(personnel.getId()) == null) {
            return create(personnel);
        }
        personnelDao.update(personnel);
        return personnel;
    }

    public void delete(int id) {
        personnelDao.delete(id);
    }

}
