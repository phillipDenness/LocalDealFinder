package com.localdealfinder.model;

public class User {
    private int id;
    private String alias;

    public User withId(int id){
        this.id = id;
        return this;
    }

    public User withAlias(String alias){
        this.alias = alias;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getAlias() {
        return alias;
    }
}
