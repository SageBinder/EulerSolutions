package solutions.euler21.java.main;

public class Main {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 0; i < 10000; i++) {
            if(hasAmicablePartner(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static int sumOfDivisors(int n) {
        int sum = 0;
        for(int i = 1; i < Math.sqrt(n) + 1; i++) {
            if(n % i == 0) {
                sum += i;
                if(i != 1) {
                    sum += (n / i);
                }
            }
        }
        return sum;
    }

    // Returns -1 if there is none
    public static boolean hasAmicablePartner(int a) {
        int b = sumOfDivisors(a);
        return (sumOfDivisors(b) == a) && (sumOfDivisors(a) == b) && (a != b);
    }
}
