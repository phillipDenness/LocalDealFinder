package com;

public interface Advert {
    void setName(String name);
    void setPrice(Double price);
    void setShortDescription(String shortDescription);
    void setLink(String link);

    String getName();
    Double getPrice();
    String getShortDescription();
    String getLink();
}
