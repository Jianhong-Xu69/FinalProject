import java.lang.reflect.Array;
import java.util.ArrayList;

public class RandomlyGenerate {

    public static int[] randomStats(){
        int[] stats = new int[4];
        double total = 30;
        stats[0] = (int) ((Math.random()*11)+5);
        total -= stats[0];
        for (int i = 1; i < 3; i++) {
            stats[i] = (int) ((Math.random()*total/1.5)+1);
            total -= stats[i];
        }
        stats[3] = (int) total;
        return stats;
    }

    public static String randomName(){
        ArrayList<String> names = ReadFile.readNames();
        return names.get((int) (Math.random()*names.size()));
    }

    public static Character randomCharacter(){
        int cl = (int) (Math.random()*3)+1;
        int[] stats = randomStats();
        Character random;
        String name = randomName();
        if (cl == 1){
            random = new Gunslinger(name, stats);
        } else if (cl == 2) {
            random = new Melee(name, stats);
        } else {
            random = new Wizard(name, stats);
        }
        return random;
    }
}
