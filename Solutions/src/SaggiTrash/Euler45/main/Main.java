package SaggiTrash.Euler45.main;

public class Main {
    public static void main(String[] args) {
        long foundNum;

        long currHex = 2 * ((2 * 2) - 1);
        for(long n = 2; ; n++) {
            long currPent = (n * ((3 * n) - 1)) / 2;

            if(currPent == 40755) {
                continue;
            }
            if(isHexagonal(currPent)) {
                foundNum = currPent;
                break;
            }
        }

        System.out.println(foundNum);
    }

    public static boolean isHexagonal(long n) {
        for(long i = 1; (i * ((3 * i) - 1)) / 2 <= n; i++) {
            if(i * ((2 * i) - 1) == n) {
                return true;
            }
        }
        return false;
    }
}
