package SaggiTrash.Euler34.main;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        // I just picked a random upper bound
        for(int i = 3; i < 1000000; i++) {
            System.out.println("Checking: " + i + ", sum = " + sum);
            if(sumOfDigitsFactorial(i) == i) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static long sumOfDigitsFactorial(int n) {
        int sum = 0;
        String nString = Integer.toString(n);

        for(char c : nString.toCharArray()) {
            sum += factorial(Integer.parseInt(c + ""));
        }
        return sum;
    }

    public static long factorial(int n) {
        long factorial = 1;
        for(int i = n; i > 0; i--) {
            factorial *= i;
        }
        return factorial;
    }
}
