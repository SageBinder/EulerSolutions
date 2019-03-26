package euler46.main;

public class Euler46 {

    public static void main(String[] args) {
        int num = 1;
        do {
            num += 2;
            while(isPrime(num)) {
                num += 2;
            }
            System.out.println("Checking: " + num);
        } while(sumOfPrimeAndTwiceSquare(num));
        System.out.print(num);
    }
    public static boolean sumOfPrimeAndTwiceSquare(int n) {
        for(int currPrime = 2; currPrime < n; currPrime = nextPrime(currPrime)) {
            int sum = currPrime;
            for(int currSquare = 0; sum < n; currSquare++, sum = currPrime + (int)(2 * Math.pow(currSquare, 2)));
            if(sum == n) {
                return true;
            }
        }
        return false;
    }
    private static int nextPrime(int num) {
        int i;
        for(i = num + 1; !isPrime(i); i++);
        return i;
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
