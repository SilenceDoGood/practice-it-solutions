package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        makeChange(28);
    }


    public static void makeChange(int amount) {
        ArrayList<Integer> coinValues = new ArrayList<>();
        coinValues.add(1);
        coinValues.add(5);
        coinValues.add(10);
        coinValues.add(25);

        getChangeRecur(new ArrayList<>(coinValues), amount, 0, amount);
    }

    public static void getChangeRecur(ArrayList<Integer> array, int amount, int index, int total) {
        if (index < array.size()){
            int quantity = amount / array.get(index);
            int val = array.get(index);
            for (int i = 0; i <= quantity; i++) {
                ArrayList<Integer> tmp = new ArrayList<>(array);
                tmp.set(index, i);
                getChangeRecur(tmp, amount - (val * i), ++index, total);
            }
        } else {
            System.out.println(array);
        }
    }
}
