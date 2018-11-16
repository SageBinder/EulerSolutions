package solutions.euler26.java.main;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        int greatestN = 0;
        int greatestRepeating = 0;
        for(int n = 7; n < 1000; n++) {
            if(isPrime(n)) {
                for(int length = 1; ; length++) {
                    System.out.println(n + ", " + length);
                    BigInteger num = new BigInteger("10");
                    num = num.pow(length);

                    if(num.mod(new BigInteger(Integer.toString(n))).equals(new BigInteger("1"))) {
                        if(length > greatestRepeating) {
                            greatestN = n;
                            greatestRepeating = length;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(greatestN);
    }
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}
