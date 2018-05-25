package shopperApp.factories;

import com.Store;
import shopperApp.gumtree.Gumtree;
import shopperApp.shpock.Shpock;

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
