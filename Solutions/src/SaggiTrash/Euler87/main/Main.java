package SaggiTrash.Euler87.main;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 50000000;

        int answer = 0;
        int[] primes = generatePrimes((int)Math.sqrt(n) + 1);
        Arrays.sort(primes);
        boolean[] found = new boolean[n + 1];

        for(int i : primes) {
            int iPow = (int)Math.pow(i, 2);
            if(iPow >= n) {
                break;
            }

            for(int j : primes) {
                int jPow = (int)Math.pow(j, 3);
                if(jPow + iPow >= n) {
                    break;
                }

                for(int k : primes) {
                    int kPow = (int)Math.pow(k, 4);
                    int sum = iPow + jPow + kPow;
                    if(sum >= n) {
                        break;
                    } else if(!found[sum]) {
                        found[sum] = true;
                        answer++;
                        System.out.println("Found answer " + i + " ^ 2, " + j + " ^ 3, " + k + " ^ 4" + ", sum = " + sum + ", answer = " + answer);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int[] generatePrimes(int max) {
        boolean[] isComposite = new boolean[max + 1];
        for (int i = 2; i * i <= max; i++) {
            if (!isComposite [i]) {
                for (int j = i; i * j <= max; j++) {
                    isComposite [i*j] = true;
                }
            }
        }
        int numPrimes = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) numPrimes++;
        }
        int [] primes = new int [numPrimes];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) primes [index++] = i;
        }
        return primes;
    }
}
