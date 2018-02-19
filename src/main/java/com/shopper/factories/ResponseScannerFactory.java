package com.shopper.factories;

import com.shopper.ResponseScanner;
import com.shopper.gumtree.GumtreeResponseScanner;

public class ResponseScannerFactory {

    public static ResponseScanner getResponseScanner(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeResponseScanner(criteria);
        }else{
            return null;
        }
    }

}
