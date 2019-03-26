package euler114.main;

public class Euler114 {

    public static void main(String[] args) {
        System.out.println(numCombinationsOneBlockApart(50));
    }

    private static long numCombinationsOneBlockApart(int numBlackBlocks) {
        // This bullshit is to account for the case where no tiles are replaced
        return numCombinationsOneBlockApartRecurse(numBlackBlocks) + 1;
    }

    private static long numCombinationsOneBlockApartRecurse(int numBlackBlocks) {
        long answer = 0;

        for(int oblongTileLength = 3; oblongTileLength <= numBlackBlocks; oblongTileLength++) {
            answer += numBlackBlocks - oblongTileLength + 1;

            for(int i = numBlackBlocks - oblongTileLength - 1; i > 0; i--) {
                answer += numCombinationsOneBlockApartRecurse(i);
            }
        }

        return answer;
    }
}
