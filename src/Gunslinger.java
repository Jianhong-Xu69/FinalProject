import java.io.FileWriter;
import java.io.IOException;

public class Gunslinger extends Character {

    public Gunslinger(String n, int t, int h, int r, int[] st, int[] mo) {
        super(n, t, h, r, st, mo);
    }

    public String reload() {
        setResource(getSpecificStat(2));
        return "reloaded";
    }

    public int shot(boolean attack, int c){//attacking or not, clash to hit
        int hitRoll = (int) (Math.random()*6+1);
        setResource(getResource()-1);
        if (attack){
            if (hitRoll > c){
                return (int) (Math.random()*getSpecificStat(4)+1);
            } else {
                return 0;
            }
        } else {
            if (hitRoll > c){
                return (int) (Math.random()*getSpecificStat(4)+1);
            } else if (hitRoll == c){
                return 0;
            } else {
                return -1;
            }
        }
    }

    public int focusFire(boolean attack, int c){//attacking or not, clash to hit
        int hitRoll = (int) (Math.random()*getSpecificStat(3)*1.5+1);
        setResource(getResource()-1);
        if (attack){
            if (hitRoll > c){
                return (int) (Math.random()*getSpecificStat(4)+1);
            } else {
                return 0;
            }
        } else {
            if (hitRoll/2 > c){
                return (int) (Math.random()*getSpecificStat(4)+1);
            } else if (hitRoll == c){
                return 0;
            } else {
                return -1;
            }
        }
    }

    public String toString() {
        return "Gunslinger " + super.toString();
    }

    public String writeToFile() {
        try {
            FileWriter myWriter = new FileWriter("Characters.txt");
            myWriter.write(1 + getName() + "\n" + getTier() + "\n" + getHealth() + "\n" + getResource() + "\n" + getStats() + "\n" + getMoves());
            myWriter.close();
            return "Successfully wrote to the file.";
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred.";
        }
    }
}
