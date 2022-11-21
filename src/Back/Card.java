package Back;

public class Card {
    String turtleColor;
    String actionType;

    Card(String turtleColor, String actionType){
        this.turtleColor = turtleColor;
        this.actionType = actionType;
    }

    public String getTurtleColor(){
        return turtleColor;
    }
    public String getActionType(){
        return actionType;
    }
    public Card setUniColor() {
        this.turtleColor = "Uni";
        return this;
    }
}
