package com;

import java.io.*;
import java.util.Scanner;

public class PersistentHandler {
    private static String previousLinks;
    private static String favouriteAdverts;

    public static String getPreviousLInks(){
        return previousLinks;
    }

    public static String getFavouriteAdverts(){
        return favouriteAdverts;
    }

    public static void setMode(String mode) {
        if (mode == "Local") {
            previousLinks = "C:\\Users\\XPS\\Documents\\previousAdverts.log";
            favouriteAdverts = "C:\\Users\\XPS\\Documents\\favouriteAdverts.log";
        }
    }

}
