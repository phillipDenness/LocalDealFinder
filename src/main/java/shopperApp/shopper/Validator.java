package shopperApp.shopper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

<<<<<<< HEAD:src/main/java/com/shopper/Validator.java
public class Validator {

    public Boolean checkIfAlreadySearched(String link,String logLocation) {

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

            LogPublisher.writeStringToFile(link,PersistentHandler.getPreviousLInks());
            return true;

        } catch(IOException e) {
            //handle this
        }

        return true;
    }
=======
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

>>>>>>> master:src/main/java/com/PersistentHandler.java
}
