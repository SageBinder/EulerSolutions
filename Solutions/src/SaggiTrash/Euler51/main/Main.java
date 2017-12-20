package SaggiTrash.Euler51.main;

public class Main {

    public static void main(String[] args) {
        int answer;

        outerLoop:
        for(int prime = 13; ; prime = generateNextPrime(prime)) {
            for(int i = 0; i < 10; i++) {
                if(numPrimesWhenReplaced(prime, i) == 8) {
                    answer = prime;
                    break outerLoop;
                }
            }
        }

        System.out.println(answer);
    }

    public static int numPrimesWhenReplaced(int prime, int replaceNum) {
        if(!isPrime(prime)) {
            return -666;
        }

        if(!Integer.toString(prime).contains(Integer.toString(replaceNum))) {
            return 1;
        }

        int numPrimesInFamily = 1;

        for(int i = 0; i < 10; i++) {
            if(i == replaceNum) {
                continue;
            }
            int newNum = Integer.parseInt(Integer.toString(prime).replaceAll(replaceNum + "", i + ""));
            if(Integer.toString(newNum).length() != Integer.toString(prime).length()) {
                continue;
            }
            if(isPrime(newNum)) {
                numPrimesInFamily++;
            }
        }
        return numPrimesInFamily;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    private static int generateNextPrime(int n) {
        for(int i = n + 1; ; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }
}
