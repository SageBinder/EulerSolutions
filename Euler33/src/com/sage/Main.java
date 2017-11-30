package com.sage;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Double> numerators = new ArrayList<>();
        ArrayList<Double> denominators = new ArrayList<>();

        for(double numerator = 10; numerator < 100; numerator++) {
            String numeratorString = Double.toString(numerator);
            for(double denominator = 10; denominator < 100; denominator++) {
                String denominatorString = Double.toString(denominator);

                if((numerator % 10 == 0 && denominator % 10 == 0) || numerator == denominator || numerator > denominator) {
                    continue;
                }

                double originalFraction = numerator / denominator;
                for(int i = 1; i < 10; i++) {
                    String iString = Integer.toString(i);

                    if(numeratorString.contains(iString) && denominatorString.contains(iString)) {
                        double simplifiedFraction = Double.parseDouble(numeratorString.replaceAll(iString, ""))
                                / Double.parseDouble(denominatorString.replaceAll(iString, ""));

                        if(simplifiedFraction == originalFraction) {
                            numerators.add(numerator);
                            denominators.add(denominator);
                        }
                    }
                }
            }
        }
        for(int i = 0; i < numerators.size(); i++) {
            System.out.print(numerators.get(i) + " ");
        }
        System.out.println("");
        for(int i = 0; i < denominators.size(); i++) {
            System.out.print(denominators.get(i) + " ");
        }
        int numeratorProduct = 1;
        int denominatorProduct = 1;
        for(int i = 0; i < numerators.size(); i++) {
            numeratorProduct *= numerators.get(i);
            denominatorProduct *= denominators.get(i);
        }
        System.out.println("\n");
        System.out.println(numeratorProduct + " / " + denominatorProduct);
    }
}
