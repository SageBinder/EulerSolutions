package solutions.euler55.java.main;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        int answer = 0;
        for(int i = 1; i < 10000; i++) {
            if(isLychrel(i)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isPalindromic(BigInteger n) {
        String nString = n.toString();
        if(nString.equals(new StringBuilder(nString).reverse().toString())) {
            return true;
        }
        return false;
    }

    public static boolean isLychrel(int n) {
        BigInteger sum = new BigInteger(Integer.toString(n));
        for(int i = 0; i < 50; i++) {
            sum = sum.add(new BigInteger(new StringBuilder(sum.toString()).reverse().toString()));
            if(isPalindromic(sum)) {
                return false;
            }
        }
        return true;
    }
}
