package SaggiTrash.Euler23.main;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static ArrayList<Integer> abundantNumbers = new ArrayList<>();

    public static void main(String[] args) {
        findAbundantNumbers();
        int sum = 0;
        for(int i = 0; i < 28123; i++) {
            if(!isSumOfTwoAbundantNumbers(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static void findAbundantNumbers() {
        for(int i = 1; i < 28123; i++) {
            if(isAbundantNumber(i)) {
                abundantNumbers.add(i);
            }
        }
    }

    public static boolean isAbundantNumber(int n) {
        ArrayList<Integer> divisorsList = new ArrayList<Integer>();
        int sum = 1;
        double sqrt = Math.sqrt(n);
        for(int i = 2; i <= sqrt; i++) {
            if(i == sqrt) {
                sum += i;
                divisorsList.add(i);
                continue;
            }
            if(n % i == 0) {
                sum += i;
                sum += n / i;
                divisorsList.add(i);
                divisorsList.add(n / i);
            }
        }
        Collections.sort(divisorsList);
        System.out.println(n + ": " + divisorsList.toString() + ", sum: " + sum + ", abundant: " + (sum > n));
        return sum > n;
    }

    public static boolean isSumOfTwoAbundantNumbers(int n) {
        if(Collections.binarySearch(abundantNumbers, n / 2) >= 0 && n % 2 == 0) {
            return true;
        }

        int complement;
        int currAbundantNum = abundantNumbers.get(0);
        for(int i = 0; currAbundantNum <= n / 2 && i < abundantNumbers.size(); i++) {
            currAbundantNum = abundantNumbers.get(i);
            complement = n - currAbundantNum;
            if(Collections.binarySearch(abundantNumbers, complement) >= 0) {
                return true;
            }
        }
        return false;
    }
}
