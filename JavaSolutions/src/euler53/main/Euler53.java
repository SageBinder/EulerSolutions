package euler53.main;

import java.math.BigInteger;

public class Euler53 {
    public static void main(String[] args) {
        int answer = 0;
        for(int n = 1; n <= 100; n++) {
            for(int k = 0; k <= n; k++) {
                if(nChooseK(n, k).compareTo(new BigInteger("1000000")) == 1) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static BigInteger nChooseK(int n, int k) {
        System.out.println("nChooseK returning " + factorial(n).divide(factorial(k).multiply(factorial(n - k))));
        return factorial(n).divide(factorial(k).multiply(factorial(n - k)));
    }

    public static BigInteger factorial(int n) {
        if(n <= 0) {
            return new BigInteger("1");
        }

        BigInteger product = new BigInteger("1");
        for(int i = n; i > 0; i--) {
            product = product.multiply(new BigInteger(i + ""));
        }
        return product;
    }
}
