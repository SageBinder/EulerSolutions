package SaggiTrash.Euler115.main;

public class Main {

    public static void main(String[] args) {
        long answer;

        for(int n = 1; ; n++) {
            System.out.println("Checking n = " + n);

            long fillCount = numCombinationsOneBlockApart(50, n);
            if(fillCount > 1000000) {
                answer = n;
                break;
            }
        }

        System.out.println("Answer: " + answer);
    }

    private static long numCombinationsOneBlockApart(int minimumOblongLength, int numBlackBlocks) {
        // This bullshit is to account for the case where no tiles are replaced
        return numCombinationsOneBlockApartRecurse(minimumOblongLength, numBlackBlocks) + 1;
    }

    private static long numCombinationsOneBlockApartRecurse(int minimumOblongLength, int numBlackBlocks) {
        long answer = 0;

        for(int oblongTileLength = minimumOblongLength; oblongTileLength <= numBlackBlocks; oblongTileLength++) {
            answer += numBlackBlocks - oblongTileLength + 1;

            for(int i = numBlackBlocks - oblongTileLength - 1; i > 0; i--) {
                answer += numCombinationsOneBlockApartRecurse(minimumOblongLength, i);
            }
        }

        return answer;
    }
}
