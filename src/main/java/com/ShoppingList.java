package com;

import java.util.ArrayList;

public class ShoppingList {
        int maxPrice;
        int minPrice;
        String location;
        String category;
        ArrayList<String> shoppingList = new ArrayList<>(1);
        // other properties ...

        private ShoppingList() { }

        public static ShoppingList create() {
            return new ShoppingList();
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
            this.shoppingList.add(item);
            return this;
        }

}
