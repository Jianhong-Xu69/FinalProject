public class Combat {

    private Player player;
    private Player ai;
    private Character[] turnOrder;

    public Combat (Player p){
        player = p;
        ai = new Player();
        ai.generateNewParty();
        turnOrder = new Character[6];
    }

    public Character[] generateTurnOrder(){
        for (int i = 0; i < player.getParty().length; i++) {
            turnOrder[i] = player.getParty()[i];
            turnOrder[i+3] = ai.getParty()[i];
        }
        for (int i = 0; i < turnOrder.length; i++) {
            turnOrder[i].rollSpeed();
        }
        int pos; //stolen selection sort
        Character temp;
        for (int i = 0; i < turnOrder.length; i++) {
            pos = i;
            for (int j = i+1; j < turnOrder.length; j++)
            {
                if (turnOrder[j].getSpeed() < turnOrder[pos].getSpeed()) {
                    pos = j;
                }
            }

            temp = turnOrder[pos];
            turnOrder[pos] = turnOrder[i];
            turnOrder[i] = temp;
        }
        return turnOrder;
    }

    public int makeMove(Character c, int i){
        if (c.getMoves()[i] == 0){
            return c.move0();
        } else if (c.getMoves()[i] == 1){
            return c.move1();
        } else if (c.getMoves()[i] == 2){
            return c.move2();
        } else if (c.getMoves()[i] == 3){
            return c.move3();
        }
        return 0;
    }
}
