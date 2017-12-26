package SaggiTrash.Euler54.main;

public enum Suit {
    HEARTS, CLUBS, SPADES, DIAMONDS, VOID;

    public char toString(Suit suit) {
        switch(suit) {
            case CLUBS: return 'C';
            case HEARTS: return 'H';
            case SPADES: return 'S';
            case DIAMONDS: return 'D';
            default: return ' ';
        }
    }

    public static Suit getSuitFromChar(char c) {
        switch(c) {
            case 'C': return CLUBS;
            case 'H': return HEARTS;
            case 'S': return SPADES;
            case 'D': return DIAMONDS;
            default: return VOID; // There's absolutely nothing wrong with this
        }
    }
}
