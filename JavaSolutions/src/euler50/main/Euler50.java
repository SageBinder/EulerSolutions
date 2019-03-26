package euler50.main;

import java.util.ArrayList;

public class Euler50 {

    public static void main(String[] args) {

        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);

        while(primes.get(primes.size() - 1) < 1000000) {
            primes.add(nextPrime(primes.get(primes.size() - 1)));
        }

        int greatestPrimeChainSum = 0;
        int greatestChain = 0;

        for(int start = 0; start < primes.size(); start++) {
            for (int i = start, chainLength = 0, primeSum = 0; primeSum < 1000000; i++, chainLength++) {
                primeSum += primes.get(i);
                if(isPrime(primeSum) && chainLength > greatestChain) {
                    greatestChain = chainLength;
                    greatestPrimeChainSum = primeSum;
                }
            }
        }

        System.out.println(greatestPrimeChainSum);
    }

    public static int nextPrime(int n) {
        for(int i = n + 1; ; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

    public static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
}



