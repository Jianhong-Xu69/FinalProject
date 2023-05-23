public class Player {

    Character[] party;

    public Player(){
        party = new Character[3];
    }


    public void generateCharacters(){
        for (int i = 0; i < 5; i++) {
            party[i] = RandomlyGenerate.randomCharacter();
        }
    }
}
