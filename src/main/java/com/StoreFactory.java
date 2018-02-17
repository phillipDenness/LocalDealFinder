package com;

public class StoreFactory {
    public static Store getStore(String criteria)
    {
        if ( criteria.equals("Gumtree") )

            return new Gumtree();

        else if ( criteria.equals("Shpock") )

            return new Shpock();

        return null;
    }
}
