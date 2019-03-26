package euler179.main;

import java.util.HashSet;

// Terrible brute force method that makes me sad

public class Euler179 {
    public static void main(String[] args) {
        int answer = 0;

        for(int i = 1, currentNumDivisors = 0; i < 10000000; i++) {
            System.out.println("Comparing number of divisors for " + i + " and " + (i + 1));
            int nextNumDivisors = numDivisors(i + 1);

            if(currentNumDivisors == nextNumDivisors) {
                answer++;
            }

            currentNumDivisors = nextNumDivisors;
        }

        System.out.println(answer);
    }

    static int numDivisors(int n) {
        HashSet<Integer> divisors = divisors(n);
        System.out.println("\t\t" + n + "'s divisors: " + divisors);

        return divisors.size();
    }

    static HashSet<Integer> divisors(int n) {
        HashSet<Integer> foundDivisors = new HashSet<>();
        foundDivisors.add(1);
        foundDivisors.add(n);

        for(int i = (int)Math.ceil(Math.sqrt(n)); i >= 2; i--) {
            if(foundDivisors.contains(i)) {
                continue;
            }

            if(n % i == 0) {
                foundDivisors.add(i);
                foundDivisors.add(n / i);
            }
        }

        return foundDivisors;
    }
}