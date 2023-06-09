import java.util.Arrays;

public class Character {
    private String name;
    private int health;
    private int resource;
    private int[] stats;//0 element is max health, 1 is max resource, 2 is speed, 3 is damage die
    private int speed;
    private int[] moves;//rolls moveset, usually 3
    private boolean defeated;

    public Character(String n, int[] st){ //framework for reading characters from files
        name = n;
        health = st[0];
        resource = st[1];
        stats = st;
        moves = new int[5];
        defeated = false;
    }

    public void setHealth(int h) {
        health = h;
        if (health <= 0){
            defeated = true;
        } else {
            defeated = false;
        }
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
    public void rollSpeed(){
        speed = (int) (Math.random()*20+getSpecificStat(2));
    }
    public void rollMoves(){
        for (int i = 0; i < moves.length; i++) {
            int move = (int) (Math.random()*4);
            boolean contains = false;
            for (int m: moves){
                if (move == m){
                    contains = true;
                }
            }
            if (!contains) {
                moves[i] = move;
            }
        }
    }

    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getResource() {
        return resource;
    }
    public String getStats() {
        return Arrays.toString(stats);
    }
    //prerequisite: 0 <= s <= 5
    public int getSpecificStat(int s){
        return stats[s];
    }

    public boolean isDefeated() {
        return defeated;
    }

    public int move0(){
        return 0;
    }
    public int move1(){
        return 0;
    }
    public int move2(){
        return 0;
    }
    public int move3(){
        return 0;
    }

    public int[] getMoves() {
        return moves;
    }
    public int getSpeed() {
        return speed;
    }

    public String toString() {
        return getName() + "\nHealth: " + getHealth() + "\nResource: " + getResource() + "\nStats Array: " + getStats();
    }

    public String prepareForFile() {
            return getName() + "\n" + getStats();
    }
}
