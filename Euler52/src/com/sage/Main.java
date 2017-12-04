package com.sage;

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
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numLength; j++) {
                char currentDigit = Integer.toString(numbers[i]).charAt(j);
                for(int k = 0; k < numbers.length; k++) {
                    if(!Integer.toString(numbers[k]).contains(currentDigit + "")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
