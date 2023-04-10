package proj4;
import java.util.Scanner;
import java.util.ArrayList;

public class Client {
    public static final int [] PLAYER_CHOICE= {0,1,-1};
    /**
     * creates two poker hands and shows them to the player, asks for a winner,
     * adds to player's point if correct,
     * ends the game is deck runs out or player guess is incorrect,
     * displays player's points
     */
    public static void main(String[] args) {
        ArrayList<Card> emptyList = new ArrayList<>();
        Deck deck = new Deck();
        deck.shuffle();
        boolean gameOver = false;
        int playerPoint = 0;
        int actualWinner;
        CommunityCardSet cc = new CommunityCardSet(emptyList);
        for (int counter = 0; counter < CommunityCardSet.NUM_COMMUNITY_CARDS; counter++) {
            Card card = deck.deal();
            cc.addCard(card);
        }
            while (!gameOver && (deck.size() >= (2 * StudPokerHand.NUM_HAND_CARDS))) {
                ArrayList<Card> hand1List = new ArrayList<>();
                ArrayList<Card> hand2List = new ArrayList<>();
                for (int i = 0; i < StudPokerHand.NUM_HAND_CARDS; i++) {
                    Card card1 = deck.deal();
                    hand1List.add(card1);
                    Card card2 = deck.deal();
                    hand2List.add(card2);
                }
                System.out.println("The community cards are:");
                System.out.println(cc);
                StudPokerHand hand1 = new StudPokerHand(cc, hand1List);
                StudPokerHand hand2 = new StudPokerHand(cc, hand2List);
                System.out.println("Which of the following hands is worth more?\n");
                System.out.println("Hand 1:");
                for (int x = 0 ; x <StudPokerHand.NUM_HAND_CARDS; x++){
                    System.out.println(hand1.getIthCard(x) + "   ");
                }
                System.out.println("\nHand 2:");
                for (int x = 0 ; x <StudPokerHand.NUM_HAND_CARDS; x++){
                    System.out.println(hand2.getIthCard(x) + "   ");
                }
                Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                System.out.println("\nEnter winner (1 if HAND 1 wins, 2 if HAND 2 wins and 0 if tie) : ");
                int userInput = myObj.nextInt();
                while ((userInput != 1) && (userInput != 0) && (userInput != 2)) {
                    System.out.print("ERROR! INVALID INPUT. ENTER AGAIN.");
                    System.out.println("Enter winner (1 if HAND 1 wins, 2 if HAND 2 wins and 0 if tie) : ");
                    userInput = myObj.nextInt();
                }
                actualWinner = hand1.compareTo(hand2);
                if (PLAYER_CHOICE[userInput] == actualWinner) {
                    System.out.println("CORRECT!!!");
                    playerPoint += 1;
                    System.out.println("Current Player Point : "+ playerPoint);
                    System.out.print("\n");
                } else {
                    gameOver = true;
                }
            }
            System.out.println("GAME OVER");
            System.out.println("Player point: " + playerPoint);
        }
    }
