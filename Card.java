package proj4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * models a playing card
 */

public class Card {
    private int rank;
    private String suit;
    public static final ArrayList<String> ALL_RANKS_STRING = new ArrayList<>(Arrays.asList("two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"));

    /**
     * non-default constructor with int rank and int suit
     * @param newRank  integer from 2-14 (14=Ace)
     * @param newSuit  integer : 0=Spades, 1=Hearts, 2=Clubs, 3=Diamonds
     */
    public Card(int newRank, int newSuit) {
        rank = newRank;
        suit = Deck.SUITS[newSuit];
    }

    /**
     * non-default constructor with String rank and String suit
     * @param newRank String: whole cards(2-10) can be spelled either "2" or "two"
     * @param newSuit String: "Spades", "Hearts", "Clubs", "Diamonds"
     */
    public Card(String newRank, String newSuit ){
        rank = convertInt(newRank);
        suit = newSuit;
    }

    /**
     * non-default constructor with int rank and String suit
     * @param newRank integer from 2-14 (14=Ace)
     * @param newSuit String: "Spades", "Hearts", "Clubs", "Diamonds"
     */
    public Card(int newRank, String newSuit){
        rank = newRank;
        suit = newSuit;
    }

    /**
     * getter for rank
     * @return int between 2-14
     */
    public int getRank(){
        return rank;
    }

    /**
     * getter for suit
     * @return suit fully written out like "Diamonds"
     */
    public String getSuit() {
        return suit;
    }

    /**
     * return the card as a printable string
     * like "Jack of Clubs"
     * @return printable string
     */
    public String toString() {
        return convertFace(rank)+ " of " +
                getSuit();
    }

    /**
     * take numeric rank and turn it into
     * a printable string where 11-14 are
     * turned into Face card values
     */
    private String convertFace(int rank){
        if (rank == 11){
            return "Jack";
        }
        else if (rank == 12) {
            return "Queen";
        }
        else if (rank == 13) {
            return "King";
        }
        else if (rank == 14) {
            return "Ace";
        }
        else {
            return "" + rank;
        }
    }

    /**
     * take String rank like "two" or "2" and
     * return int 2-14
     */
    private int convertInt(String rank){
        String rankLowerCase= rank.toLowerCase();
        if (ALL_RANKS_STRING.contains(rankLowerCase)){
            return (ALL_RANKS_STRING.indexOf(rankLowerCase))+2;
        }
        else{
            return Integer.parseInt(rank);
        }
    }
}

