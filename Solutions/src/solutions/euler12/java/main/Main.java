package solutions.euler12.java.main;

public class Main {

    public static void main(String[] args) {
        outerLoop:
        for(long i = 0; ; i++) {
            long currentTriangleNumber = getTriangularNumber(i);
            long sqrt = (long)Math.sqrt(currentTriangleNumber);

            System.out.println("Checking triangle number: " + currentTriangleNumber);
            int numDivisors = 0;
            for(long j = 1; j <= sqrt; j++) {
                System.out.println("Checking triangle number " + currentTriangleNumber + " against divisor " + j);
                if(currentTriangleNumber % j == 0) {
                    numDivisors += 2;
                }
                if(numDivisors > 500) {
                    System.out.println("currentTriangleNumber: " + currentTriangleNumber + ", " + "with " + numDivisors + " divisors");
                    break outerLoop;
                }
            }
            System.out.println(numDivisors);
        }
    }

    public static long getTriangularNumber(long n) {
        long sum = 0;
        for(long i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}