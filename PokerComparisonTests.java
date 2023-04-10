package proj4;

import java.util.ArrayList;

public class PokerComparisonTests {
    public static void main(String[] args) {
        Testing.startTests();
        testFlushTie();
        testFlush1();
        testFlushTwoPair();
        testTwoPairOnePair();
        testHighCardOnePair();
        testFlushOnePair();
        testTwoPair1();
        testTwoPair2();
        testTwoPairTie();
        testOnePair1();
        testOnePair2();
        testOnePairTie();
        testHighCards();
        Testing.finishTests();
    }
    private static void testFlushTie(){
        int[] ranks={10,11,12,13,14};
        String[] suits={"Clubs","Clubs","Clubs","Clubs","Clubs"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={10,11,12,13,14};
        String[] suits2={"Hearts","Hearts","Hearts","Hearts","Hearts"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 0;
        int actual = hand1.compareTo(hand2);
        Testing.startTests();
        Testing.assertEquals("FLUSH TIE", expected, actual);
    }

    private static void testFlush1(){
        int[] ranks={10,11,12,13,14};
        String[] suits={"Clubs","Clubs","Clubs","Clubs","Clubs"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={6,11,12,13,14};
        String[] suits2={"Hearts","Hearts","Hearts","Hearts","Hearts"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("FLUSH 1", expected, actual);
    }

    private static void testFlushTwoPair(){
        int[] ranks={5,7,12,9,4};
        String[] suits={"Clubs","Clubs","Clubs","Clubs","Clubs"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={4,2,3,4,3};
        String[] suits2={"Hearts","Diamonds","Spades","Clubs","Hearts"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("FLUSH VS TWO PAIR", expected, actual);
    }
    private static void testTwoPairOnePair(){
        int[] ranks={4,2,3,4,3};
        String[] suits={"Hearts","Diamonds","Spades","Clubs","Hearts"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={14,12,14,5,4};
        String[] suits2={"Hearts","Diamonds","Diamonds","Clubs","Spades"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("TWO PAIR VS PAIR", expected, actual);
    }
    private static void testHighCardOnePair(){
        int[] ranks={5,2,12,13,7};
        String[] suits={"Spades","Clubs","Diamonds","Clubs","Hearts"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={14,12,14,5,4};
        String[] suits2={"Hearts","Diamonds","Diamonds","Clubs","Spades"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = -1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("HIGHCARD VS PAIR", expected, actual);
    }
    private static void testFlushOnePair(){
        int[] ranks={5,7,12,9,4};
        String[] suits={"Clubs","Clubs","Clubs","Clubs","Clubs"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={14,12,14,5,4};
        String[] suits2={"Hearts","Diamonds","Diamonds","Clubs","Spades"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("TWO PAIR VS PAIR", expected, actual);
    }
    private static void testTwoPair1() {
        int[] ranks = {10, 2, 3, 10, 2};
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs", "Hearts"};
        ArrayList<Card> cardlist1 = handList(ranks, suits);
        int[] ranks2 = {4, 6, 4, 12, 6};
        String[] suits2 = {"Hearts", "Diamonds", "Diamonds", "Clubs", "Spades"};
        ArrayList<Card> cardlist2 = handList(ranks2, suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("TWO PAIR VS TWO PAIR 1", expected, actual);
    }
    private static void testTwoPair2() {
        int[] ranks = {8, 8, 2, 2, 14};
        String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs", "Hearts"};
        ArrayList<Card> cardlist1 = handList(ranks, suits);
        int[] ranks2 = {3, 3, 4, 8, 8};
        String[] suits2 = {"Hearts", "Diamonds", "Diamonds", "Clubs", "Spades"};
        ArrayList<Card> cardlist2 = handList(ranks2, suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = -1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("TWO PAIR VS TWO PAIR 2", expected, actual);
    }
    private static void testTwoPairTie() {
        int[] ranks = {5, 5, 9, 9,2};
        String[] suits = {"Spades", "Clubs", "Clubs", "Hearts", "Diamonds"};
        ArrayList<Card> cardlist1 = handList(ranks, suits);
        int[] ranks2 = {5, 5, 2, 9, 9};
        String[] suits2 = {"Hearts", "Diamonds", "Diamonds", "Spades", "Diamonds"};
        ArrayList<Card> cardlist2 = handList(ranks2, suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 0;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("TWO PAIR TIE", expected, actual);
    }
    private static void testOnePair1(){
        int[] ranks={14,14,6,3,4};
        String[] suits={"Hearts","Diamonds","Hearts","Clubs","Hearts"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={13,2,12,13,7};
        String[] suits2={"Clubs","Spades","Diamonds","Clubs","Spades"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("PAIR VS PAIR 1", expected, actual);
    }
    private static void testOnePair2(){
        int[] ranks={4,4,6,13,9};
        String[] suits={"Hearts","Diamonds","Hearts","Clubs","Hearts"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={4,4,2,13,7};
        String[] suits2={"Clubs","Spades","Diamonds","Hearts","Spades"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("PAIR VS PAIR 2", expected, actual);
    }
    private static void testOnePairTie(){
        int[] ranks={4,4,6,13,9};
        String[] suits={"Hearts","Diamonds","Hearts","Clubs","Hearts"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={4,4,6,13,9};
        String[] suits2={"Clubs","Spades","Diamonds","Hearts","Spades"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = 0;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("PAIR TIE", expected, actual);
    }
    private static void testHighCards(){
        int[] ranks={5,2,12,13,7};
        String[] suits={"Clubs","Spades","Diamonds","Clubs","Spades"};
        ArrayList<Card> cardlist1= handList(ranks,suits);
        int[] ranks2={9,11,12,13,3};
        String[] suits2={"Diamonds","Hearts","Hearts","Spades","Hearts"};
        ArrayList<Card> cardlist2= handList(ranks2,suits2);
        PokerHand hand1 = new PokerHand(cardlist1);
        PokerHand hand2 = new PokerHand(cardlist2);
        int expected = -1;
        int actual = hand1.compareTo(hand2);
        Testing.assertEquals("HIGH CARD", expected, actual);
    }
    private static ArrayList<Card> handList(int[] ranks,String []suits){
        ArrayList<Card> cardList = new ArrayList<>();
        int loopCounter= ranks.length;
        for (int i=0; i< loopCounter; i++){
                Card card= new Card(ranks[i],suits[i]);
                cardList.add(card);
            }
        return cardList;
    }
    }
