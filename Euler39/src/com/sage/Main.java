package com.sage;

public class Main {

    public static void main(String[] args) {

    }

    public static boolean isRightTriangleSolution(int a, int b, int c) {
        if(a == 0 || b == 0 || c == 0) return false;
        return Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
    }
}
