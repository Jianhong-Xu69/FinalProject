public class Character {
    private int tier;
    private int type;
    private int resource;
    private int[] stats;
    private String[] moves;

    public Character(int t, int ty){
        tier = t;
        type = ty;
    }

    public void setStats(int[] s) {
        stats = s;
    }
    public void setMoves(String[] m) {
        moves = m;
    }

    public int[] getStats() {
        return stats;
    }
    public String[] getMoves() {
        return moves;
    }
}
