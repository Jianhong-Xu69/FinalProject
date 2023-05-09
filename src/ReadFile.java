import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner; // Import the Scanner class to read text files
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    public static void main(String[] args) {
        int n = 0; // The line number
        try{
            Path of = Path.of("Characters.txt");
            String name = Files.readAllLines(of).get(n);
            System.out.println(name);
            int tier = Integer.parseInt(Files.readAllLines(of).get(n+1));
            System.out.println(tier);
            int type = Integer.parseInt(Files.readAllLines(of).get(n+2));
            int health = Integer.parseInt(Files.readAllLines(of).get(n+3));
            int resource = Integer.parseInt(Files.readAllLines(of).get(n+4));
            int[] stats = statRead(Files.readAllLines(of).get(n+5));
            for (int i = 0; i < 6; i++) {
                System.out.println(stats[i]);
            }
//            Character test = new Character();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] statRead (String s){
        int[] array = new int[6];
        s = s.substring(1, s.length()-1);
        String[] temp = s.split(", ");
        for (int i = 0; i < 6; i++) {
            array[i] = Integer.parseInt(temp[i]);
        }
        return array;
    }
}
