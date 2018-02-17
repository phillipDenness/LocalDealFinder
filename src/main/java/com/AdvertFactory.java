package com;

public class AdvertFactory {
    public static Advert getAdvert(String criteria) {
        if (criteria.equals("gumtree")) {

            return new GumtreeAdvert();
        }else{
            return null;
        }
    }
}
