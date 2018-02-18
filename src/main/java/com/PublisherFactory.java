package com;

public class PublisherFactory {
    public static Publisher getPublisher(String criteria) {
        if (criteria.equals("Log")) {

            return new LogPublisher();
        }else{
            return null;
        }
    }
}
