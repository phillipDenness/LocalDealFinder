package com;

import com.factories.PublisherFactory;
import com.factories.ResponseScannerFactory;
import com.factories.StoreFactory;
import org.jsoup.nodes.Document;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        Shopper shopper = Shopper.INSTANCE;
        Store gumtree = StoreFactory.getStore("Gumtree");

        Publisher logPublisher = PublisherFactory.getPublisher("Log");
        Validator validator = new Validator();
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
            LogPublisher.updateTimeStamp(PersistentHandler.getFavouriteAdverts());
            for (ShoppingList shoppingList : shoppingLists) {

                shopper.setShoppingList(shoppingList);
                gumtree.setUrl(shopper.getShoppingList());

                shopper.setStore(gumtree);
                Document doc = shopper.getBrowser().openPage(gumtree.getUrl());

                ResponseScanner gumtreeResponseScanner = ResponseScannerFactory.getResponseScanner(gumtree.getStoreType());
                gumtreeResponseScanner.scanSearchPage(doc,validator);

                shopper.setResponseScanner(gumtreeResponseScanner);
                shopper.reviewAdverts(gumtreeResponseScanner.getAdverts(), validator);
                logPublisher.writeFavouriteAdverts(shopper.getFavouriteAdverts());
            }
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
