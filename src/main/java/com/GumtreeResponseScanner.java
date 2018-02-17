package com;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class GumtreeResponseScanner implements ResponseScanner{

    private ArrayList<Advert> adverts = new ArrayList<>();
    private String storeType;

    public GumtreeResponseScanner(String storeType){
        this.storeType = storeType;
    }

    public void scanSearchPage(Document doc) {
        Elements foundAdverts = doc.select("a.listing-link");
        iterateAdverts(foundAdverts);
    }

    @Override
    public void scanAdvertPage(Document doc) {
        
    }

    private void iterateAdverts(Elements foundAdverts){
        for (int n = 3; n < foundAdverts.size(); n++) {
            //System.out.println(n);
            Element advertSummary = foundAdverts.get(n);
            buildAdvertObject(advertSummary);

        }
    }

    public void buildAdvertObject(Element advertSummary) {
        Advert advert = AdvertFactory.getAdvert(storeType);

        advert.setName(advertSummary.selectFirst("h2.listing-title").text());
        advert.setShortDescription(advertSummary.selectFirst("p.listing-description").text());
        advert.setLink(advertSummary.attr("abs:href"));
        advert.setPrice(Double.parseDouble(advertSummary.select("meta").get(3).attr("content")));

        adverts.add(advert);
        //System.out.println(advert.getName());
    }

    public ArrayList<Advert> getAdverts() {
        return adverts;
    }
}
