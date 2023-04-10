package proj4;
import java.util.ArrayList;

/**
 * models 5 community cards
 */

public class CommunityCardSet {
    public static final int NUM_COMMUNITY_CARDS = 5;
    private ArrayList<Card> communityCards;

    /**
     * non-default constructor that takes an ArrayList of Cards as a parameter
     * @param cc list of 5 community cards
     */
    public CommunityCardSet(ArrayList<Card> cc){
        communityCards = new ArrayList<>(cc);
    }

    /**
     * adds given card to community cards
     * @param givenCard Card that is to be added to community cards
     */
    public void addCard(Card givenCard){
        if (communityCards.size()< NUM_COMMUNITY_CARDS){
            communityCards.add(givenCard);
        }
    }

    /**
     * get the card based on given index
     * @param index index to get the card from
     * @return Card at given index or null if invalid
     */
    public Card getIthCard(int index){
        if (index>=0 && index<NUM_COMMUNITY_CARDS){
            return communityCards.get(index);
        }
        else{
            return null;
        }
    }

    /**
     * returns all community cards as a printable string
     * @return String representing all community cards
     */
    public String toString() {
        String printableCommunityCards = "";
        for (Card card : communityCards) {
            printableCommunityCards = printableCommunityCards + card.toString() + "   |   ";
        }
        return printableCommunityCards;
    }

    /**
     * returns the number of cards currently in the community cards
     * @return int for number of cards present in the community cards
     */
    public int size(){
        return communityCards.size();
    }
}
