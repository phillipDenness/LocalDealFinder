package com;

public interface Store {
    String getUrl();
    void setUrl(ShoppingList url);
    String getPricePattern();
    String getLinkPattern();
    String getTitlePattern();
}
