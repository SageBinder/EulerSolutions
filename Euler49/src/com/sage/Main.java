package com.sage;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> primes = generatePrimesUnder(10000);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < primes.size() - 1; i++) {
            for(int j = i + 1; j < primes.size(); j++) {
                int difference = primes.get(j) - primes.get(i);

                int[] sequence = new int[3];
                sequence[0] = primes.get(i);
                sequence[1] = primes.get(j);
                sequence[2] = primes.get(j) + difference;

                if(allPermutations(sequence) && allPrime(sequence)) {
                    sb.append("Answer: ").append(sequence[0]).append(" ");
                    sb.append(sequence[1]).append(" ");
                    sb.append(sequence[2]).append("\n\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean allPermutations(int[] numbers) {
        for(int i = 0; i < numbers.length - 1; i++ ) {
            if(!(Integer.toString(numbers[i]).length() == Integer.toString(numbers[i + 1]).length())) {
                return false;
            }
        }

        int numLength = Integer.toString(numbers[0]).length();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numLength; j++) {
                char currentDigit = Integer.toString(numbers[i]).charAt(j);
                for(int k = 0; k < numbers.length; k++) {
                    if(!Integer.toString(numbers[k]).contains(currentDigit + "")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static ArrayList<Integer> generatePrimesUnder(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        for(int i = 2; i < n; i++) {
            if(isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean allPrime(int[] numbers) {
        for(int num : numbers) {
            if(!isPrime(num)) {
                return false;
            }
        }
        return true;
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
