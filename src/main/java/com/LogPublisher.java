package com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LogPublisher implements Publisher {

    public static void writeStringToFile(String outputLine, String logLocation) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(logLocation,true));
            writer.append(outputLine);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFavouriteAdverts(ArrayList<Advert> favouriteAdverts) {
        for (Advert advert : favouriteAdverts){
            Boolean isValid = PersistentHandler.checkIfAlreadySearched(advert.getLink(),PersistentHandler.favouriteAdverts);
            if (isValid) {
                String outputLine = Double.toString(advert.getPrice());
                outputLine += "," + advert.getName();
                outputLine += "," + advert.getLink();

                writeStringToFile(outputLine, PersistentHandler.favouriteAdverts);
            }
        }
    }
}
