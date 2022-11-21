package Back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Player {
    String playerColor;
    LinkedList<Card> inHand;
    String[] turtleColors = {"Red", "Blue", "Yellow", "Green", "Purple", "Uni"};

    public Player(String playerColor, ArrayList<Card> dealtCards){
        this.playerColor = playerColor;
        drawWholeHand(dealtCards);
    }

    public void drawCard(Card card){
        inHand.add(card);
        System.out.println("You drew: " + card.getTurtleColor() + " Turtle: " + card.getActionType());
    }
    public Card playCard(){
        System.out.print("Play a card (number): ");
        Scanner input = new Scanner(System.in);
        int cardNo = input.nextInt()-1;
        if(cardNo > 4){
            System.out.println("Incorrect number!");
            return this.playCard();
        }
        return inHand.get(cardNo);
    }
    public Card chooseCardColor(Card card){
        for(int i = 0; i < 5; i++)
            System.out.println(i+1 + ". " + turtleColors[i]);
        System.out.print("Choose turtle color (number): ");
        Scanner input = new Scanner(System.in);
        int cardColor = input.nextInt();
        return new Card(turtleColors[cardColor - 1], card.getActionType());
    }
    public void displayHand(){
        int i = 1;
        System.out.println(playerColor + " Player Cards:");
        for(Card card: inHand)
            System.out.println(i++ + ". " + card.getTurtleColor() + " Turtle: " + card.getActionType());
        System.out.println("----------------------------------------");
    }
    public void discardCard(Card card){
        inHand.remove(card);
    }
    public void discardAllCards(DiscardPile discardPile){
        discardPile.getDiscardPile().addAll(inHand);
        inHand.clear();
    }
    public void drawWholeHand(ArrayList<Card> dealtCards){
        inHand = new LinkedList<>(dealtCards);
    }
    public LinkedList<Card> getInHand() {
        return inHand;
    }
}
