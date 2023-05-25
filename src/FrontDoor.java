import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        Player test = new Player();
        test.pullFromFile();
        Combat tes = new Combat(test);
        for (int i = 0; i < 10; i++) {
            System.out.println("Target " + tes.findTarget() + "\n");
        }
    }
}
