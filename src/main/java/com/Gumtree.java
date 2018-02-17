package com;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Gumtree implements Store{
    private String urlString;
    private ArrayList<String> urlParams;
    private String baseUrl = "https://www.gumtree.com/search?";

    public String getUrl() {
        return this.urlString;
    }

    private String buildUrl(){
        //search_category=video-cards-sound-cards&search_location=london&q=&min_price=&max_price=300
        this.urlString = this.baseUrl;

        for (String urlParam : urlParams) {
            this.urlString += "&";
            this.urlString += urlParam;
        }
        return urlString;
    }

    public void setUrl(ShoppingList shoppingList) {
        this.urlParams = new ArrayList<>();

        try {
            this.urlParams.add("search_location=" + URLEncoder.encode(shoppingList.location, "UTF-8"));
            this.urlParams.add("search_category=" + URLEncoder.encode(shoppingList.category, "UTF-8"));
            this.urlParams.add("min_price=" + URLEncoder.encode(Integer.toString(shoppingList.minPrice), "UTF-8"));
            this.urlParams.add("max_price=" + URLEncoder.encode(Integer.toString(shoppingList.maxPrice), "UTF-8"));

            this.urlString = buildUrl();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
