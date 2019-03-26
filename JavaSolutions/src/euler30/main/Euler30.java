package euler30.main;

public class Euler30 {

    public static void main(String[] args) {
        int sum = 0;
        for(int i = 2; i < 1999999; i++) {
            if(sumOfDigitsFifthPower(i)) {
                sum += i;
            }
        }
        System.out.print(sum);
    }

    public static boolean sumOfDigitsFifthPower(int n) {
        String num = Integer.toString(n);
        int sum = 0;

        for(char c : num.toCharArray()) {
            sum += Math.pow(Integer.parseInt(c + ""), 5);
        }
        return sum == n;
    }
}
