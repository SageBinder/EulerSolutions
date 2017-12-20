package SaggiTrash.Euler32.main;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        long sum = 0;
        ArrayList<Integer> seen = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            for(int j = 1000; j < 10000; j++) {
                int product = i * j;
                if(equationIsPandigital(i, j, product) && !seen.contains(product)){
                    seen.add(product);
                    sum += product;
                }
            }
        }
        for(int i = 10; i < 100; i++) {
            for(int j = 100; j < 1000; j++) {
                int product = i * j;
                if(equationIsPandigital(i, j, product) && !seen.contains(product)){
                    seen.add(product);
                    sum += product;
                }
            }
        }

        System.out.println(sum);
    }

    public static boolean equationIsPandigital(int a, int b, long c) {
        String equationString = Integer.toString(a) + Integer.toString(b) + Long.toString(c);
        if(equationString.length() != 9) {
            return false;
        }
        for(int i = 1; i < 10; i++) {
            int count = equationString.length() - equationString.replace(Integer.toString(i), "").length();
            if(count != 1) {
                return false;
            }
        }
        return true;
    }
}
