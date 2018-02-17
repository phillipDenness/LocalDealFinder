package com;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ResponseScannerFactory {

    public static ResponseScanner getResponseScanner(String criteria) {
        if (criteria.equals("Gumtree")) {

            return new GumtreeResponseScanner(criteria);
        }else{
            return null;
        }
    }

}
