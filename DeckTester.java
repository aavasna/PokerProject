package proj4;

public class DeckTester {
    public static void main(String[] args) {
        Testing.startTests();
        testDeal();
        testSize();
        testShuffle();
        testGather();
        Testing.finishTests();

    }
    private static void testDeal() {
        Deck mydeck = new Deck();
        Testing.assertEquals("Testing Deal", true, mydeck.deal() instanceof Card);
    }


    private static void testSize(){
        Deck deck= new Deck();
        deck.deal();
        deck.deal();
        Testing.assertEquals("Testing size", 50, deck.size());
    }
    private static void testGather(){
        Deck deck= new Deck();
        for (int i=0; i<Deck.NUM_CARDS_IN_DECK; i++) {
            deck.deal();
        }
        deck.gather();
        Testing.assertTrue("Testing gather", deck.size()==Deck.NUM_CARDS_IN_DECK);
    }
    private static void testShuffle() {
        Deck firstDeck = new Deck();
        Card firstCardBeforeShuffle= firstDeck.deal();
        Deck secondDeck= new Deck();
        secondDeck.shuffle();
        Card firstCardAfterShuffle= secondDeck.deal();
        Deck mydeck = new Deck();
        mydeck.shuffle();
        Card myCard;
        int numH = 0;
        int numD = 0;
        int numC = 0;
        int numS = 0;
        int[] ranks= new int[13];
        int val;
        for (int i = 0; i < Deck.NUM_CARDS_IN_DECK; i++) {
            myCard = mydeck.deal();
            val = myCard.getRank();
            String suit = myCard.getSuit();
            if (suit.equals("Clubs")){
                numC++;}
            else if (suit.equals("Diamonds")){
                numD++;}
            else if (suit.equals("Spades")){
                numS++;}
            else if (suit.equals("Hearts")){
                numH++;}

            ranks[val - 2]++;  // deck RANKS run from 2-14 so need to subtract 2
        }

            Testing.assertTrue("Testing first card",(!firstCardBeforeShuffle.toString().equals(firstCardAfterShuffle.toString())));

        Testing.assertTrue("Testing Shuffle",((numC == 13 && numD == 13 && numH == 13 && numS == 13) && isAllEqual(ranks)) );
    }
    private static boolean isAllEqual(int[] a){
        for(int i=1; i<a.length; i++){
            if(a[0] != a[i]){
                return false;
            }
        }
        return true;
    }
    }
