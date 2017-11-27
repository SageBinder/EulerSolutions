package com.sage;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger sum = new BigInteger("0");

        for(int i = 1; i <= 1000; i++) {
            BigInteger power = new BigInteger(Integer.toString(i));
            power = power.pow(i);
            sum = sum.add(power);
        }
        String sumString = sum.toString();
        System.out.println("Last ten digits: " + sumString.substring(sumString.length() - 10, sumString.length()));
    }
}
