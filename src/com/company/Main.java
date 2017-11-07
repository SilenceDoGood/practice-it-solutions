package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    private static List<int[]> results = new ArrayList<>();

    public static void main(String[] args) {
        makeChange(137);
        results.sort(Comparator.comparing(a -> a[0]));
//        results.sort(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                //return sumSet(a) - sumSet(b);
//                for(int i = 0; i < a.length; i++) {
//                    if(a[i] - b[i] != 0) {
//                        return a[i] - b[i];
//                    }
//                }
//                return  0;
//            }
//        });

        results.forEach((item)->logSetReverse(item));
    }

    private static int sumSet(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * (a.length - i);
        }
        return sum;
    }


    public static void makeChange(int amount) {
        int[] coins = { 25, 10, 5, 1 };
        int[] counts = new int[coins.length];
        getChangeRecurGreedy(coins, counts, 0, amount);
    }


    public static void getChangeRecurGreedy(int[] coins, int[] counts, int index, int amount) {
        if(index >= coins.length)   {
            results.add(counts.clone());
            return;
        }
        if(index == coins.length - 1 && amount % coins[index] == 0) {
            counts[index] = amount / coins[index];
            getChangeRecurGreedy(coins, counts, index + 1, 0);
        } else {
            for(int i = 0; i <= amount / coins[index]; i++) {
                counts[index] = i;
                getChangeRecurGreedy(coins, counts, index + 1, amount - coins[index] * i);
            }
        }
    }

    private static void logSetReverse(int[] set) {
        System.out.print("[");
            for(int i = set.length - 1; i >= 0; i--) {
            if(i > 0)
                System.out.print(set[i] + ", ");
            else
                System.out.println(set[i] + "]");
        }
    }
}
