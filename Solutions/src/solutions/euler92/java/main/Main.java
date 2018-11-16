package solutions.euler92.java.main;

public class Main {
    public static void main(String[] args) {
        int answer = 0;

        for(int i = 1; i < 10000000; i++) {
            int num = i;
            while(true) {
                num = addSquareOfDigits(num);
                if(num == 89) {
                    answer++;
                    break;
                }
                if(num == 1) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    public static int addSquareOfDigits(int n) {
        String nString = Integer.toString(n);
        int sum = 0;

        for(char c : nString.toCharArray()) {
            sum += Math.pow(Integer.parseInt(c + ""), 2);
        }
        return sum;
    }
}
