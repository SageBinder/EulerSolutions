package SaggiTrash.Euler43.main;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long sum = 0;

        for(int n = 0; n < factorial(10); n++) {
            long pandigital = nthPandigital(n, 10);

            if(hasSubstringDivisibilityProperty(pandigital)) {
                if(pandigital < 1023456789) {
                    continue; // This if statement ignores pandigitals which start with 0
                }
                System.out.println("Adding " + pandigital + " to sum");
                sum += pandigital;
            }
        }
        System.out.println(sum);
    }

    public static boolean hasSubstringDivisibilityProperty(long n) {
        String nString  = Long.toString(n);

        for(int i = 1, prime = 2; i <= nString.length() - 3; i++, prime = nextPrime(prime)) {
            int subStringInt = Integer.parseInt(nString.charAt(i) + "" + nString.charAt(i + 1) + "" + nString.charAt(i + 2));
            if(!(subStringInt % prime == 0)) {
                return false;
            }
        }
        return true;
    }

    public static int nextPrime(int n) {
        for(int i = n + 1; ; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

    public static long nthPandigital(int n, int numDigits) {
        if(n < 0 || numDigits > 10 || n >= factorial(numDigits)) {
            return -1;
        }

        int sum = 0;
        int[] digits = new int[numDigits];
        ArrayList<Integer> digitsList = new ArrayList<>();
        for(int i = 0; i < numDigits; i++) {
            digitsList.add(i);
            digits[i] = i;
        }

        for(int i = numDigits, c = 0; i > 0; i--, c++) {
            int factorial = factorial(i);
            int factorialOverI = factorial / i;
            int nextDigitIndex = 0;
            while(sum + factorialOverI <= n) {
                sum += factorialOverI;
                nextDigitIndex++;
            }
            digits[c] = digitsList.get(nextDigitIndex);
            digitsList.remove(nextDigitIndex);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : digits) {
            sb.append(Integer.toString(i));
        }
        return Long.parseLong(sb.toString());
    }

    public static int factorial(int n) {
        int factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
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
