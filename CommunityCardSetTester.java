package proj4;

import java.util.ArrayList;

public class CommunityCardSetTester {
    public static void main(String[] args) {
        Testing.startTests();
        testGetIthCard();
        testAddCard();
        Testing.finishTests();
    }
    private static void testGetIthCard(){
        ArrayList<Card> emptyList = new ArrayList<>();
        CommunityCardSet myCommunityCards = new CommunityCardSet(emptyList);
        Card card1 = new Card(3,1);
        myCommunityCards.addCard(card1);
        Card card2 = new Card(11, "Hearts");
        myCommunityCards.addCard(card2);
        Card card3 = new Card("seven","Spades");
        myCommunityCards.addCard(card3);
        Card card4 = new Card(14, 3);
        myCommunityCards.addCard(card4);
        Card card5 = new Card("two","Clubs");
        myCommunityCards.addCard(card5);
        Testing.assertEquals("Testing get ith card", card2 ,myCommunityCards.getIthCard(1) );
        Testing.assertEquals("Testing get ith card", card1 ,myCommunityCards.getIthCard(0) );
        Testing.assertEquals("Testing get ith card", card5 ,myCommunityCards.getIthCard(4) );
    }

    private static void testAddCard(){
        ArrayList<Card> emptyList = new ArrayList<>();
        CommunityCardSet myCommunityCards = new CommunityCardSet(emptyList);
        Card card1 = new Card(3,1);
        myCommunityCards.addCard(card1);
        Card card2 = new Card(11, "Hearts");
        myCommunityCards.addCard(card2);
        Card card3 = new Card("seven","Spades");
        Testing.assertEquals("Testing add card", 2, myCommunityCards.size());
        myCommunityCards.addCard(card3);
        Card card4 = new Card(14, 3);
        myCommunityCards.addCard(card4);
        Card card5 = new Card("two","Clubs");
        myCommunityCards.addCard(card5);
        Testing.assertEquals("Testing add card", card3 ,myCommunityCards.getIthCard(2) );
        Testing.assertEquals("Testing add card", 5, myCommunityCards.size());
    }
}
