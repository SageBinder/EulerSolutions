package solutions.euler40.java.main;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 1000000; i++) {
            sb.append(Integer.toString(i));
        }
        int product = 1;
        for(int i = 1; i <= 1000000; i *= 10) {
            product *= Integer.parseInt(sb.charAt(i - 1) + "");
        }
        System.out.println(product);
    }
}
