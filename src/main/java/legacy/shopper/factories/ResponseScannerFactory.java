package legacy.shopper.factories;

import legacy.shopper.ResponseScanner;
import legacy.shopper.gumtree.GumtreeResponseScanner;

public class ResponseScannerFactory {

    public static ResponseScanner getResponseScanner(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeResponseScanner(criteria);
        }else{
            return null;
        }
    }

}
