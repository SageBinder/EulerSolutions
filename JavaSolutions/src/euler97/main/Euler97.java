package euler97.main;

import java.math.BigInteger;

public class Euler97 {

    public static void main(String[] args) {
        BigInteger n = new BigInteger("2");
        n = n.pow(7830457);
        n = n.multiply(new BigInteger("28433"));
        n = n.add(new BigInteger("1"));
        System.out.println(n.toString().substring(n.toString().length() - 10));
    }
}
