package SaggiTrash.Euler24.main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        int[] digits = new int[10];
        ArrayList<Integer> digitsList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            digitsList.add(i);
        }

        for(int i = 0; i < digits.length; i++) {
            digits[i] = i;
        }

        for(int i = 10, c = 0; i > 0; i--, c++) {
            int factorial = factorial(i);
            int factorialOverI = factorial / i;
            int nextDigitIndex = 0;
            while(sum + factorialOverI < 1000000) {
                sum += factorialOverI;
                nextDigitIndex++;
            }
            digits[c] = digitsList.get(nextDigitIndex);
            digitsList.remove(nextDigitIndex);
        }
        for(int i = 0; i < digits.length; i++) {
            System.out.print(digits[i]);
        }
    }

    public static int factorial(int n) {
        int factorial = 1;
        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
