package SaggiTrash.Euler54.main;

public enum HandRank {
    HIGH_CARD,
    ONE_PAIR,
    TWO_PAIRS,
    THREE_OF_A_KIND,
    STRAIGHT,
    FLUSH,
    FULL_HOUSE,
    FOUR_OF_A_KIND,
    STRAIGHT_FLUSH,
    ROYAL_FLUSH;



    public static int getRank(HandRank rank) {
        switch(rank) {
            case HIGH_CARD: return 0;
            case ONE_PAIR: return 1;
            case TWO_PAIRS: return 2;
            case THREE_OF_A_KIND: return 3;
            case STRAIGHT: return 4;
            case FLUSH: return 5;
            case FULL_HOUSE: return 6;
            case FOUR_OF_A_KIND: return 7;
            case STRAIGHT_FLUSH: return 8;
            case ROYAL_FLUSH: return 9;
            default: return -1;
        }
    }
}
