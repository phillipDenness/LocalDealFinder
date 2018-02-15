package com;

import java.util.ArrayList;

public class ShoppingList {
        Double allowance;
        String location;
        ArrayList<String> shoppingList = new ArrayList<String>(1);
        // other properties ...

        private ShoppingList() { }

        public static ShoppingList create() {
            return new ShoppingList();
        }

        public ShoppingList availableAllowance(Double allowance) {
            this.allowance = allowance;
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
