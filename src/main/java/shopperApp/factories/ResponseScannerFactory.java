package shopperApp.factories;

import com.ResponseScanner;
import shopperApp.gumtree.GumtreeResponseScanner;

public class ResponseScannerFactory {

    public static ResponseScanner getResponseScanner(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeResponseScanner(criteria);
        }else{
            return null;
        }
    }

}
