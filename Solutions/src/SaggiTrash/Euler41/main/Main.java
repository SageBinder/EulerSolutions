package SaggiTrash.Euler41.main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hi");
        int largestPrimePandigital = 0;
        for(int digits = 1; digits < 10; digits++) {
            for(int n = 0; n < factorial(digits); n++) {
                int pandigital = nthPandigital(n, digits);
                if(pandigital > largestPrimePandigital && isPrime(pandigital)) {
                    largestPrimePandigital = pandigital;
                }
            }
        }
        System.out.println(largestPrimePandigital);
    }

    public static int nthPandigital(int n, int numDigits) {
        if(n <= 0 || numDigits > 9 || n > factorial(numDigits)) {
            return -1;
        }

        int sum = 0;
        int[] digits = new int[numDigits];
        ArrayList<Integer> digitsList = new ArrayList<>();
        for(int i = 1; i <= numDigits; i++) {
            digitsList.add(i);
            digits[i - 1] = i;
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
        return Integer.parseInt(sb.toString());
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
