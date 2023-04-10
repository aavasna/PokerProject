package proj4;

import java.util.ArrayList;

/**
 * models a 2-card poker hand that also has access to the community cards
 */

public class StudPokerHand {
    public static final int NUM_HAND_CARDS = 2;
    public static final int NUM_TOTAL_CARDS = 7;
    private CommunityCardSet communityCards;
    private ArrayList<Card> studHand;

    /**
     * constructor
     * @param cc CommunityCardSet of all community cards
     * @param cardList List for hole cards
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardList){
        communityCards = cc;
        studHand = new ArrayList<>(cardList);
    }

    /**
     * get the card based on given index
     * @param index index to get the card from
     * @return Card at given index or null if invalid
     */
    public Card getIthCard(int index) {
        if (index>=0 && index<NUM_HAND_CARDS){
            return studHand.get(index);
        }
        else{
            return null;
        }
    }

    /**
     * returns the hole cards and community cards as a printable string
     * @return String representing hole and community cards
     */
    public String toString(){
        String printableHand = "";
        printableHand = printableHand + communityCards.toString()+ "\n";
        for (Card card: studHand){
            printableHand = printableHand + card.toString();
        }
        return printableHand;
    }

    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can
     * make. Returns positive, negative, or zero depending on the comparison. *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(StudPokerHand other){
        PokerHand thisHand= this.getBestFiveCardHand();
        PokerHand otherHand = other.getBestFiveCardHand();
        return thisHand.compareTo(otherHand);
    }

    /**
     * Creates all combinations of 5 cards out of 7 cards using
     * both hole and community cards
     * @return ArrayList of Pokerhands where each PokerHand is a new combination of 5 cards
     */
    private ArrayList<PokerHand> getAllFiveCardHands(){
        ArrayList<Card> AllSevenCardHand = new ArrayList<>(studHand);
        ArrayList<PokerHand> AllFiveCardHands = new ArrayList<>();
        for (int i=0; i< CommunityCardSet.NUM_COMMUNITY_CARDS; i++){
            AllSevenCardHand.add(communityCards.getIthCard(i));
        }
        for (int i=0; i < NUM_TOTAL_CARDS; i++){
            for (int j= i+1 ; j < NUM_TOTAL_CARDS; j++){
                ArrayList<Card> AllSevenCardHandCopy= new ArrayList<>(AllSevenCardHand);
                AllSevenCardHandCopy.remove(j);
                AllSevenCardHandCopy.remove(i);
                PokerHand newHand = new PokerHand(AllSevenCardHandCopy);
                AllFiveCardHands.add(newHand);
            }
        }
        return AllFiveCardHands;
    }

    /**
     * get the best five card hard out of all combinations generated
     * from 5 community cards and two hole cards
     * @return Pokerhand that is the best combination of 5 cards
     */
    private PokerHand getBestFiveCardHand(){
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++ ){
            if (hands.get(i).compareTo(bestSoFar)>0){
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }
}
