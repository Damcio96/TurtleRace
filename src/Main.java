import Back.*;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Turtle[] turtles = new Turtle[5];
        LinkedList<Turtle>[] fields = new LinkedList[10];
        BoardMechanic board = new BoardMechanic(turtles, fields);
        Deck deck = new Deck();
        DiscardPile discardPile = new DiscardPile();
        StartingColor startingColor = new StartingColor();
        TurtleMover turtleMover = new TurtleMover();
        Card currentCard, playedCard;
        deck.shuffleDeck();
        System.out.print("Enter the number of Players: ");
        Scanner input = new Scanner(System.in);
        int playerNo = input.nextInt();
        Player[] players = new Player[playerNo];
        for (int i = 0; i < playerNo; i++){
            players[i] = new Player(startingColor.drawColor(), deck.dealCards());
        }
        board.displayBoard( fields);
        int playersTurn = 0;
        
        while(board.hasAnyoneWon(fields)){
            if(playersTurn == playerNo)
                playersTurn = 0;
            board.checkMovementPossibility(discardPile, deck, players[playersTurn], fields);
            players[playersTurn].displayHand();
            currentCard = playedCard = players[playersTurn].playCard();
            if (currentCard.getTurtleColor().equals("Uni"))
                currentCard = players[playersTurn].chooseCardColor(currentCard);
            if(!board.checkMoveLegality(currentCard, fields)){
                System.out.println("Illegal move!");
                continue;
            }
            turtleMover.moveTurtle(currentCard, turtles, fields);
            players[playersTurn].discardCard(playedCard);
            discardPile.putCard(playedCard);
            players[playersTurn].drawCard(deck.giveCard());
            deck. whetherToShuffleCards(false, discardPile);
            board.displayBoard(fields);
            playersTurn++;
        }
    }
}
