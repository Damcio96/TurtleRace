package Back;

public class Turtle {
    int fieldNo;
    int fieldPos;
    String turtleColor;

    public Turtle(String color){
        fieldNo = 9;
        fieldPos = 0;
        this.turtleColor = color;
    }
    public int getFieldNo() {return fieldNo;}
    public int getFieldPos() {return fieldPos;}
    public String getTurtleColor() {return turtleColor;}
    public void setFieldNo(int fieldNo) {this.fieldNo = fieldNo;}
    public void setFieldPos(int fieldPos) {this.fieldPos = fieldPos;}
}
