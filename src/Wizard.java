public class Wizard extends Character{

    public Wizard(String n, int[] st) {
        super(n, st);
    }

    public int move0() {//heal, free
        setResource(getSpecificStat(1));
        return 0;
    }

    public int move1(){//fireball, cost 1 mana to use
        int hitRoll = (int) (Math.random()*getSpecificStat(3)+1);
        setResource(getResource()-1);
        return hitRoll;
    }

    public int move2(){//acid storm, cost 2 mana to use
        int hitroll = (int) (move1()*1.5 + move1()*1.5);
        return hitroll;
    }

    public int move3(){//ensnare, cost 3 mana, stuns
        int hitroll = move1() + move2();
        return hitroll;
    }


    public String toString() {
        return "Wizard " + getName() + "\nHealth: " + getHealth() + "\nMana: " + getResource() + "\nStats Array: " + getStats();
    }

    public String prepareForFile() {
        return 3 + super.prepareForFile();
    }
}