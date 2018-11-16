package solutions.euler60.java.main;

import javafx.util.Pair;

import java.util.*;

public class Main {

    private static TreeMap<Integer, TreeSet<Integer>> primeConcatComplements = new TreeMap<>();

    public static void main(String[] args) {
        int sum;
        long totalStartTime = System.nanoTime();

        outer:
        for(long i = generateNextPrime(1), loopStartTime = System.nanoTime(), c = 1, averageCounter = 1, printGap = 50000; ; i = generateNextPrime(i), c++) {
            HashSet<Pair<Integer, Integer>> pairs = allPrimesConcatInto(i);
            addPairsToComplementsList(pairs);

            ArrayList<Integer> seenKeys = new ArrayList<>();
            for(Pair<Integer, Integer> pair : pairs) {
                if(seenKeys.contains(pair.getKey())) {
                    continue;
                } else {
                    seenKeys.add(pair.getKey());
                }
                ArrayList<Integer> startingSet = new ArrayList<>();
                startingSet.add(pair.getKey());
                startingSet.add(pair.getValue());

                sum = smallestNPrimeSetSum(5, startingSet);
                if(sum != 0) {
                    break outer;
                }
            }

            // Timing/printing code:
            if(c % printGap == 0) {
                long loopEndTime = System.nanoTime();
                System.out.println("c = " + c + ", "
                        + "Checking concatenation possibilities for prime " + i + ",\n"
                        + "took " + (loopEndTime - loopStartTime) / 1000000000 + " seconds since last print "
                        + "(" + (loopEndTime - loopStartTime) + " nanos), \n"
                        + "total elapsed time so far: " + (loopEndTime - totalStartTime) / 1000000000 + " seconds "
                        + "(" + (loopEndTime - totalStartTime) + " nanos), \n"
                        + "average time per " + printGap + " primes so far: " + ((loopEndTime - totalStartTime) / 1000000000) / averageCounter + " seconds "
                        + "(" + (loopEndTime - totalStartTime) / averageCounter + ") nanos.\n");
                averageCounter++;
                loopStartTime = System.nanoTime();
            }
            // --------------------
        }

        long totalEndTime = System.nanoTime();
        System.out.println("Answer: " + sum
                + ", took " + (totalEndTime - totalStartTime) / 1000000000 + " seconds ("
                + (totalEndTime - totalStartTime) + " nanos).");
    }

    private static int smallestNPrimeSetSum(int n, ArrayList<Integer> currSet) {
        HashSet<Integer> intersection = intersectionOfPrimeSets(currSet);

        if(currSet.size() == n) {
            int sum = 0;
            for(Integer i : currSet) {
                sum += i;
            }
            return sum;
        }
        if(intersection.size() == 0) {
            return 0;
        }

        ArrayList<Integer> found = new ArrayList<>();
        for(Integer key : intersection) {
            ArrayList<Integer> newSet = new ArrayList<>(currSet);
            newSet.add(key);
            int sum = smallestNPrimeSetSum(n, newSet);
            found.add(sum);
        }

        return Collections.min(found);
    }

    private static HashSet<Integer> intersectionOfPrimeSets(ArrayList<Integer> keys) {
        HashSet<Integer> intersection = new HashSet<>();

        for(int i : keys) {
            if(primeConcatComplements.get(i) != null) {
                intersection.addAll(primeConcatComplements.get(i));
            }
        }
        for(int i : keys) {
            if(primeConcatComplements.get(i) != null) {
                intersection.retainAll(primeConcatComplements.get(i));
            }
        }

        return intersection;
    }

    private static void addPairsToComplementsList(HashSet<Pair<Integer, Integer>> pairs) {
        for(Pair<Integer, Integer> p : pairs) {
            if(!primeConcatComplements.containsKey(p.getKey())) {
                primeConcatComplements.put(p.getKey(), new TreeSet<>());
            }
            primeConcatComplements.get(p.getKey()).add(p.getValue());
        }
    }

    private static HashSet<Pair<Integer, Integer>> allPrimesConcatInto(long n) {
        String nString = Long.toString(n);
        HashSet<Pair<Integer, Integer>> allPrimePairs = new HashSet<>();

        for(int i = 1; i < nString.length(); i++) {
            if(nString.charAt(i) == '0') { // This if statement prevents numbers like 1307 from from adding 13 and 7
                continue;
            }

            int n1 = Integer.parseInt(nString.substring(0, i));
            int n2 = Integer.parseInt(nString.substring(i, nString.length()));
            if(isPrime(n1) && isPrime(n2) && isPrime(Long.parseLong(n2 + "" + n1))) {
                allPrimePairs.add(new Pair<>(n1, n2));
                allPrimePairs.add(new Pair<>(n2, n1));
            }
        }

        return allPrimePairs;
    }

    private static long generateNextPrime(long n) {
        for(long i = n + (n % 2) + 1; ; i += 2) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (long i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}
