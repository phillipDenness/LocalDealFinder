package com.shopper.factories;

import com.shopper.LogPublisher;
import com.shopper.Publisher;

public class PublisherFactory {
    public static Publisher getPublisher(String criteria) {
        if (criteria.equals("Log")) {

            return new LogPublisher();
        }else{
            return null;
        }
    }
}
