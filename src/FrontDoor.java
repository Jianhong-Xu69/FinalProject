import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        Player test = new Player();
        test.pullFromFile();
        Combat tes = new Combat(test);
        System.out.println(Arrays.toString(tes.generateTurnOrder()));
    }
}
