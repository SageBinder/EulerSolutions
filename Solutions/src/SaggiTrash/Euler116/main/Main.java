package SaggiTrash.Euler116.main;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) {
        int n = 50;
        long sum = 0;

        // i is the length of the oblong tile
        // j is the number of oblong tiles used to replace black tiles
        // n is the number of black tiles
        for(int i = 2; i <= 4; i++) {
            System.out.println("i = " + i + ":");

            long sumForCurrI = 0;
            for(int j = 1; j <= n / i; j++) {
                long toAdd = nChooseK(j + (n - (i * j)), j);
                sumForCurrI += toAdd;
                sum += toAdd;

                System.out.println("- i = " + i + ", j = " + j + ", adding " + toAdd + ", current sum is " + sum);
            }

            System.out.println("Total added for i = " + i + ": " + sumForCurrI + "\n");
        }

        System.out.println("Answer: " + sum);
    }

    private static long nChooseK(int n, int k) {
        BigDecimal product = new BigDecimal("1");
        for(int i = 1; i <= k; i++) {
            product = product.multiply(new BigDecimal(Double.toString((double)(n + 1 - i) / (double)i)));
        }

        product = product.round(new MathContext(10, RoundingMode.HALF_UP));
        return product.longValue();
    }
}
