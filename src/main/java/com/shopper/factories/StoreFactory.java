package com.shopper.factories;

import com.shopper.Store;
import com.shopper.gumtree.Gumtree;
import com.shopper.shpock.Shpock;

public class StoreFactory {
    public static Store getStore(String criteria)
    {
        if ( criteria.equals("Gumtree") )

            return new Gumtree(criteria);

        else if ( criteria.equals("Shpock") )

            return new Shpock();

        return null;
    }
}
