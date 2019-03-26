package euler20.main;

import java.math.BigInteger;

public class Euler20 {
    public static void main(String[] args) {
        BigInteger factorial = new BigInteger("100");
        factorial = factorial(factorial);

        String factorialString = factorial.toString();
        long digitsSum = 0;
        for(char c : factorialString.toCharArray()) {
            digitsSum += Integer.parseInt(c + "");
        }

        System.out.println(digitsSum);
    }

    static BigInteger factorial(BigInteger factorial) {
        if(factorial.intValue() == 1) {
            return new BigInteger("1");
        }
        return factorial.multiply(factorial(factorial.subtract(new BigInteger("1"))));
    }
}
