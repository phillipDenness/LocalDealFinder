package shopperApp.shopper.factories;

import shopperApp.shopper.Store;
import shopperApp.shopper.gumtree.Gumtree;
import shopperApp.shopper.shpock.Shpock;

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
