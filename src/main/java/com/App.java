package com;

import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        Shopper shopper = Shopper.INSTANCE;
        Store gumtree = StoreFactory.getStore("Gumtree");

        Publisher logPublisher = PublisherFactory.getPublisher("Log");
        PersistentHandler.setMode("Local");

        ArrayList<ShoppingList> shoppingLists = new ArrayList<>();
        ShoppingList graphicsCardShopper = ShoppingList.create()
                .maxPrice(310)
                .minPrice(0)
                .shoppingLocation("London")
                .category("video-cards-sound-cards")
                .lookingFor("GTX 1070")
                .lookingFor("GTX 1060")
                .addException("GTX 960")
                .addException("GTX 970");
        shoppingLists.add(graphicsCardShopper);

        ShoppingList gamingPc = ShoppingList.create()
                .maxPrice(200)
                .minPrice(0)
                .shoppingLocation("London")
                .category("desktop-workstation-pcs")
                .lookingFor("i5")
                .lookingFor("i7")
                .lookingFor("ryzen")
                .lookingFor("GTX 1060")
                .lookingFor("GTX 970")
                .addException("hp")
                .addException("dell")
                .addException("lenovo")
                .addException("q6600")
                .addException("apple")
                .addException("Fujitsu")
                .addException("mac")
                .addException("packard");
        shoppingLists.add(gamingPc);

        while (true) {
            LogPublisher.updateTimeStamp(PersistentHandler.favouriteAdverts);
            for (ShoppingList shoppingList : shoppingLists) {

                shopper.setShoppingList(shoppingList);
                gumtree.setUrl(shopper.getShoppingList());

                shopper.setStore(gumtree);
                Document doc = shopper.getBrowser().openPage(gumtree.getUrl());

                ResponseScanner gumtreeResponseScanner = ResponseScannerFactory.getResponseScanner(gumtree.getStoreType());
                gumtreeResponseScanner.scanSearchPage(doc);

                shopper.setResponseScanner(gumtreeResponseScanner);
                shopper.reviewAdverts(gumtreeResponseScanner.getAdverts());
                logPublisher.writeFavouriteAdverts(shopper.getFavouriteAdverts());

                System.out.println();

            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
