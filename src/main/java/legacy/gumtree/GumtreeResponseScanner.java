package legacy.gumtree;

import legacy.factories.AdvertFactory;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import legacy.PersistentHandler;
import legacy.Validator;
import legacy.shopper.Advert;

import java.util.ArrayList;

public class GumtreeResponseScanner {

    private ArrayList<Advert> adverts = new ArrayList<>();
    private String storeType;

    public GumtreeResponseScanner(String storeType){
        this.storeType = storeType;
    }

    public void scanSearchPage(Document doc, Validator validator) {
        Elements foundAdverts = doc.select("a.listing-link");
        iterateAdverts(foundAdverts,validator);
    }

    private void iterateAdverts(Elements foundAdverts, Validator validator){
        for (int n = 3; n < foundAdverts.size(); n++) {
            //System.out.println(n);
            Element advertSummary = foundAdverts.get(n);
            buildAdvertObject(advertSummary,validator);
        }
    }

    public void buildAdvertObject(Element advertSummary, Validator validator) {
        Advert advert = AdvertFactory.getAdvert(storeType);

        advert.setName(advertSummary.selectFirst("h2.listing-title").text());
        advert.setShortDescription(advertSummary.selectFirst("p.listing-description").text());
        advert.setLink(advertSummary.attr("abs:href"));
        advert.setPrice(Double.parseDouble(advertSummary.select("meta").get(3).attr("content")));


        Boolean isValid = validator.checkIfAlreadySearched(advert.getLink(), PersistentHandler.getPreviousLInks());
        if (isValid) {
            adverts.add(advert);
        }
    }

    public ArrayList<Advert> getAdverts() {
        return adverts;
    }

    public String scanAdvertPage(Document doc) {
        String fullDescription = doc.selectFirst("p.ad-description").text();
        return fullDescription;
    }
}
