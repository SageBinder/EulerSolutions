package com.sage;

public class Main {
    public static void main(String[] args) {
        double answer = 0;

        for(long i = 999999999; i >= 0; i--) {
            StringBuilder unknownDigitsSB = new StringBuilder(Long.toString(i));
            unknownDigitsSB.reverse();
            while(unknownDigitsSB.length() < 9) {
                unknownDigitsSB.append("0");
            }
            unknownDigitsSB.reverse();

            StringBuilder squareSB = new StringBuilder();
            for(int j = 0; j < 9; j++) {
                squareSB.append(Integer.toString(j + 1)).append(unknownDigitsSB.charAt(j));
            }
            squareSB.append("9");

            long square = Long.parseLong(squareSB.toString());
            double sqrt = Math.sqrt(square);

            System.out.println("Checking if " + square + ", " + squareSB.toString() + ", is a perfect square, sqrt is " + String.format("%.7f", sqrt));

            if(sqrt % 1 == 0) {
                System.out.println("Answer found, square is " + square + ", sqrt is " + String.format("%.7f", sqrt));
                answer = sqrt;
                break;
            }
        }

        // YOU KNOW WHAT THERE ARE FUCKING FLOATING POINT ERRORS AND SHIT IN THIS CODE BUT FUCK IT GETS THE RIGHT ANSWER
        System.out.println(String.format("%.0f", answer) + ", " + String.format("%.0f", Math.pow(answer, 2)));
    }
}
