package Back;
import java.util.*;

public class BoardMechanic {

    public BoardMechanic(Turtle[] turtles, LinkedList<Turtle>[] fields){
        turtles[0] = new Turtle("Red");
        turtles[1] = new Turtle("Blue");
        turtles[2] = new Turtle("Yellow");
        turtles[3] = new Turtle("Green");
        turtles[4] = new Turtle("Purple");
        for(int i = 0; i < 10; i++)
            fields[i] = new LinkedList<>();
        fields[9].addAll(Arrays.asList(turtles));
    }

    public void displayBoard(LinkedList<Turtle>[] fields){
        System.out.println("----------META----------");
        for(LinkedList<Turtle> field: fields) {
            int i = 1;
            if (field.isEmpty())
                System.out.println();
            for(int j = field.size(); j > 0; j--)
                System.out.println(i++ + ". " + field.get(j-1).getTurtleColor());
            //for (Turtle turtle: field)    //przyda się potem
                //System.out.println(i++ + ". " + turtle.getTurtleColor());
            System.out.println("------------------------");
        }
    }
    public void checkMovementPossibility(DiscardPile discardPile, Deck deck, Player player, LinkedList<Turtle>[] fields){
        boolean canPlayerMakeMove = true;
        while(canPlayerMakeMove) {
            for (Card card : player.getInHand()) {
                if (this.checkMoveLegality(card, fields)) {
                    canPlayerMakeMove = false;
                    break;
                }
            }
            if (canPlayerMakeMove) {
                player.discardAllCards(discardPile);
                deck.whetherToShuffleCards(true, discardPile);
                player.drawWholeHand(deck.dealCards());
                player.displayHand();
            }
        }
    }
    public boolean checkMoveLegality(Card card, LinkedList<Turtle>[] fields){
        if(card.getActionType().equals("Backward"))
            if (card.getTurtleColor().equals("Uni"))
                return fields[9].size() != 5;
            else
                for (Turtle turtle : fields[9])
                    if (turtle.getTurtleColor().equals(card.getTurtleColor()))
                        return false;
        return true;
    }
    public boolean hasAnyoneWon(LinkedList<Turtle>[] fields){
        if(!fields[0].isEmpty()){
            System.out.println("========================");
            System.out.println(fields[0].getLast().getTurtleColor() + " Player Wins!!!");
            System.out.println("END GAME");
            System.out.println("========================");
            return false;
        }
        return true;
    }
}
