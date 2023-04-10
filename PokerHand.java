package proj4;
import java.util.*;

/**
 * models a poker hand of 5 cards
 */

public class PokerHand {
    private ArrayList<Card> hand ;

    /**
     * non-default constructor that takes an ArrayList of Cards as a parameter
     * @param cardList a list of 5 cards in hand
     */
    public PokerHand(ArrayList<Card> cardList){
        hand = new ArrayList<>(cardList);
    }
    public void addCard(Card givenCard){
        if (hand.size()< 5){
            hand.add(givenCard);
        }
    }

    /**
     * get the card based on given index
     * @param index index from which card is to be returned
     * @return card at given index or null if invalid
     */
    public Card getIthCard(int index){
        if (index>=0 && index<Deck.NUM_CARDS_IN_DECK){
            return hand.get(index);
        }
        else{
            return null;
        }
    }

    /**
     * returns all cards in a poker hand as a printable string
     * @return printable string
     */
    public String toString(){
        String printableHand = "";
        for (Card card: hand){
            printableHand = printableHand + "\n" + card.toString();
        }
        return printableHand;
    }

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison. *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(PokerHand other){
        if (this.identicalTo(other)){
            return 0;
        }
        int rankCompared = compareRankTo(other);
        if (rankCompared==0){
            String category = this.categorize();
            if (category.equals("PAIR") || category.equals("TWO PAIR")){
                return this.comparePair(other);}
            else{
                return this.compareHighCards(other);}}
        else {return rankCompared;}
    }

    /**
     * checks if two hands are identical
     * @param other hand 2
     * @return True if identical, False if not
     */
    private boolean identicalTo(PokerHand other){
        Set handSet = Set.copyOf(this.hand);
        Set otherSet = Set.copyOf(other.hand);
        return handSet.equals(otherSet);
    }

    /**
     * given the hand, determines rank and returns it
     * @return string for rank of hand e.g. "TWO PAIR"
     */
    public String categorize(){
        if (this.isFlush()){
            return "FLUSH";
        }
        else if (pairCount() == 2){
            return "TWO PAIR";
        }
        else if (pairCount() == 1){
            return "PAIR";
        }
        else{
            return "HIGH CARD";
        }
    }

    /**
     * checks if the given hand is a flush
     * @return True if given hand is flush, False if not
     */
    private boolean isFlush(){
        ArrayList<String> cardSuitList = new ArrayList<>();
        for (Card card : this.hand){
            cardSuitList.add(card.getSuit());
        }
        int i=0;
        boolean sameSuit = true;
        String firstSuit = cardSuitList.get(0);
        while ((i < cardSuitList.size()) && sameSuit){
            if (!(cardSuitList.get(i).equals(firstSuit))){
                sameSuit = false;
            }
            i+=1;
        }
        return sameSuit;
    }

    /**
     * counts the number of pairs in a hand
     * @return  int for number of pairs in a hand
     */
    private int pairCount(){
        ArrayList<Integer> cardRankList;
        ArrayList<Integer> pairList = new ArrayList<>();
        int numPair=0;
        cardRankList = getRankList();
        for (Integer rank: cardRankList){
            if ((Collections.frequency(cardRankList, rank)>=2) && (!pairList.contains(rank))){
                numPair+= (Collections.frequency(cardRankList, rank)) / 2 ;
                pairList.add(rank);
            }
        }
        return numPair;
    }

    /**
     * checks if two hands are of same category rank
     * @param other hand 2
     * @return true if same category rank, false if not
     */
    private boolean rankEqualTo(PokerHand other){
        String handRank = this.categorize();
        String otherRank = other.categorize();
        return handRank.equals(otherRank);
    }

    /**
     * compares ranks of hands and returns an int which is 1 or -1 depending on comparison
     * @param other second hand to compare
     * @return 1 if rank of self is higher than other, -1 if rank of other is higher than self, 0 if equal
     */
    private int compareRankTo(PokerHand other) {
        ArrayList<String> categoryRank = new ArrayList<>();
        categoryRank.add("HIGH CARD");
        categoryRank.add("PAIR");
        categoryRank.add("TWO PAIR");
        categoryRank.add("FLUSH");
        String handRank = this.categorize();
        String otherRank = other.categorize();
        return Integer.compare(categoryRank.indexOf(handRank),categoryRank.indexOf(otherRank) );
    }

