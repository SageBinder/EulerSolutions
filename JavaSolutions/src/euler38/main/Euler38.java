package euler38.main;

public class Euler38 {
    public static void main(String[] args) {
        int largestPandigital = 0;

        for(int i = 1; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();

            for(int n = 1; sb.length() < 9; n++) {
                sb.append(Integer.toString(i * n));
            }
            if(sb.length() != 9) {
                continue;
            }

            if(isPandigitalString(sb.toString())) {
                if(Integer.parseInt(sb.toString()) > largestPandigital) {
                    largestPandigital = Integer.parseInt(sb.toString());
                }
            }
        }

        System.out.println(largestPandigital);
    }

    public static boolean isPandigitalString(String nString) {
        if(nString.length() > 9) {
            return false;
        }
        for(int i = 1; i < 10; i++) {
            if(numCharOccurrences(nString, Integer.toString(i).toCharArray()[0]) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int numCharOccurrences(String str, char c) {
        int sum = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == c) {
                sum++;
            }
        }
        return sum;
    }
}
