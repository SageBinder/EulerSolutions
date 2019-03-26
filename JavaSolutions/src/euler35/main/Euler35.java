package euler35.main;

public class Euler35 {

    public static void main(String[] args) {
        int sum = 0;

        for(int i = 0; i < 1000000; i++) {
            if(allPrime(getRotations(i))) {
                sum++;
            }
        }
        System.out.print(sum);
    }

    public static boolean allPrime(int[] numbers) {
        for(int n : numbers) {
            if(!isPrime(n)) {
                return false;
            }
        }
        return true;
    }

    public static int[] getRotations(int n) {
        int numRotations = Integer.toString(n).length();
        int[] rotations = new int[numRotations];

        int currentNum = n;
        for(int i = 0; i < numRotations; i++) {
            rotations[i] = currentNum;
            currentNum = rotate(currentNum);
        }

        return rotations;
    }

    public static int rotate(int num) {
        String str = Integer.toString(num);

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(str.length() - 1));
        sb.append(str.substring(0, str.length() - 1));

        return Integer.parseInt(sb.toString());
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }
}
