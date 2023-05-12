import java.util.ArrayList;

public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        int[] stats = {10, 15, 3, 4};
        int[] moves = {1, 2, 3};
        Gunslinger test = new Gunslinger("Test", 4, stats, moves);
        test.writeToFile();
        System.out.println(test);
    }
}
