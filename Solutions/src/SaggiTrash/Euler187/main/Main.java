package SaggiTrash.Euler187.main;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Integer> primes = new ArrayList<>();
    private static final int n = 100000000;

    public static void main(String[] args) {
        generatePrimesUnder(n);

        int nSqrt = (int)Math.ceil(Math.sqrt(n));
        int answer = 0;
        for(int i = 0; i < primes.size(); i++) {
            int primeI = primes.get(i);
            if(primeI > nSqrt) {
                break;
            }

            for(int j = i; j < primes.size(); j++) {
                int primeJ = primes.get(j);
                System.out.println("Checking primes " + primeI + " * " + primeJ);

                int composite = primeI * primeJ;
                if(composite < n) {
                    answer++;
                } else {
                    break;
                }
            }
        }

        System.out.println("Answer: " + answer);
    }

    private static void generatePrimesUnder(int n) {
        if(primes.size() == 0) {
            primes.add(2);
        }

        while(primes.get(primes.size() - 1) < n) {
            primes.add(generateNextPrime(primes.get(primes.size() - 1)));
        }
    }

    private static int generateNextPrime(int n) {
        for(int i = n + (n % 2) + 1; ; i += 2) {
            if(isPrime(i)) {
                return i;
            }
        }
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
