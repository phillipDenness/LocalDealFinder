package shopperApp.shopper;

import java.util.ArrayList;

public class ShoppingList {
        int maxPrice;
        int minPrice;
        String location;
        private String category;
        ArrayList<String> requirements = new ArrayList<>(1);
        ArrayList<String> exceptions = new ArrayList<>(1);
    // other properties ...

        private ShoppingList() {}
        public static ShoppingList create() {
            return new ShoppingList();
        }

    public String getCategory() {
        return category;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<String> getExceptions() {
        return exceptions;
    }

    public ArrayList<String> getRequirements() {
        return requirements;
    }

    public ShoppingList category(String category) {
            this.category = category;
            return this;
        }

        public ShoppingList minPrice(int minPrice) {
            this.minPrice = minPrice;
            return this;
        }

        public ShoppingList maxPrice(int maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public ShoppingList shoppingLocation(String location) {
            this.location = location;
            return this;
        }

        public ShoppingList lookingFor(String item){
            this.requirements.add(item);
            return this;
        }

        public ShoppingList addException(String item){
            this.exceptions.add(item);
            return this;
        }

    public ShoppingList build(Shopper shopper) {
            shopper.setShoppingList(this);
        return this;
    }
}
