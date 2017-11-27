package com.sage;

import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> powersList = new ArrayList<>();
        int count = 0;

        for(int i = 2; i <= 100 ; i++) {
            for(int j = 2; j <= 100; j++) {
                BigInteger power = new BigInteger(Integer.toString(i));
                power = power.pow(j);

                if(!powersList.contains(power.toString())) {
                    powersList.add(power.toString());
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
