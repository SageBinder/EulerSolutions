package SaggiTrash.Euler54.main;

public class Card {
    private int value;
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public String toString() {
        switch(value) {
            case 10: return "T" + suit.toString();
            case 11: return "J" + suit.toString();
            case 12: return "Q" + suit.toString();
            case 13: return "K" + suit.toString();
            case 14: return "A" + suit.toString();
            default: return value + "" + suit.toString();
        }
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
}
