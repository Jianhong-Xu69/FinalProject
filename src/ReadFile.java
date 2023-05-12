import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner; // Import the Scanner class to read text files
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    public static void main(String[] args) {
        int n = 0; // The line number
        try{
            Path of = Path.of("Characters.txt");
            int type = Integer.parseInt(Files.readAllLines(of).get(n).substring(0,1));
            String name = Files.readAllLines(of).get(n).substring(1);
            int tier = Integer.parseInt(Files.readAllLines(of).get(n+1));
            int health = Integer.parseInt(Files.readAllLines(of).get(n+2));
            int resource = Integer.parseInt(Files.readAllLines(of).get(n+3));
            int[] stats = arrayRead(Files.readAllLines(of).get(n+4));
            int[] moves = arrayRead(Files.readAllLines(of).get(n+5));
            Gunslinger test = new Gunslinger(name, tier, stats, moves);
            System.out.println(test);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] arrayRead (String s){
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(",")){
                count++;
            }
        }
        int[] array = new int[count];
        s = s.substring(1, s.length()-1);
        String[] temp = s.split(", ");
        for (int i = 0; i < temp.length; i++) {
            array[i] = Integer.parseInt(temp[i]);
        }
        return array;
    }
}