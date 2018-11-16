package solutions.euler63.java.main;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        int sum = 0;

        for(int i = 1; i < 10; i++) {
            for(int n = 1; ; n++) {
                BigInteger power = new BigInteger("" + i);
                power = power.pow(n);
                if(n > power.toString().length()) {
                    break;
                }
                System.out.println("Checking " + i + " ^ " + n + ", which is " + power.toString() + ", numDigits is " + numDigits(power));
                if(numDigits(power) == n) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    public static int numDigits(BigInteger n) {
        return n.toString().length();
    }
}
