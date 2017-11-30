package com.sage;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> pentagonals = new ArrayList<>();
        pentagonals.add(1);
        int finalD;
        outerLoop:
        for(int i = 1; ; i++) {
            pentagonals.add((i * ((3 * i) - 1)) / 2);
            int lastPentagonal = pentagonals.get(pentagonals.size() - 1);
            for(int j = 0; j < pentagonals.size() - 1; j++) {
                int checkPentagonal = pentagonals.get(j);
                System.out.println("Checking " + lastPentagonal + ", and " + checkPentagonal);
                if(isPentagonal(lastPentagonal - checkPentagonal) && isPentagonal(lastPentagonal + checkPentagonal)) {
                    finalD = lastPentagonal - checkPentagonal;
                    break outerLoop;
                }
            }
        }
        System.out.println(finalD);
    }

    public static boolean isPentagonal(int n) {
        for(int i = 1; (i * ((3 * i) - 1)) / 2 <= n; i++) {
            if((i * ((3 * i) - 1)) / 2 == n) {
                return true;
            }
        }
        return false;
    }
}
