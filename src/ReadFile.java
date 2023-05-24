import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner; // Import the Scanner class to read text files
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {
    public static Character[] fileRead() {
        try{
            Path of = Path.of("Characters.txt");
            int fileLength;
            Character[] temp = new Character[3];
            ArrayList<String> allLines = (ArrayList<String>) Files.readAllLines(of);
            fileLength = allLines.size();
            int i = 0;
            for (int n = 0; n < fileLength; n+=2) {
                int type = Integer.parseInt(Files.readAllLines(of).get(n).substring(0, 1));
                String name = Files.readAllLines(of).get(n).substring(1);
                int[] stats = arrayRead(Files.readAllLines(of).get(n + 1));
                Character test;
                if (type == 1) {
                    test = new Gunslinger(name, stats);
                } else if (type == 2) {
                    test = new Melee(name, stats);
                } else if (type == 3){
                    test = new Wizard(name, stats);
                } else {
                    test = new Character(name, stats);
                }
                if (i < 3) {
                    temp[i] = test;
                    i++;
                }
            }
            return temp;
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

    public static String prepWriteFile (Character[] c){
        String temp = "";
        for (Character cha: c){
            temp += cha.prepareForFile() + "\n";
        }
        return temp;
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

    public static ArrayList<String> readNames(){
        ArrayList<String> names;
        try{
            Path of = Path.of("RandomNames.txt");
            int fileLength = 0;
            names = (ArrayList<String>) Files.readAllLines(of);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return names;
    }
}