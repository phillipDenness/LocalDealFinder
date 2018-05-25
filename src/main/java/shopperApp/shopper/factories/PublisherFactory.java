package shopperApp.shopper.factories;

import shopperApp.shopper.LogPublisher;
import shopperApp.shopper.Publisher;

public class PublisherFactory {
    public static Publisher getPublisher(String criteria) {
        if (criteria.equals("Log")) {

            return new LogPublisher();
        }else{
            return null;
        }
    }
}
