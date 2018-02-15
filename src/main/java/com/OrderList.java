package com;

import java.util.ArrayList;

public class OrderList {
    
    public static ArrayList<Integer> orderList(ArrayList<Integer> myArray){

        for (int i=0 ; i<myArray.size(); i++){
            System.out.println("OuterLoop="+ myArray);

            for (int n=0 ; n<myArray.size()-1 ; n++){

                System.out.println("InnerLoop="+myArray);

                if (myArray.get(n) > myArray.get(n+1)) {
                    Integer temp1 = myArray.get(n + 1);
                    Integer temp2 = myArray.get(n);

                    System.out.println("temp1="+temp1+";"+"temp2="+temp2);

                    myArray.set(n,temp1);
                    myArray.set(n+1,temp2);
                }
            }

        }
        return myArray;
    }

}
