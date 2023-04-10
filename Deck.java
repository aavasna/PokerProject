package proj4;
import java.util.ArrayList;
import java.util.Random;

/**
 * Models a standard deck of 52 playing cards
 */

public class Deck {
    public static final int NUM_CARDS_IN_DECK = 52;
    private int nextToDeal;
    public static final int[] RANKS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    public static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private ArrayList<Card> deck = new ArrayList<>(NUM_CARDS_IN_DECK);

    /**
     * constructor that creates a deck object of 52 card objects
     */
    public Deck() {
        for (int rank: RANKS) {
            for (int i=0;i<SUITS.length;i++) {
                Card newCard = new Card(rank, i);
                deck.add(newCard);
            }
        }
        nextToDeal = 0;
    }

    /**
     * shuffles a deck
     */
    public void shuffle() {
        int totalElements = deck.size();
        Random random = new Random();
        for (int loopCounter = 0; loopCounter < totalElements; loopCounter++) {
            Card currentElement = deck.get(loopCounter);
            int randomIndex = random.nextInt(totalElements);
            deck.set(loopCounter, deck.get(randomIndex));
            deck.set(randomIndex, currentElement);
        }
    }

    /**
     * deals the next undealt card
     * @return card object or null if deck empty
     */
    public Card deal() {
        Card card_dealt;
        if (isEmpty()) {
            return null;
        }
        else {
            card_dealt = deck.get(nextToDeal);
            nextToDeal += 1;
        }
        return card_dealt;
    }

    /**
     * checks if deck is empty
     * @return true if all cards dealt, false if not
     */
    public boolean isEmpty(){
        return size()==0;
    }

    /**
     * gives number of undealt cards in a deck
     * @return int for number of undealt cards in a deck
     */
    public int size(){
        return NUM_CARDS_IN_DECK - nextToDeal;
    }

    /**
     * changes the state of a deck where all cards are undealt
     */
    public void gather(){
        nextToDeal = 0;
    }

    /**
     * returns all undealt cards in a deck as a printable string
     * @return string that shows all undealt cards in a deck
     */
    public String toString(){
        String returnString="";
        for (int loopCounter = nextToDeal; loopCounter< NUM_CARDS_IN_DECK; loopCounter++){
            returnString = returnString + " " + deck.get(loopCounter).toString();
        }
        return returnString;
    }
}
