package euler112.main;

import java.util.Arrays;
import java.util.HashMap;

public class Euler112 {
    // First index is numDigits, second index is firstDigit
    static HashMap<int[], Boolean> bouncyMap = new HashMap<>();

    public static void main(String[] args) {
        int answer;
        long startTime = System.nanoTime();
        long endTime;

        for(int i = 1, totalBouncy = 0; ; i++) {
            boolean isBouncy = isBouncy(i);
            if(isBouncy) {
                totalBouncy++;
            }

            double bouncyProportion = (double)totalBouncy / (double)i;
            System.out.print("Number " + i + " ");
            if(isBouncy) {
                System.out.print("is bouncy, ");
            } else {
                System.out.print("is not bouncy, ");
            }
            System.out.println("total bouncy proportion is now " + totalBouncy + " / " + i + " (" + bouncyProportion +  ")");

            if(bouncyProportion == 0.99d) {
                endTime = System.nanoTime();
                System.out.printf("Bouncy proportion of 99%% found! Checked up to " + i + " (inclusive), found " +
                        totalBouncy + " bouncy numbers and " +
                        (i - totalBouncy) + " non-bouncy numbers " +
                        "(took %03.5f seconds)%n", (double)(endTime - startTime) / 1000000000d);
                answer = i;
                break;
            }
        }

        System.out.println("Answer is: " + answer);
    }

    static boolean isBouncy(int num) {
        String numString = Integer.toString(num);
        int[] numArray = new int[numString.length()];

        for(int i = 0; i < numString.length(); i++) {
            numArray[i] = numString.charAt(i) - '0';
        }

        return isBouncy(numArray);
    }

    static boolean isBouncy(int[] digits) {
        if(bouncyMap.containsKey(digits)) {
            return bouncyMap.get(digits);
        }

        boolean isBouncy = false;
        try {
            if(digits.length <= 2) {
                return false;
            }

            if(digits.length == 3) {
                isBouncy = !((digits[0] - digits[1]) * (digits[1] - digits[2]) >= 0);
                return isBouncy;
            } else if(!isBouncy(Arrays.copyOfRange(digits, 1, digits.length))) {
                int firstTwoDigitsDirection = digits[0] - digits[1];
                int remainingDigitsDirection = digits[1] - digits[digits.length - 1];

                if(firstTwoDigitsDirection == 0 || remainingDigitsDirection == 0) {
                    isBouncy = false;
                    return false;
                }

                // isBouncy is set to false if firstTwoDigitsDirections and remainingDigitsDirection have the same sign
                isBouncy = (firstTwoDigitsDirection >= 0) == (remainingDigitsDirection < 0);
                return isBouncy;
            } else {
                isBouncy = true;
                return true;
            }
        } finally {
            bouncyMap.put(digits, isBouncy);
        }
    }
}
