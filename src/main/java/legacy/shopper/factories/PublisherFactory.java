package legacy.shopper.factories;

import legacy.shopper.LogPublisher;
import legacy.shopper.Publisher;

public class PublisherFactory {
    public static Publisher getPublisher(String criteria) {
        if (criteria.equals("Log")) {

            return new LogPublisher();
        }else{
            return null;
        }
    }
}
