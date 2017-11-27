package com.sage;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        int numPrimes = 0;
        for (int i = 8; ; i++) {
            System.out.println("Main, checking " + i);
            if(isTruncatablePrime(i)) {
                sum += i;
                numPrimes++;
            }
            if(numPrimes == 11) {
                break;
            }
        }
        System.out.println(sum);
    }

    public static boolean isTruncatablePrime(long n) {
        if(!isPrime(n)) {
            return false;
        }

        String truncateLeftString = Long.toString(n);
        String truncateRightString = Long.toString(n);

        for (int i = 1; i < Long.toString(n).length(); i++) {
            System.out.println("In for loop");
            truncateLeftString = truncateLeftString.substring(1, truncateLeftString.length());
            truncateRightString = truncateRightString.substring(0, truncateRightString.length() - 1);
            System.out.println("truncateLeft: " + truncateLeftString + ", truncateRight: " + truncateRightString);
            if(!(isPrime(Long.parseLong(truncateLeftString)) && isPrime(Long.parseLong(truncateRightString)))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}