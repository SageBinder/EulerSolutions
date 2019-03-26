package euler16.main;

import java.math.BigInteger;

public class Euler16 {
    static BigInteger number = new BigInteger("1");
    static String numberString;
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            number = number.multiply(new BigInteger("2"));
        }
        numberString = number.toString();

        int sum = 0;
        for(int i = 0; i < numberString.length(); i++) {
            char currentChar = numberString.charAt(i);

            sum += Integer.parseInt(currentChar + "");
        }
        System.out.println(sum);
    }
}
