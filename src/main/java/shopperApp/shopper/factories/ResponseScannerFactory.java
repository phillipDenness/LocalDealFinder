package shopperApp.shopper.factories;

import shopperApp.shopper.ResponseScanner;
import shopperApp.shopper.gumtree.GumtreeResponseScanner;

public class ResponseScannerFactory {

    public static ResponseScanner getResponseScanner(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeResponseScanner(criteria);
        }else{
            return null;
        }
    }

}
