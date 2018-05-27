package legacy.factories;

import legacy.gumtree.GumtreeResponseScanner;

public class ResponseScannerFactory {

    public static GumtreeResponseScanner getResponseScanner(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeResponseScanner(criteria);
        }else{
            return null;
        }
    }

}
