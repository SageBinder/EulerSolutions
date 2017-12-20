package SaggiTrash.Euler145.main;

public class Main {
    public static boolean[] checked = new boolean[1000000000];

    public static void main(String[] args) {
        long totalStartTime = System.nanoTime();
        long startTime = System.nanoTime();
        long stopTime;
        long averageTime;
        long timeSum = 0;
        int sum = 0;
        for(int i = 0; i < 1000000000; i++) {
            if(!checked[i]) {
                System.out.println("Checking: " + i);
                int reverse = reverse(i);
                if(isReversible(i, reverse)) {
                    if(reverse > i) {
                        checked[reverse] = true;
                    }
                    sum += 2;
                }
            } else {
                System.out.println("Skipping: " + i);
            }
            stopTime = System.nanoTime();
            timeSum += stopTime - startTime;
            averageTime = timeSum / (i + 1);
            System.out.println("Average time: " + averageTime);
            startTime = stopTime;
        }
        long totalStopTime = System.nanoTime();
        System.out.println(sum + ", total run time (in nanoseconds): " + (totalStopTime - totalStartTime));
    }

    public static boolean isReversible(int n, int reverse) {
        return n % 10 != 0 && reverse % 10 != 0 && allDigitsOdd(n + reverse);
    }

    public static int reverse(int n) {
        return Integer.parseInt(new StringBuilder(Integer.toString(n)).reverse().toString());
    }

    public static boolean allDigitsOdd(int n) {
        String numString = Integer.toString(n);

        for(char c : numString.toCharArray()) {
            if(Integer.parseInt(c + "") % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
