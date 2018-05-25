package com.factories;

import com.LogPublisher;
import com.Publisher;

public class PublisherFactory {
    public static Publisher getPublisher(String criteria) {
        if (criteria.equals("Log")) {

            return new LogPublisher();
        }else{
            return null;
        }
    }
}
