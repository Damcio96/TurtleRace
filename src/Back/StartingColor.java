package Back;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class StartingColor {

    LinkedList<String> startingColors = new LinkedList<>(Arrays.asList("Red", "Blue", "Yellow", "Green", "Purple"));
    public StartingColor(){}

    public String drawColor(){
        Random rand = new Random();
        return startingColors.remove(rand.nextInt(startingColors.size()));
    }
}
