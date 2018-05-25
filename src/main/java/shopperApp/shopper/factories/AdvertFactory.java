package shopperApp.shopper.factories;

import shopperApp.shopper.Advert;
import shopperApp.shopper.gumtree.GumtreeAdvert;

public class AdvertFactory {
    public static Advert getAdvert(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeAdvert();
        }else{
            return null;
        }
    }
}
