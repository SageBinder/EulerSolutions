package SaggiTrash.Euler113.main;

public class Main {
    // First index is numDigits, second index is firstDigit
    static long[][] decreasingMemoizedValues = new long[101][10];
    static long[][] increasingMemoizedValues = new long[101][10];

    public static void main(String[] args) {
        int numDigits = 100;

        System.out.println("Calculating number of non bouncy numbers with " + numDigits + " digits...\n");
        long startTime = System.nanoTime();
        long numNonBouncyNumbers = numNonBouncyNumbers(numDigits);
        long endTime = System.nanoTime();

        System.out.println("\nDecreasing memoized values:");
        for(int i = 0; i < decreasingMemoizedValues.length; i++) {
            for(int j = 0; j < decreasingMemoizedValues[0].length; j++) {
                if(decreasingMemoizedValues[i][j] != 0) {
                    System.out.println("numDigits = " + i + ", " + "firstDigit = " + j + ", value is " + decreasingMemoizedValues[i][j]);
                    if(j == decreasingMemoizedValues[0].length - 1) {
                        System.out.println();
                    }
                }
            }
        }

        System.out.println("\n\nIncreasing memoized values:");
        for(int i = 0; i < increasingMemoizedValues.length; i++) {
            for(int j = 0; j < increasingMemoizedValues[0].length; j++) {
                if(increasingMemoizedValues[i][j] != 0) {
                    System.out.println("numDigits = " + i + ", " + "firstDigit = " + j + ", value is " + increasingMemoizedValues[i][j]);
                    if(j == increasingMemoizedValues[0].length - 1) {
                        System.out.println();
                    }
                }
            }

        }

        System.out.printf("Took %.10f seconds\n", (double)(endTime - startTime) / 1000000000d);
        System.out.printf("The number of non-bouncy numbers below %.0f" + " is: " + numNonBouncyNumbers + "\n", Math.pow(10, numDigits));
    }

    static long numNonBouncyNumbers(int numDigits) {
        long numNonBouncy = 0;

        for(int numDigitsIter = 1; numDigitsIter <= numDigits; numDigitsIter++) {
            for(int firstDigitIter = 1; firstDigitIter <= 9; firstDigitIter++) {
                numNonBouncy += numDecreasingNumbers(numDigitsIter, firstDigitIter);
            }
        }

        for(int numDigitsIter = 2; numDigitsIter <= numDigits; numDigitsIter++) {
            for(int firstDigitIter = 1; firstDigitIter <= 9; firstDigitIter++) {
                numNonBouncy += numIncreasingNumbers(numDigitsIter, firstDigitIter);
            }
        }

        for(int i = 2; i <= numDigits; i++) {
            numNonBouncy -= 9;
        }

        return numNonBouncy;
    }

    static long numDecreasingNumbers(int numDigits, int firstDigit) {
        if(decreasingMemoizedValues[numDigits][firstDigit] != 0) {
            return decreasingMemoizedValues[numDigits][firstDigit];
        }

        if(numDigits == 1) {
            decreasingMemoizedValues[numDigits][firstDigit] = 1;
            return 1;
        }

        if(firstDigit == 0) {
            decreasingMemoizedValues[numDigits][firstDigit] = 0;
            return 0;
        }

        if(numDigits == 2) {
            decreasingMemoizedValues[numDigits][firstDigit] = firstDigit + 1;
            return firstDigit + 1;
        }

        long sum = 0;
        for(int i = 1; i <= firstDigit; i++) {
            long addVal = numDecreasingNumbers(numDigits - 1, i);
            sum += addVal;

        }
        sum++; // Add 1 for the case where the rest of the digits are all 0

        decreasingMemoizedValues[numDigits][firstDigit] = sum;
            return sum;
    }

    static long numIncreasingNumbers(int numDigits, int firstDigit) {
        if(increasingMemoizedValues[numDigits][firstDigit] != 0) {
            return increasingMemoizedValues[numDigits][firstDigit];
        }

        if(numDigits == 1) {
            decreasingMemoizedValues[numDigits][firstDigit] = 1;
            return 1;
        }

        if(firstDigit == 0) {
            increasingMemoizedValues[numDigits][firstDigit] = 0;
            return 0;
        }

        if(numDigits == 2) {
            int returnVal = 10 - firstDigit;

            increasingMemoizedValues[numDigits][firstDigit] = returnVal;
            return returnVal;
        }

        long sum = 0;
        for(int i = firstDigit; i <= 9; i++) {
            long addVal = numIncreasingNumbers(numDigits - 1, i);
            sum += addVal;

        }

        increasingMemoizedValues[numDigits][firstDigit] = sum;
        return sum;
    }

    static String repeatString(String str, int n) {
        StringBuilder newString = new StringBuilder(str);

        if(n <= 0) {
            return "";
        }

        for(int i = 0; i < n; i++) {
            newString.append(str);
        }

        return newString.toString();
    }
}