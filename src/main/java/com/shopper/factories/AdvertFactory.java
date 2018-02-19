package com.shopper.factories;

import com.shopper.Advert;
import com.shopper.gumtree.GumtreeAdvert;

public class AdvertFactory {
    public static Advert getAdvert(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeAdvert();
        }else{
            return null;
        }
    }
}
