import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            System.out.println(Arrays.toString(RandomlyGenerate.randomStats()));
        }
    }
}
