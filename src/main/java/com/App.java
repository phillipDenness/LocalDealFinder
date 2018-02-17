package com;

import java.io.IOException;

public class App
{
    public static void main( String[] args )
    {

        Shopper shopper = Shopper.INSTANCE;
        Store gumtree = StoreFactory.getStore("Gumtree");

        ShoppingList graphicsCardShopper = ShoppingList.create()
                .maxPrice(310)
                .minPrice(0)
                .shoppingLocation("London")
                .category("video-cards-sound-cards")
                .lookingFor("GTX 1070")
                .lookingFor("GTX 1080");

        shopper.setShoppingList(graphicsCardShopper);

        gumtree.setUrl(shopper.getShoppingList());
        shopper.setStore(gumtree);

        Browser.sendGetRequest(shopper.getStore().getUrl());
        Browser.readResponse();

    }
}
