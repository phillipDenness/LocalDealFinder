package com.factories;

import com.Advert;
import com.gumtree.GumtreeAdvert;

public class AdvertFactory {
    public static Advert getAdvert(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeAdvert();
        }else{
            return null;
        }
    }
}
