package shopperApp.factories;

import com.Advert;
import shopperApp.gumtree.GumtreeAdvert;

public class AdvertFactory {
    public static Advert getAdvert(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeAdvert();
        }else{
            return null;
        }
    }
}
