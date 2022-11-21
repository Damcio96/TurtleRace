package Back;
import java.util.ArrayList;

public class DiscardPile {
    ArrayList<Card> discardPile = new ArrayList<>();
    public DiscardPile(){}

    public void putCard(Card card){
        discardPile.add(card);
    }
    public ArrayList<Card> getDiscardPile(){
        return discardPile;
    }
    public void clearDiscardPile(){
        discardPile.clear();
    }

    public void displayDiscardPile(){
        System.out.println("Discard Pile:");
        for(Card card: discardPile)
            System.out.println(card.getTurtleColor() + " Turtle: " + card.getActionType());
    }
}
