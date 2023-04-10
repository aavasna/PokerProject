package proj4;

public class CardTester {
    public static void main(String[] args) {
        Testing.startTests();
        testGetRank();
        testGetSuit();
        testToString();
        Testing.finishTests();
    }
    private static void testGetRank(){
        Card card= new Card(3, 2);
        Testing.assertEquals("Testing Get Rank",3,card.getRank());
        Card card2= new Card("jack", "Diamonds");
        Testing.assertEquals("Testing Get Rank",11,card2.getRank());
        Card card3= new Card(10 , "Diamonds");
        Testing.assertEquals("Testing Get Rank",10,card3.getRank());
    }
    private static void testGetSuit(){
        Card card= new Card("ace", "Clubs");
        Testing.assertEquals("Testing Get Suit","Clubs",card.getSuit());
    }
    private static void testToString(){
        Card card= new Card("Two","Diamonds");
        Testing.assertEquals("Testing To String","2 of Diamonds",card.toString());
        Card card2= new Card("2","Spades");
        Testing.assertEquals("Testing To String","2 of Spades",card2.toString());
        Card card3= new Card("ace","Clubs");
        Testing.assertEquals("Testing To String","Ace of Clubs",card3.toString());
        Card card4= new Card(4,"Spades");
        Testing.assertEquals("Testing To String","4 of Spades",card4.toString());
        Card card5= new Card(7,"Hearts");
        Testing.assertEquals("Testing To String","7 of Hearts",card5.toString());
    }
}
