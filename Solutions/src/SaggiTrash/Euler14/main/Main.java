package SaggiTrash.Euler14.main;

public class Main {

    public static void main(String[] args) {
        int longestChainNumber = 0;
        long longestChainLength = 0;

        for(int i = 0; i < 1000000; i++) {
            long chainLength = collatzChainLength(i);
            if(chainLength > longestChainLength) {
                longestChainLength = chainLength;
                longestChainNumber = i;
            }
        }

        System.out.print(longestChainNumber);
    }

    public static long collatzChainLength(int n) {
        long chainLength = 0;
        long currentNumber = n;

        if(n <= 0) {
            return 0;
        }

        while(true) {
            if(currentNumber == 1) {
                System.out.println("for number " + n + ", chain length is " + chainLength);
                return chainLength;
            }
            if(currentNumber % 2 == 0) {
                currentNumber /= 2;
            } else {
                currentNumber = (3 * currentNumber) + 1;
            }
            chainLength++;
        }
    }
}
