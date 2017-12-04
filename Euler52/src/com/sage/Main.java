package com.sage;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int smallestSameDigitNum;

        for(int i = 1; ; i++) {
            System.out.println("Checking: " + i);
            int[] numbers = new int[6];
            for(int j = 0; j < numbers.length; j++) {
                numbers[j] = i * (j + 1);
            }
            if(sameDigits(numbers)) {
                smallestSameDigitNum = i;
                break;

            }
        }
        System.out.println(smallestSameDigitNum);
    }

    public static boolean sameDigits(int[] numbers) {
        for(int i = 0; i < numbers.length - 1; i++ ) {
            if(!(Integer.toString(numbers[i]).length() == Integer.toString(numbers[i + 1]).length())) {
                return false;
            }
        }

        int numLength = Integer.toString(numbers[0]).length();

        for(int i = 0; i < numLength; i++) {
            char currentDigit = Integer.toString(numbers[0]).charAt(i);
            for(int j = 1; j < numbers.length; j++) {
                if(!Integer.toString(numbers[j]).contains(currentDigit + "")) {
                    return false;
                }
            }
        }
        return true;
    }
}
