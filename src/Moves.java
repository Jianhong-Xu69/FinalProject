import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Moves { //needed a class that contains all the moves and could randomly assign them.
    public static final String[] LUMI = {"Reload", "TASG", "Flash Fire", "Rapid Fire", "Magdump", "Bulletstorm"};
    public static final String[] ROLAND = {"Ranga Workshop", "Zelkova Workshop", "Old Boys Workshop", "Allas Workshop", "Mook Workshop", "Atelier Logic", "Durandal", "Crystal Atelier", "Wheels Industry", "Furioso"};

    public static String gs_move(){ //returns random move from GS list, excluding Reload. Reads from a file (woah)
        int random = (int) (Math.random()*5)+2;
        try{
            return Files.readAllLines(Paths.get("Movesets.txt")).get(random);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String ml_move(){ //returns random move from ML list, excluding Slash
        int random = (int) (Math.random()*6)+10;
        try{
            return Files.readAllLines(Paths.get("Movesets.txt")).get(random);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String wz_move(){ //returns random move on WZ list, excluding Heal
        int random = (int) (Math.random()*6)+19;
        try{
            return Files.readAllLines(Paths.get("Movesets.txt")).get(random);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sh_move(){ //returns random move on SH list, excluding Block
        int random = (int) (Math.random()*4)+28;
        try{
            return Files.readAllLines(Paths.get("Movesets.txt")).get(random);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
