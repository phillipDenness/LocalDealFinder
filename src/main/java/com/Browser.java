package com;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public enum Browser {
    INSTANCE;

    private URL url;
    private HttpURLConnection connection;
    private BufferedReader br;
    private boolean connected = false;

    public void searchStore (String urlString) {
        try {

            Document doc = Jsoup.connect(urlString).get();
            Elements foundAdverts = doc.select("a.listing-link");

            ArrayList<Advert> adverts = new ArrayList<>();
            for (int n=3 ; n < foundAdverts.size() ; n++) {
                System.out.println(n);
                Element advertSummary = foundAdverts.get(3);
                Advert advert = AdvertFactory.getAdvert("gumtree");


                advert.setName(advertSummary.selectFirst("h2.listing-title").text());
                advert.setShortDescription(advertSummary.selectFirst("p.listing-description").text());
                advert.setLink(advertSummary.attr("abs:href"));
                advert.setPrice(Double.parseDouble(advertSummary.select("meta").get(3).attr("content")));
                adverts.add(advert);
                }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void sendGetRequest(String urlString) {
        try {

            if (!connected) {

                System.out.println(urlString);
                url = new URL(urlString);
                connection = (HttpURLConnection) url.openConnection();
                connected = true;

                if (200 <= connection.getResponseCode() && connection.getResponseCode() <= 299) {
                    br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                } else {
                    br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                }

            }else{
                System.out.println("Connection currently active. Disconnect before retrying.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readResponse(){
        String s = null;

        try {

            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
     }

    public HttpURLConnection getConnection(){
        return connection;
    }

    public void disconnect() {
        connection.disconnect();
        connected = false;
    }
}
