package legacy.shopper.factories;

import legacy.shopper.Store;
import legacy.shopper.gumtree.Gumtree;
import legacy.shopper.shpock.Shpock;

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
