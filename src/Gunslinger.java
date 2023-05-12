import java.io.FileWriter;
import java.io.IOException;

public class Gunslinger extends Character {

    public Gunslinger(String n, int t, int[] st, int[] mo) {
        super(n, t, st, mo);
    }

    public int move0() {//reload, replenishes all resources(ammunition)
        setResource(getSpecificStat(1));
        return 0;
    }

    public int move1(){//shot, consumes 1 ammunition to fire
        int hitRoll = (int) (Math.random()*getSpecificStat(3)+1);
        setResource(getResource()-1);
        return hitRoll;
    }

    public int move2(){//focusedFire, consumes 2 ammunition to fire an accurate burst
        int hitroll = (int) (move1()*1.5 + move1()*1.5);
        return hitroll;
    }

    public int move3(){//rapidFire, consumes 5 ammunition to fire a rapid burst
        int hitroll = move1() + move1() + move1() + move1() + move1();
        return hitroll;
    }

    public int move4(){//preciseBurst, consumes 3 ammunition to fire a precise burst
        int hitroll = move2() + move1();
        return hitroll;
    }

    public int move5(){//magdump, consumes all ammunition and fires off entire magazine
        int hitroll = 0;
        int currentMag = getResource();
        for (int i = 0; i < currentMag; i++) {
            int coin = (int) (Math.random()*2) + 1;
            if (coin == 1){
                hitroll += move1();
            } else {
                hitroll += (int) (move1() * 1.5);
            }
        }
        return hitroll;
    }

    public String toString() {
        return "Gunslinger " + getName() + "\nTier: " + getTier() + "\nHealth: " + getHealth() + "\nAmmunition: " + getResource() + "\nStats Array: " + getStats() + "\nMoveset: " + getMoves();
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
