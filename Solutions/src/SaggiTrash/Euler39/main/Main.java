package SaggiTrash.Euler39.main;

public class Main {

    public static void main(String[] args) {
        int greatestNumSolutions = 0;
        int greatestP = 0;
        for(int p = 1; p <= 1000; p++) {
            int numSolutions = 0;
            for(int a = 0; a < p; a++) {
                for(int b = a; b < p - a; b++) {
                    int c = p - a - b;
                    if(isRightTriangleSolution(a, b, c)) {
                        numSolutions++;
                    }
                }
            }

            if(numSolutions > greatestNumSolutions) {
                greatestP = p;
                greatestNumSolutions = numSolutions;
            }
        }
        System.out.println(greatestP + ", " + greatestNumSolutions);
    }

    public static boolean isRightTriangleSolution(int a, int b, int c) {
        return a != 0 && b != 0 && c != 0 && Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2);
    }
}
