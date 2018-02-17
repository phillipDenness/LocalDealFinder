package com;

import java.net.HttpURLConnection;
import java.net.URL;

public enum Shopper {
    INSTANCE;

    private URL url;
    private HttpURLConnection connection;
    private ShoppingList shoppingList;
    private Store store;

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
}
