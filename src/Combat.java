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

    public int makeMove(Character c, int i){//choose element i of Moves list to make move.
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

    public int findTarget(){//recursive target search
        int target = (int) (Math.random()*3);
        int random = 0;
        if (player.getParty()[target] instanceof Wizard && !player.getParty()[target].isDefeated()){
            random = (int) (Math.random()*2)+1;
            if (random != 2){
                return target;
            } else {
                target = findTarget();
            }
        } else if (player.getParty()[target] instanceof Gunslinger && !player.getParty()[target].isDefeated()) {
            random = (int) (Math.random()*3)+1;
            if (random != 3){
                return target;
            } else {
                target = findTarget();
            }
        } else if (player.getParty()[target] instanceof Melee && !player.getParty()[target].isDefeated()) {
            random = (int) (Math.random()*4)+1;
            if (random != 4){
                return target;
            } else {
                target = findTarget();
            }
        }
        return target;
    }
}
