package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Browser {
    private String charset = "UTF-8";
    private static URL url;
    private static HttpURLConnection connection;
    private static BufferedReader br;

    public static void sendGetRequest(String urlString) {
        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            if (200 <= connection.getResponseCode() && connection.getResponseCode() <= 299) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readResponse(){
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
}
