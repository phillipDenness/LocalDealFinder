package legacy.shopper.factories;

import legacy.shopper.Advert;
import legacy.shopper.gumtree.GumtreeAdvert;

public class AdvertFactory {
    public static Advert getAdvert(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeAdvert();
        }else{
            return null;
        }
    }
}
