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
            System.out.println(Arrays.toString(stats));
//            Character test = new Character();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] statRead (String s){
        int[] temp = new int[6];
        temp[0] = Integer.parseInt(s.substring(s.indexOf("[")+1, s.indexOf(",")));
        s = s.substring(s.indexOf(",")+2);
        for (int i = 1; i < 6; i++) {
            temp[i] = Integer.parseInt(s.substring(0, s.indexOf(",")));
            s = s.substring(s.indexOf(",")+2);
        }
        temp[6] = Integer.parseInt(s.substring(0, s.indexOf("]")));
        return temp;
    }
}
