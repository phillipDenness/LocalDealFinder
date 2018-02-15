package com;

public class Gumtree implements Store{
    private String urlString;

    public Gumtree(String urlString){
        this.setUrl(urlString);
    }

    public String getUrl() {
        return urlString;
    }

    public void setUrl(String url) {
        this.urlString = url;
    }
}
