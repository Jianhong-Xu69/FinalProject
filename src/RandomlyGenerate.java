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
        String names = ReadFile.readNames();
        for (int i = 0; i < 16; i++) {

        }
    }

    public static Character randomCharacter(){
        int cl = (int) (Math.random()*3)+1;
        int[] stats = randomStats();
        Character random;
        if (cl == 1){
            random = new Gunslinger()
        } else if (cl == 2) {

        } else {

        }
        return random;
    }
}
