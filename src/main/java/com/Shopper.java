package com;

import org.jsoup.nodes.Document;
import java.util.ArrayList;

public enum Shopper {
    INSTANCE;

    private ShoppingList shoppingList;
    private Store store;
    private ResponseScanner responseScanner;
    private ArrayList<Advert> favouriteAdverts;

    public void setResponseScanner(ResponseScanner responseScanner) {
        this.responseScanner = responseScanner;
    }

    public Browser getBrowser() {
        return Browser.INSTANCE;
    }

    public void setStore(Store store){
        this.store = store;
    }

    public void setShoppingList(ShoppingList shoppingList){
        this.shoppingList = shoppingList;
    }

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public ArrayList<Advert> getFavouriteAdverts() {
        return favouriteAdverts;
    }

    public void reviewAdverts(ArrayList<Advert> adverts) {
        favouriteAdverts = new ArrayList<>(1);

        for(Advert advert : adverts) {

            Boolean passDescription = reviewString(advert.getShortDescription());
            Boolean passName = reviewString(advert.getName());

            if (passDescription && passName) {
                Document doc = advert.viewAdvert();
                String fullDescription = responseScanner.scanAdvertPage(doc);
                advert.setFullDescription(fullDescription);
                //System.out.println(fullDescription);

                Boolean save = reviewString(advert.getFullDescription());
                    if (save) {
                        favouriteAdverts.add(advert);
                    }
            }
        }
    }


    private Boolean reviewString(String description) {
        Boolean saveAdvert = false;
        Boolean checkForExceptions = checkRequirements(description);

        if (checkForExceptions) {
             saveAdvert = checkExceptions(description);
        }

        return saveAdvert;
    }

    private Boolean checkExceptions(String description) {

        Boolean save = true;
        for (String excludeSearch : shoppingList.exceptions) {
           // System.out.println(excludeSearch.toLowerCase());
          //  System.out.println(description.toLowerCase());
            if (description.toLowerCase().contains(excludeSearch.toLowerCase())){
                save = false;
                System.out.println("Denied");
            }
        }

        return save;

    }

    private boolean checkRequirements(String description) {
        int requirements = shoppingList.requirements.size();
        int requirementsMet = 0;
        requirements = 1;

        for (String requirement : shoppingList.requirements) {
            if (description.toLowerCase().contains(requirement.toLowerCase())){
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