    /**
     * given a hand, gives all the ranks of the cards in a hand
     * @return Arraylist of type Integer with ranks of cards of given hand
     */
    private ArrayList<Integer> getRankList(){
        ArrayList<Integer> rankList = new ArrayList<>();
        for (Card card1 : this.hand){
            rankList.add(card1.getRank());
        }
        return rankList;
    }

    /**
     * given ranks of all cards in a hand, returns rank of pair cards
     * @param rankList Arraylist of ranks of all cards in a hand
     * @return Arraylist of rank of all pair cards in a hand
     */
    private ArrayList<Integer> getPairList(ArrayList<Integer> rankList){
        ArrayList<Integer> pairList = new ArrayList<>();
        for (Integer rank1 : rankList) {
            int count= Collections.frequency(rankList, rank1);
            if (count >= 2 && !pairList.contains(rank1)){
                for (int i=0; i< count / 2; i++){
                    pairList.add(rank1);
                }
            }
        }
            return pairList;
    }

    /**
     * given ranks of all cards in a hand, returns rank of pair cards
     * @param rankList Arraylist of ranks of all cards in a hand
     * @return Arraylist of rank of all pair cards in a hand
     */
    private ArrayList<Integer> getRemainingCards(ArrayList<Integer> rankList, ArrayList<Integer> pairList){
        ArrayList<Integer> remainingCards = new ArrayList<>();
        for (Integer rank1 : rankList){
            if (Collections.frequency(rankList, rank1)<2){
                remainingCards.add(rank1);
            }
            else if ((Collections.frequency(rankList, rank1))%2!=0){
                remainingCards.add(rank1);
            }
        }
        return remainingCards;
    }

    /**
     * given two two pair hands or two one pair hands, compares rank of hands
     * @param other hand 2
     * @return 1 if rank of self is higher than other, -1 if rank of other is higher than self, 0 is equal
     */
    private int comparePair(PokerHand other){
        ArrayList<Integer> thisRankList;
        ArrayList<Integer> otherRankList;
        ArrayList<Integer> thisPairList;
        ArrayList<Integer> otherPairList;
        ArrayList<Integer> thisRemainingCards;
        ArrayList<Integer> otherRemainingCards;

        thisRankList = this.getRankList();
        otherRankList = other.getRankList();
        thisPairList = getPairList(thisRankList);
        otherPairList = getPairList(otherRankList);

        thisRankList.sort(Comparator.reverseOrder());
        otherRankList.sort(Comparator.reverseOrder());
        thisPairList.sort(Comparator.reverseOrder());
        otherPairList.sort(Comparator.reverseOrder());

        for (int i=0; i<thisPairList.size(); i++ ){
            int compareResult = Integer.compare(thisPairList.get(i),otherPairList.get(i));
            if (compareResult != 0){
                return compareResult;
            }
        }
        thisRemainingCards = getRemainingCards(thisRankList, thisPairList);
        otherRemainingCards = getRemainingCards(otherRankList, otherPairList);
        thisRemainingCards.sort(Comparator.reverseOrder());
        otherRemainingCards.sort(Comparator.reverseOrder());
        return compareRemainingCards(thisRemainingCards, otherRemainingCards);
    }

    /**
     * @param thislist list of non-pair cards in hand 1
     * @param otherlist list of non-pair cards in hand 2
     * @return 1 if thislist is worth more than otherlist,
     * -1 if thislist is worth less than otherlist, 0 if tie
     */
    private int compareRemainingCards(ArrayList<Integer> thislist,ArrayList<Integer> otherlist){
        for (int i=0; i<thislist.size(); i++ ){
            int compareResult = Integer.compare(thislist.get(i),otherlist.get(i));
            if (compareResult != 0){
                return compareResult;
            }
        }
        return 0;
    }

    /**
     * given two hands, compares and returns result of comparison
     * @param other poker hand 2
     * @return 1 if hand 1 is worth more than hand 2,
     * -1 if hand 1 is worth less than hand 2,
     * 0 if tie
     */
    private int compareHighCards(PokerHand other){
        ArrayList<Integer> thisranklist= this.getRankList();
        thisranklist.sort(Comparator.reverseOrder());
        ArrayList<Integer> otherranklist = other.getRankList();
        otherranklist.sort(Comparator.reverseOrder());
        for (int i=0; i<thisranklist.size(); i++ ){
            int compareResult = Integer.compare(thisranklist.get(i),otherranklist.get(i));
            if (compareResult != 0){
                return compareResult;
            }
        }
        return 0;

    }


}
