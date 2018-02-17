package com;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class Gumtree implements Store{
    private String urlString;
    private ArrayList<String> urlParams;
    private String baseUrl = "https://www.gumtree.com/search?";
    private String charset = "UTF-8";
    private String storeType;
    private String pricePattern = "<meta content=\"(.*?)\" itemprop=\"price\"";
    private String linkPattern = "listing-link\" href=\"(.*?)\" itemprop=\"url";
    private String titlePattern = "<meta content=(.*?) itemprop=\"name\"";

    public Gumtree(String storeType){
        this.storeType = storeType;
    }
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

            this.urlParams.add("search_location=" + URLEncoder.encode(shoppingList.location, charset));
            this.urlParams.add("search_category=" + URLEncoder.encode(shoppingList.category, charset));
            this.urlParams.add("min_price=" + URLEncoder.encode(Integer.toString(shoppingList.minPrice), charset));
            this.urlParams.add("max_price=" + URLEncoder.encode(Integer.toString(shoppingList.maxPrice), charset));

            this.urlString = buildUrl();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getPricePattern() {
        return pricePattern;
    }

    public String getLinkPattern() {
        return linkPattern;
    }

    public String getTitlePattern() {
        return titlePattern;
    }

    @Override
    public String getStoreType() {
        return storeType;
    }
}
