package com.sage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer;
        int consecutive = 4; // Consecutive is the number of consecutive numbers to look for, as well as the number of primes each number must have
        int start = 1;

        HashMap[] factorsList = new HashMap[consecutive];
        for(int i = 0; i < consecutive; i++) {
            factorsList[i] = primeFactorize(start + i);
        }

        for(int i = start; ; i++) {
            System.out.println("Checking " + i);

            if(factorsListSizeAllEquals(factorsList, consecutive) && hasDistinctFactors(factorsList)) {
                answer = i;
                break;
            }

            for(int j = 0; j < consecutive - 1; j++) {
                factorsList[j] = factorsList[j + 1];
            }
            factorsList[consecutive - 1] = primeFactorize(i + consecutive);
        }

        System.out.println(answer);
    }

    public static boolean factorsListSizeAllEquals(HashMap<String, Integer>[] factorsList, int size) {
        for(HashMap<String, Integer> factors : factorsList) {
            if(factors.size() != size) {
                return false;
            }
        }
        return true;
    }

    public static boolean hasDistinctFactors(HashMap<String, Integer>[] factorsList) {
        HashSet<String> keys = new HashSet<>();

        for(HashMap<String, Integer> factors : factorsList) {
            Set<String> set = factors.keySet();
            for(String key : set) {
                if(factors.get(key) > 0) {
                    keys.add(key);
                }
            }
        }

        for(String key : keys) {
            ArrayList<Integer> values = new ArrayList<>();
            for(HashMap<String, Integer> factors : factorsList) {
                if(factors.keySet().contains(key)) {
                    if(values.contains(factors.get(key)) && factors.get(key) > 0) {
                        return false;
                    } else {
                        values.add(factors.get(key));
                    }
                }
            }
        }
        return true;
    }

    public static HashMap<String, Integer> primeFactorize(int n) {
        if(isPrime(n)) {
            HashMap<String, Integer> factorizationMap = new HashMap<>();
            factorizationMap.put(n + "", 1);
            return factorizationMap;
        }

        int factorizeNum = n;
        HashMap<String, Integer> factors = new HashMap<>();

        int prime = 2;
        int power = 0;
        while(true) {
            if(factorizeNum % prime == 0) {
                power++;
                factorizeNum /= prime;
            } else {
                factors.put(prime + "", power);
                power = 0;
                prime = generateNextPrime(prime);
                if(factorizeNum == 1) {
                    break;
                }
            }
        }

        ArrayList<String> toBeRemoved = new ArrayList<>();
        for(String key : factors.keySet()) {
            if(factors.get(key) == 0) {
                toBeRemoved.add(key);
            }
        }
        for(String key : toBeRemoved) {
            factors.remove(key);
        }

        return factors;
    }

    private static int generateNextPrime(int n) {
        for(int i = n + 1; ; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
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
