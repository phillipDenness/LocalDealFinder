package shopperApp.factories;

import shopperApp.gumtree.GumtreeResponseScanner;

public class ResponseScannerFactory {

    public static GumtreeResponseScanner getResponseScanner(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeResponseScanner(criteria);
        }else{
            return null;
        }
    }

}
