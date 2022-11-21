package Back;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Deck {

    LinkedList<Card> deck = new LinkedList<>();
    String[] turtleColors = {"Red", "Blue", "Yellow", "Green", "Purple", "Wild"};
    String[] turtleActions = {"Double Forward", "Single Forward", "Backward"};
    //String[] turtleActions = {"Backward"};

    public Deck(){
        for(String color: turtleColors)
            for(String action: turtleActions)
                for(int i = 0; i < 3; i++)
                    deck.add(new Card(color, action));
    }

    public void displayDeck(){
        for(Card card: deck){
            System.out.println(card.getTurtleColor() + "Turtle: " + card.getActionType());
        }
    }
    public void shuffleDeck(){
        ArrayList<Card> temp = new ArrayList<>(deck);
        deck.clear();
        Random rand = new Random();
        while(!temp.isEmpty())
            deck.add(temp.remove(rand.nextInt(temp.size())));
    }
    public ArrayList<Card> dealCards(){
        ArrayList<Card> startingCards = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            startingCards.add(deck.removeLast());
        return startingCards;
    }
    public Card giveCard(){
        return deck.removeLast();
    }
    public void whetherToShuffleCards(boolean wholeHand, DiscardPile discardPile){
        if((wholeHand && (deck.size() < 5) || (!wholeHand && deck.isEmpty()))) {
            deck.addAll(discardPile.getDiscardPile());
            this.shuffleDeck();
            discardPile.clearDiscardPile();
        }
    }
}


