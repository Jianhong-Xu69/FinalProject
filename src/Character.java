import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Character {
    private String name;
    private int tier;
    private int type;
    private int health;
    private int resource;
    private int[] stats;//first element is max health, second is max resource, third is speed, fourth is accuracy die, fifth is damage die, six is dodge die
    private ArrayList<String> moves;

    public Character(int t, int ty){
        tier = t;
        type = ty;
        stats = new int[6];
    }
    public Character(String n, int t, int ty, int h, int r, int[] st, ArrayList<String> mo){ //framework for reading characters from files
        name = n;
        tier = t;
        type = ty;
        health = h;
        resource = r;
        stats = st;
        moves = mo;
    }

    public void setHealth(int h) {
        health = h;
    }
    public void setResource(int r) {
        resource = r;
    }
    //prerequisite: s is an int array with same length as stats
    public void setStats(int[] s) {
        for (int i = 0; i < stats.length; i++) {
            stats[i] = s[i];
        }
    }
    public void setMoves(ArrayList<String> m) {
        moves = m;
    }

    public String getName() {
        return name;
    }
    public int getTier() {
        return tier;
    }
    public String getType() {
        if (type == 1){
            return "Gunslinger";
        } else if (type == 2){
            return "Melee";
        } else if (type == 3){
            return "Wizard";
        } else {
            return "Shielder";
        }
    }
    public int getHealth() {
        return health;
    }
    public int getResource() {
        return resource;
    }
    public String getStats() {
        String temp = "Stat Array: ";
        temp += Arrays.toString(stats);
        return temp;
    }
    public String getMoves() {
        String temp = "Moveset: ";
        temp += moves;
        return temp;
    }

    public String toString() {
        return getName() + "\nTier: " + getTier() + "\nType: " + getType() + "\nHealth: " + getHealth() + "\nResource: " + getResource() + "\n" + getStats() + "\n" + getMoves();
    }

    public void writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("Characters.txt");
            myWriter.write(toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
