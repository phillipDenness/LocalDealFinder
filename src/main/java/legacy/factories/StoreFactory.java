package legacy.factories;

import legacy.gumtree.Gumtree;
import legacy.shopper.Store;
import legacy.shpock.Shpock;

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
