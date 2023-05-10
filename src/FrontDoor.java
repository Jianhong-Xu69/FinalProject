import java.util.ArrayList;

public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        int[] stats = {1,2,3,4,5,6};
        int[] moves = {1, 2, 3};
        Character test = new Gunslinger("Test", 4, 5, 6, stats, moves);
        test.writeToFile();
        test.rollSpeed();
    }
}
