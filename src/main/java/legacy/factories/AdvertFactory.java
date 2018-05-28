package legacy.factories;

import legacy.gumtree.GumtreeAdvert;
import legacy.shopper.Advert;

public class AdvertFactory {
    public static Advert getAdvert(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeAdvert();
        }else{
            return null;
        }
    }
}
