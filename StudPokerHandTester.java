package proj4;

import java.util.ArrayList;

public class StudPokerHandTester {
    public static void main(String[] args) {
        Testing.startTests();

        TwoPairVSHighCard();
        TwoPairVSOnePair();
        TwoPairVSFlush();
        TwoPairVSFOAK();
        TwoPairVSFullHouse();
        TwoPairVSTwoPair();
        TwoPairVSTwoPairDraw();

        HighCardVSOnePair();
        HighCardVSFlush();
        HighCardVSHighCard();
        HighCardVSTwoPair();
        HighCardVSHighCardDraw();

        FlushVSOnePair();
        FlushVSFlush();
        FlushVSHighCardCase1();
        FlushVSHighCardCase2();
        FlushVSTwoPair();
        FlushVSFlushDraw();

        testingTwoSpecialOnePair();

        Testing.finishTests();
    }

    private static void TwoPairVSFOAK()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCardFOAK(), getFourOfAKind());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCardFOAK(), getTwoPair());
        Testing.assertEquals("Testing Two Pair vs Four of a kind", 1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }
    private static void TwoPairVSFullHouse()
    {
        StudPokerHand  testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getTwoPair());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCardFOAK(), getFullHouse());
        Testing.assertEquals("Testing Two Pair vs TwoPair(Full House)", -1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }
    private static void testingTwoSpecialOnePair()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCardSpecialOnePair(), getSpecialOnePair1());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCardSpecialOnePair(), getSpecialOnePair2());
        Testing.assertEquals("Testing two 1-pair hands - pairs equal, different on 2nd highest card", -1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }
    private static void TwoPairVSTwoPair()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCardFOAK(), getTwoPair());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCardFOAK(), getTwoPair2());
        Testing.assertEquals("Testing Two Pair vs Two Pair", -1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }

    private static void TwoPairVSTwoPairDraw()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCardFOAK(), getTwoPair());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCardFOAK(), getTwoPair());
        Testing.assertEquals("Testing Two Pair vs Two Pair Draw with identical cards", 0, testStudPokerHand1.compareTo(testStudPokerHand2));
    }
    private static void TwoPairVSHighCard()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getHighCard());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getTwoPair());
        Testing.assertEquals("Testing Two Pair VS Highcard with TwoPair as the other hand", -1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }


    private static void TwoPairVSOnePair()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getTwoPair());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getOnePair());
        Testing.assertEquals("Testing TwoPair VS OnePair with OnePair as the other hand", 1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }

    private static void TwoPairVSFlush()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getTwoPair());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getFlush());
        Testing.assertEquals("Testing TwoPair vs Flush with Flush as the other hand", -1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }
    private  static void FlushVSOnePair()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getFlush());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getOnePair());
        Testing.assertEquals("Testing Flush VS One Pair with OnePair as the other hand", 1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }

    private  static void FlushVSFlushDraw()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getFlush());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getFlush());
        Testing.assertEquals("Testing Flush VS Flush Draw", 0, testStudPokerHand1.compareTo(testStudPokerHand2));
    }

    private static void FlushVSFlush()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getFlush());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getFlush2());
        Testing.assertEquals("Testing on who wins between two flushes", 1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }


    private  static void FlushVSHighCardCase1()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getFlush());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getHighCard2());
        Testing.assertEquals("Testing Flush VS HighCard Test Case One With Ace Top On HighCard", 1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }


    private  static void FlushVSHighCardCase2()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getFlush());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getHighCard2());
        Testing.assertEquals("Testing Flush VS HighCard Test Case Two With King Top On HighCard", 1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }

    private  static void FlushVSTwoPair()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getFlush());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getTwoPair());
        Testing.assertEquals("Testing Flush VS Two Pair with TwoPair as the other hand", 1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }
    private static void HighCardVSOnePair()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getHighCard());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getOnePair());
        Testing.assertEquals("Testing HighCard VS One Pair", -1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }

    private static void HighCardVSTwoPair()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getHighCard());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getTwoPair());
        Testing.assertEquals("Testing HighCard VS TwoPair with With Two Pair as the other Hand", -1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }

    private static void HighCardVSHighCard()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getHighCard());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getHighCard2());
        Testing.assertEquals("Testing HighCard VS HighCard With difference in the highest rank", 1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }


    private static void HighCardVSFlush()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getHighCard());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getFlush());
        Testing.assertEquals("Testing HighCard VS Flush with Flush as the other hand", -1, testStudPokerHand1.compareTo(testStudPokerHand2));
    }

    private static void HighCardVSHighCardDraw()
    {
        StudPokerHand testStudPokerHand1 = new StudPokerHand(getCommunityCard(), getHighCard());
        StudPokerHand testStudPokerHand2 = new StudPokerHand(getCommunityCard(), getHighCard());
        Testing.assertEquals("Testing HighCard VS HighCard Draw", 0, testStudPokerHand1.compareTo(testStudPokerHand2));
    }
    private static ArrayList<Card> getFlush(){
        return getListOfCards(new int []{5,7}, new int[]{0,0});
    }
    private static ArrayList<Card> getFlush2(){
        return getListOfCards(new int []{3,7}, new int[]{0,0});
    }
    private static ArrayList<Card> getTwoPair() {
        return getListOfCards(new int[]{4, 7}, new int[]{3, 0});
    }
    private static ArrayList<Card> getTwoPair2() {
        return getListOfCards(new int[]{14, 7}, new int[]{3, 0});
    }
    private static ArrayList<Card> getOnePair(){
        return getListOfCards(new int[]{5, 11}, new int[]{3, 0});
    }
    private static ArrayList<Card> getHighCard(){
        return getListOfCards(new int[]{14,3}, new int[]{3,2});
    }
    private static ArrayList<Card> getHighCard2(){
        return getListOfCards(new int[]{13,3}, new int[]{3,2});
    }
    private static ArrayList<Card> getSpecialOnePair1(){return getListOfCards(new int[]{12,5}, new int[]{3,1});}
    private static ArrayList<Card> getSpecialOnePair2(){return getListOfCards(new int[]{12,10}, new int[]{2,1});}
    private static ArrayList<Card> getFourOfAKind(){return getListOfCards(new int[]{12,12}, new int[]{2,3});}
    private static ArrayList<Card> getFullHouse() {return getListOfCards(new int[]{7, 7}, new int[]{0,3});}


    private static CommunityCardSet getCommunityCard()
    {
        int[] ranks = new int[]{12, 5, 2, 6, 7};
        int [] suits = new int[]{0,3,0,0,3};
        return new CommunityCardSet(getListOfCards(ranks, suits)) ;
    }
    private static CommunityCardSet getCommunityCardFOAK(){
        int[] ranks = new int[]{12,12,4,6,7};
        int[] suits = new int[]{0,1,0,0,3};
        return new CommunityCardSet(getListOfCards(ranks, suits));
    }
    private static CommunityCardSet getCommunityCardSpecialOnePair(){
        int[] ranks = new int[]{14,4,6,9,12};
        int[] suits = new int[]{1,2,3,0,2};
        return new CommunityCardSet(getListOfCards(ranks, suits));
    }
    private static ArrayList<Card> getListOfCards(int[] ranks,int []suits){
        ArrayList<Card> cardList = new ArrayList<>();
        int loopCounter= ranks.length;
        for (int i=0; i< loopCounter; i++){
            Card card= new Card(ranks[i],suits[i]);
            cardList.add(card);
        }
        return cardList;
    }
}
