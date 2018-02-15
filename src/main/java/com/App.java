package com;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main( String[] args )
    {

        Shopper shopper = Shopper.INSTANCE;

        Store gumtree = StoreFactory.getStore("Gumtree");


        ShoppingList graphicsCardShopper = ShoppingList.create()
                .availableAllowance(300.00)
                .shoppingLocation("London")
                .lookingFor("GTX 1070")
                .lookingFor("GTX 1080");

        shopper.setStore(gumtree);
        shopper.setShoppingList(graphicsCardShopper);

    }
}
