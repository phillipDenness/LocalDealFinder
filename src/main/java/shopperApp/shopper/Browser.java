package shopperApp.shopper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public enum Browser {
    INSTANCE;

    public static Document openPage(String urlString) {
        try {

            Document doc = Jsoup.connect(urlString).get();
            return doc;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
