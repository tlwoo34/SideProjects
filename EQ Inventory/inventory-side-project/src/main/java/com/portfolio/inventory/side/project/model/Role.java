package com.portfolio.inventory.side.project.model;

/**
 * A model class to represent what specific role the personnel have in the organization
 */
public class Role {
    int id;
    String name;

    public Role(){};

    public Role(int id, String name){
        this.id = id;
        this.name = name;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
