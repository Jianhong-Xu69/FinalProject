import java.io.FileWriter;
import java.io.IOException;

public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        int[] stats = {10, 15, 3, 4};
        String test = "";
        Character test2 = new Melee("Test", stats);
        test += test2.prepareForFile() + "\n";
        Character test3 = new Gunslinger("Test2", stats);
        test += test3.prepareForFile();
        System.out.println(writeToFile(test));
    }

    public static String writeToFile(String text){
        try {
            FileWriter myWriter = new FileWriter("Characters.txt");
            myWriter.write(text);
            myWriter.close();
            return "Successfully wrote to the file.";
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred.";
        }
    }
}
