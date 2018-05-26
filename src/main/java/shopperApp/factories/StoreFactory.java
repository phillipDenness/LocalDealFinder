package shopperApp.factories;

import shopperApp.gumtree.Gumtree;
import shopperApp.shopper.Store;
import shopperApp.shpock.Shpock;

public class StoreFactory {
    public static Store getStore(String criteria)
    {
        if ( criteria.equals("Gumtree") )

            return new Gumtree(criteria);

        else if ( criteria.equals("Shpock") )

            return (Store) new Shpock();

        return null;
    }
}
