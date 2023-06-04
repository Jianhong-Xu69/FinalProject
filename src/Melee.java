public class Melee extends Character {

    public Melee (String n, int[] st) {
        super(n, st);
    }

    public int move0() {//slash, cost 0 stamina
        int hitRoll = (int) (Math.random()*getSpecificStat(3)+1);
        return hitRoll;
    }

    public int move1(){//cleave, cost 1 stamina
        int hitRoll = move0() + move0();
        setResource(getResource()-1);
        return hitRoll;
    }
    public int move2(){//parry, cost 1 stamina
        int hitRoll = move0();
        setResource(getResource()+1);
        return hitRoll;
    }
    public int move3(){//bludgeon, cost 2 stamina
        int hitRoll = move1() + move0();
        setResource(getResource()-1);
        return hitRoll;
    }

    public String toString() {
        return "Melee " + getName() + "\nHealth: " + getHealth() + "\nStamina: " + getResource() + "\nStats Array: " + getStats();
    }

    public String prepareForFile() {
        return 2 + super.prepareForFile();
    }
}
