package SaggiTrash.Euler27.main;

public class Main {

    public static void main(String[] args) {
        int mostConsecutivePrimes = 0;
        int coefficientsProduct = 0;

        for(int a = -999; a < 1000; a++) {
            for(int b = -1000; b <= 1000; b++) {
                int consecutivePrimes = consecutivePolynomialPrimes(a, b);

                if(consecutivePrimes > mostConsecutivePrimes) {
                    mostConsecutivePrimes = consecutivePrimes;
                    coefficientsProduct = a * b;
                }
            }
        }

        System.out.println(coefficientsProduct);
    }

    public static int consecutivePolynomialPrimes(int a, int b) {
        int n = 0;
        for(; isPrime(polynomialValue(n, a, b)); n++);

        return n;
    }

    public static int polynomialValue(int n, int a, int b) {
        return (n * n) + (a * n) + b;
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
