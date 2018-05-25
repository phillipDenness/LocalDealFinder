package shopperApp.shopper;

import org.jsoup.nodes.Document;
import java.util.ArrayList;

public interface ResponseScanner {
    void scanSearchPage(Document doc, Validator validator);
    String scanAdvertPage(Document doc);
    ArrayList<Advert> getAdverts();
}
