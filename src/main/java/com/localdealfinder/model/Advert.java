package com.localdealfinder.model;

import java.util.Date;

public class Advert {

    private int id;
    private String title;
    private double price;
    private String link;
    private Date timestamp;

    public Advert withId(int id) {
        this.id = id;
        return this;
    }

    public Advert withTitle(String title) {
        this.title = title;
        return this;
    }

    public Advert withPrice(double price) {
        this.price = price;
        return this;
    }

    public Advert withLink(String link) {
        this.link = link;
        return this;
    }

    public Advert withTimestamp(Date timestamp){
        this.timestamp = timestamp;
        return this;
    }

    public Date getTimestamp(){
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getLink() {
        return link;
    }
}
