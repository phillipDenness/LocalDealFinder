package com;

public class GumtreeAdvert implements Advert {
    private String name;
    private Double price;
    private String shortDescription;
    private String link;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }
}
