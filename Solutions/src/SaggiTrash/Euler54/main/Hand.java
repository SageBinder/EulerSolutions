package SaggiTrash.Euler54.main;

import java.util.Arrays;

public class Hand {
    private final Card[] cards = new Card[5]; // This will be sorted
    private HandRank rank;
    private int firstCompareRankValue;
    private int secondCompareRankValue;

    public Hand(String[] cardStrings) {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(cardStrings[i].charAt(0), Suit.getSuitFromChar(cardStrings[i].charAt(1)));
        }
        calculateRank();
    }

    private void calculateRank() {
        int foundRankValue;

        foundRankValue = straightFlushValue();
        if(foundRankValue == 10) {
            rank = HandRank.ROYAL_FLUSH;
            firstCompareRankValue= foundRankValue;
            return;
        } else if(foundRankValue > 0) {
            rank = HandRank.STRAIGHT_FLUSH;
            firstCompareRankValue= foundRankValue;
            return;
        }

        foundRankValue = fourOfAKindValue();
        if(foundRankValue > 0) {
            rank = HandRank.FOUR_OF_A_KIND;
            firstCompareRankValue= foundRankValue;
            return;
        }

        int fullHousePairValue = fullHousePairValue();
        int fullHouseThreeValue = fullHouseThreeValue();
        if(fullHousePairValue > 0) {
            rank = HandRank.FULL_HOUSE;
            firstCompareRankValue = fullHouseThreeValue;
            secondCompareRankValue = fullHousePairValue;
            return;
        }

        foundRankValue = flushValue();
        if(foundRankValue > 0) {
            rank = HandRank.FLUSH;
            firstCompareRankValue = foundRankValue;
            return;
        }

        foundRankValue = straightValue();
        if(foundRankValue > 0) {
            rank = HandRank.STRAIGHT;
            firstCompareRankValue = foundRankValue;
            return;
        }

        foundRankValue = threeOfAKindValue();
        if(foundRankValue > 0) {
            rank = HandRank.THREE_OF_A_KIND;
            firstCompareRankValue = foundRankValue;
            return;
        }

        int twoPairsHighValue = twoPairsHighValue();
        int twoPairsLowValue = twoPairsLowValue();
        if(twoPairsHighValue > 0) {
            rank = HandRank.TWO_PAIRS;
            firstCompareRankValue = twoPairsHighValue;
            secondCompareRankValue = twoPairsLowValue;
            return;
        }

        foundRankValue = onePairValue();
        if(foundRankValue > 0) {
            rank = HandRank.ONE_PAIR;
            firstCompareRankValue = foundRankValue;
            return;
        }

        foundRankValue = highCardValue();
        rank = HandRank.HIGH_CARD;
        firstCompareRankValue = foundRankValue;
    }

    private int straightFlushValue() {
        Suit firstSuit = cards[0].getSuit();
        int firstValue = cards[0].getValue();
        for(int i = 0; i < cards.length; i++) {
            if (!(cards[i].getValue() == firstValue + i && cards[i].getSuit() == firstSuit)) {
                return 0;
            }
        }

        return firstValue;
    }

    private int fourOfAKindValue() {
        for(int i = 2; i < 15; i++) {
            if(valueCount(i) == 4) {
                return i;
            }
        }

        return 0;
    }

    private int fullHousePairValue() {
        if(!isFullHouse()) {
            return 0;
        }

        return onePairValue();
    }

    private int fullHouseThreeValue() {
        if(!isFullHouse()) {
            return 0;
        }

        return threeOfAKindValue();
    }

    private boolean isFullHouse() {
        return threeOfAKindValue() > 0 && onePairValue() > 0;
    }

    private int flushValue() {
        Suit firstSuit = cards[0].getSuit();

        for(int i = 0; i < cards.length; i++) {
            if(cards[i].getSuit() != firstSuit) {
                return 0;
            }
        }

        return
    }

    private int straightValue() {

    }

    private int threeOfAKindValue() {
        for(int i = 2; i < 15; i++) {
            if(valueCount(i) == 3) {
                return i;
            }
        }

        return 0;
    }

    private int twoPairsHighValue() {

    }

    private int twoPairsLowValue() {

    }

    private int onePairValue() {

    }

    private int highCardValue() {
        int highValue = 0;
        for(Card card : cards) {
            if(card.getValue() > highValue) {
                highValue = card.getValue();
            }
        }

        return highValue;
    }

    private Card lowCard() {
        Card[] values = new Card[5];

        System.arraycopy(cards, 0, values, 0, cards.length);

        Arrays.sort(values);
        return values[0];
    }

    public int valueCount(int value) {
        int count = 0;
        for(Card card : cards) {
            if(card.getValue() == value) {
                count++;
            }
        }

        return count;
    }

    public int suitCount(Suit suit) {
        int count = 0;
        for(Card card : cards) {
            if(card.getSuit() == suit) {
                count++;
            }
        }

        return count;
    }

    public Card[] getCardsList() {
        return cards;
    }

    public HandRank getRank() {
        return rank;
    }
}
