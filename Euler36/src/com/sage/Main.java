package com.sage;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            if(isDecBinPalin(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean isDecBinPalin(int n) {
        if(n % 10 == 0 || n % 2 == 0) {
            return false;
        }
        return isDecPalin(n) && isBinPalin(n);
    }

    public static boolean isDecPalin(int n) {
        String originalNum = Integer.toString(n);
        String reversedNum = new StringBuilder(originalNum).reverse().toString();

        if(originalNum.equals(reversedNum)) {
            return true;
        }
        return false;
    }

    public static boolean isBinPalin(int n) {
        String originalNum = Integer.toString(n, 2);
        String reversedNum = new StringBuilder(originalNum).reverse().toString();

        if(originalNum.equals(reversedNum)) {
            return true;
        }
        return false;
    }
}