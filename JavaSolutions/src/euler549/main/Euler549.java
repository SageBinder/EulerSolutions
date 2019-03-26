package euler549.main;

import java.util.ArrayList;

public class Euler549 {
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        primes.add(2);

        generatePrimesUpTo(100000000 / 2);
        long sum = 0;
        for(int n = 2; n <= 100000000; n++) {
            System.out.println("Checking i: " + n + ", sum is " + sum);
            sum += smallestFactorialNDivides(n);
        }
        System.out.print(sum);
    }

    public static int smallestFactorialNDivides(int n) {
        if(isPrime(n)) {
            return n;
        }

        int primeCheck = 1;

        int prime;
        int greatestM = 0;
        for(int i = 0; (prime = primes.get(i)) <= n / 2; i++) {
            int primeExponent = primeExponent(prime, n);

            if(primeExponent != 0) {
                // --- This code calculates the minimum m needed where (prime ^ primeExponent) % m! == 0 ---
                int m = prime;
                int numPrimesInMFactorial = 1;

                while(numPrimesInMFactorial < primeExponent) {
                    m += prime;
                    numPrimesInMFactorial += primeExponent(prime, m);
                }
                // -----------------------------------------------------------------------------------------

                if(m > greatestM) {
                    greatestM = m;
                }

                primeCheck *= Math.pow(prime, primeExponent);
                if(primeCheck == n) {
                    return greatestM;
                }
            }
        }

        return greatestM;
    }

    public static int primeExponent(int prime, int n) {
        int tempN = n;
        int count = 0;
        while(tempN % prime == 0) {
            tempN /= prime;
            count++;
        }

        return count;
    }

    private static void generatePrimesUpTo(int n) {
        while(primes.get(primes.size() - 1) < n) {
  //          System.out.println("Last added " + primes.get(primes.size() - 1));
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
