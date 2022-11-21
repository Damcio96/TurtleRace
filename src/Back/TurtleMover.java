package Back;

import java.util.LinkedList;

public class TurtleMover {

    public TurtleMover(){}

    public void moveTurtle(Card card, Turtle[] turtles, LinkedList<Turtle>[] fields){
        for(Turtle turtle: turtles){
            if(turtle.getTurtleColor().equals(card.getTurtleColor())){
                if(turtle.getFieldNo() == 9){
                    if(card.getActionType().equals("Double Forward"))
                        moveTurtle(true, 2, turtle, fields);
                    else
                        moveTurtle(true, 1, turtle, fields);
                }
                else if(turtle.getFieldNo() == 1){
                    if(card.getActionType().equals("Backward"))
                        moveTurtle(false, -1, turtle, fields);
                    else
                        moveTurtle(false, 1, turtle, fields);
                }
                else{
                    if(card.getActionType().equals("Backward"))
                        moveTurtle(false, -1, turtle, fields);
                    else if(card.getActionType().equals("Double Forward"))
                        moveTurtle(false, 2, turtle, fields);
                    else
                        moveTurtle(false, 1, turtle, fields);
                }
            }
        }
    }
    private void moveTurtle(boolean isFirstFields, int movingDistance, Turtle turtle, LinkedList<Turtle>[] fields){
        int currentField = turtle.getFieldNo();
        int turtlesNo = fields[currentField].size();

        if(isFirstFields){
            fields[9].remove(turtle);
            fields[9 - movingDistance].add(turtle);
            turtle.setFieldNo(9 - movingDistance);
            turtle.setFieldPos(fields[9 - movingDistance].indexOf(turtle));
        }
        else{
            for(int i = 0; i < (turtlesNo - turtle.getFieldPos()); i++){
                Turtle tempTurtle = fields[currentField].remove(turtle.getFieldPos());
                tempTurtle.setFieldNo(currentField - movingDistance);
                fields[currentField - movingDistance].add(tempTurtle);
            }
            for(Turtle tempTurtle: fields[currentField - movingDistance])
                if(currentField - movingDistance == 9)
                    tempTurtle.setFieldPos(0);
                else
                    tempTurtle.setFieldPos(fields[currentField - movingDistance].indexOf(tempTurtle));
        }
    }
}
