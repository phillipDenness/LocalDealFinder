package com;

public class StoreFactory {
    public static Store getStore(String criteria)
    {
        if ( criteria.equals("Gumtree") )

            return new Gumtree("https://www.gumtree.com/search?search_category=all&q=pc&tq=&search_location=london&tl=");

        else if ( criteria.equals("Shpock") )

            return new Shpock();

        return null;
    }
}
