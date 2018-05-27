package legacy.shopper;

import java.io.*;
import java.util.ArrayList;

public class LogPublisher implements Publisher {

    public static void updateTimeStamp(String logLocation) {
        RandomAccessFile f = null;
        try {
            f = new RandomAccessFile(new File(logLocation), "rw");
            f.seek(0); // to the beginning
            String timeStamp =new java.util.Date().toString()+"\n";
            f.write(timeStamp.getBytes());
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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

                String outputLine = Double.toString(advert.getPrice());
                outputLine += "," + advert.getName();
                outputLine += "," + advert.getLink();

                writeStringToFile(outputLine, PersistentHandler.getFavouriteAdverts());

        }
    }
}
