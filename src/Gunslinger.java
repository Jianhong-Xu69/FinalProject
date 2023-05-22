public class Gunslinger extends Character {

    public Gunslinger(String n, int[] st) {
        super(n, st);
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
        int hitroll = move1() + move1() + move1() + move2();
        return hitroll;
    }


    public String toString() {
        return "Gunslinger " + getName() + "\nHealth: " + getHealth() + "\nAmmunition: " + getResource() + "\nStats Array: " + getStats();
    }

    public String prepareForFile() {
        return 1 + super.prepareForFile();
    }
}
