package com.localdealfinder.model;

public class NegativeMatch {
    private int id;
    private String name;

    public NegativeMatch withId(int id){
        this.id = id;
        return this;
    }

    public NegativeMatch withName(String name){
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
