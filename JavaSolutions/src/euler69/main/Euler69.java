package euler69.main;

import java.util.ArrayList;

public class Euler69 {

    public static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        int count = 0;
        double averageTime = 0;
        double totalTime = 0;

        double maxFound = 0;
        int maxAnswer = 0;

        for(int n = 2; n < 1000000; n++) {
            // ----------TIMING CODE----------
            double startTime = System.nanoTime();
            // -------------------------------

            double totient = totient(n);
            double found = n / totient;

            System.out.println("Checking: " + n + ", totient is " + totient + ", n / totient(n) is " + found);
            if(found > maxFound) {
                maxFound = found;
                maxAnswer = n;
            }

            // ----------TIMING CODE----------
            double endTime = System.nanoTime();
            double deltaTime = endTime - startTime;
            totalTime += deltaTime;
            averageTime = totalTime / count++;
            System.out.println("Took " + (deltaTime / 1000000000) + " seconds (" + deltaTime + " nanos), average time so far: " + averageTime / 1000000000 + " seconds (" + averageTime + " nanos)");
            // -------------------------------
        }

        System.out.println("Max n: " + maxAnswer
                + ", with an n / totient(n) of " + maxFound
                + ", took " + (totalTime / 1000000000) + " seconds, with an average time of " + (averageTime / 1000000000) + " seconds");
    }

    public static double totient(int n) {
        ArrayList<Integer> factors = distinctPrimeFactors(n);

        double product = 1;
        for(double p : factors) {
            product *= 1 - (1 / p);
        }
        product *= (double)n;

        return product;
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

    private static ArrayList<Integer> distinctPrimeFactors(int n) {
        generatePrimesUnder(n);

        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);

            if(prime > n) {
                break;
            }
            if(n % prime == 0) {
                factors.add(prime);
            }
        }
        return factors;
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
