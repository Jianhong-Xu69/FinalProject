import java.util.ArrayList;

public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        int[] stats = {1,2,3,4,5,6};
        ArrayList<String> moves = new ArrayList<String>();
        moves.add("Test");
        moves.add("123");
        moves.add("Guns");
        Character test = new Character("Test", 4, 1, 5, 6, stats, moves);
        test.writeToFile();
    }
}
