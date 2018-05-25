package shopperApp.shopper.gumtree;

import shopperApp.shopper.Advert;
import shopperApp.shopper.Browser;
import org.jsoup.nodes.Document;

public class GumtreeAdvert implements Advert {
    private String name;
    private Double price;
    private String shortDescription;
    private String link;
    private String fullDescription;

    public Document viewAdvert() {
        Document doc = Browser.openPage(this.getLink());
        return doc;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }

    @Override
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    @Override
    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    @Override
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    @Override
    public String getFullDescription() {
        return this.fullDescription;
    }
}
