package com;

import org.jsoup.nodes.Document;

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
        Document doc = shopper.getBrowser().openPage(gumtree.getUrl());

        ResponseScanner gumtreeResponseScanner = ResponseScannerFactory.getResponseScanner(gumtree.getStoreType());
        gumtreeResponseScanner.scanSearchPage(doc);

        shopper.reviewAdverts(gumtreeResponseScanner.getAdverts());


        //shopper.getBrowser().sendGetRequest(shopper.getStore().getUrl());
        //shopper.getBrowser().readResponse();
        //shopper.getBrowser().disconnect();
        // ResponseScannerFactory.



    }
}
