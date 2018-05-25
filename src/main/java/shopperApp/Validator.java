package shopperApp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
}
