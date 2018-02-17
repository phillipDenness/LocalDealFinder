package com;

import org.jsoup.nodes.Document;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public enum Shopper {
    INSTANCE;

    private URL url;
    private HttpURLConnection connection;
    private ShoppingList shoppingList;
    private Store store;

    public Browser getBrowser() {
        return Browser.INSTANCE;
    }

    public void setStore(Store store){
        this.store = store;
    }

    public void setShoppingList(ShoppingList shoppingList){
        this.shoppingList = shoppingList;
    }

    public void visitStore(String urlString){

        String location = this.shoppingList.location;
        try {
            this.url = new URL(urlString);
            this.connection.setFollowRedirects(false);
            this.connection = (HttpURLConnection) url.openConnection();
            this.connection.setRequestMethod("GET");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Store getStore() {
        return store;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void reviewAdverts(ArrayList<Advert> adverts) {
        for(Advert advert : adverts) {
            Boolean save = checkShortDescription(advert);
            if (save) {
                Document doc = getBrowser().openPage(advert.getLink());

            }
        }
    }


    private Boolean checkShortDescription(Advert advert) {
        int requirements = shoppingList.requirements.size();
        int requirementsMet = 0;

        for (String requirement : shoppingList.requirements) {
            if (requirement.toLowerCase().contains(advert.getShortDescription().toLowerCase())){
                requirementsMet++;
            }
        }

        if (requirementsMet >= requirements) {
            return true;
        }else{
            return false;
        }
    }
}
