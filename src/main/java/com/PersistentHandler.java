package com;

import java.io.*;
import java.util.Scanner;

public class PersistentHandler {
    public static String previousLinks;
    public static String favouriteAdverts;

    public static void setMode(String mode) {
        if (mode == "Local") {
            previousLinks = "C:\\Users\\XPS\\Documents\\previousAdverts.log";
            favouriteAdverts = "C:\\Users\\XPS\\Documents\\favouriteAdverts.log";
        }
    }

    static Boolean checkIfAlreadySearched(String link,String logLocation) {

        File file = new File(logLocation);
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(logLocation,true));
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if(line.toLowerCase().contains(link.toLowerCase())) {
                    return false;
                }

            }

            LogPublisher.writeStringToFile(link,PersistentHandler.previousLinks);
            return true;

        } catch(IOException e) {
            //handle this
        }

        return true;
    }
}
