package com.localdealfinder.model;

public class PositiveMatch {
    private int id;
    private String name;

    public PositiveMatch withId(int id){
        this.id = id;
        return this;
    }

    public PositiveMatch withName(String name){
        this.name = name;
        return this;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
