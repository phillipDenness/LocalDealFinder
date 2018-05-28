package com.localdealfinder.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String alias;

    private List<Advert> adverts = new ArrayList<>();

    private List<PositiveMatch> positiveMatches = new ArrayList<>();

    public User withPositiveMatch(PositiveMatch positiveMatch){
        positiveMatches.add(positiveMatch);
        return this;
    }

    public User withAdvert(Advert advert){
        adverts.add(advert);
        return this;
    }

    public User withAdverts(List<Advert> adverts){
        this.adverts = adverts;
        return this;
    }

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

    public List<Advert> getAdverts(){
        return adverts;
    }

    public List<PositiveMatch> getPositiveMatches(){
        return positiveMatches;
    }
}
