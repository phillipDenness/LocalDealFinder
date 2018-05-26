package shopperApp.factories;

import shopperApp.gumtree.GumtreeAdvert;
import shopperApp.shopper.Advert;

public class AdvertFactory {
    public static Advert getAdvert(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeAdvert();
        }else{
            return null;
        }
    }
}
