package com.localdealfinder.model;

import java.util.List;

public class Search {

    private int id;

    private List<PositiveMatch> positiveMatches;
    private List<NegativeMatch> negativeMatches;
    private List<Advert> adverts;

    private String name;
    private String location;
    private double maxPrice;
    private double minPrice;

    public String getName() {
        return name;
    }

    public Search withName(String name) {
        this.name = name;
        return this;
    }

    public int getId() {
        return id;
    }

    public Search withId(int id) {
        this.id = id;
        return this;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public Search withMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public Search withMinPrice(double minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public List<PositiveMatch> getPositiveMatches() {
        return positiveMatches;
    }

    public Search withPositiveMatches(List<PositiveMatch> positiveMatches) {
        this.positiveMatches = positiveMatches;
        return this;
    }

    public List<NegativeMatch> getNegativeMatches() {
        return negativeMatches;
    }

    public Search withNegativeMatches(List<NegativeMatch> negativeMatches) {
        this.negativeMatches = negativeMatches;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Search withLocation(String location) {
        this.location = location;
        return this;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public Search withAdverts(List<Advert> adverts) {
        this.adverts = adverts;
        return this;
    }
}
