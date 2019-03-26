package euler117.main;

public class Euler117 {

    private static long[] numPossibilitiesArray = new long[50];

    public static void main(String[] args) {
        System.out.println(numPossibilities(50));
    }

    private static long numPossibilities(int numBlackTiles) {
        // Once again, this shit accounts for the possibility of 0 black tiles being replaced
        return numPossibilitiesRecurse(numBlackTiles) + 1;
    }

    private static long numPossibilitiesRecurse(int numBlackTiles) {
        if(numBlackTiles < 2) {
            return 0;
        }
        if(numPossibilitiesArray[numBlackTiles - 1] > 0) {
            return numPossibilitiesArray[numBlackTiles - 1];
        }

        long sum = 0;
        // i is the length of the oblong tile
        // n iterates through all of the possible numbers of black tiles remaining after replacing some with current oblong tile
        for(int i = 2; i <= 4 && i <= numBlackTiles; i++) {
            int remainingBlackTiles = numBlackTiles - i;
            sum += remainingBlackTiles + 1; // This is just the number of possible combinations for only one oblong tile

            for(int n = 2; n <= remainingBlackTiles; n++) {
                long toAdd = numPossibilitiesRecurse(n);
                sum += toAdd;
                numPossibilitiesArray[n - 1] = toAdd;
            }
        }

        System.out.println("Checking numBlackTiles: " + numBlackTiles + ", sum so far: " + sum);
        return sum;
    }
}
