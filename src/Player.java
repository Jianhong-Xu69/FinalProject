import java.util.Random;

public class Player {

    private Character[] party;

    public Player(){
        party = new Character[3];
    }

    public void generateNewParty(){
        for (int i = 0; i < party.length; i++) {
            party[i] = RandomlyGenerate.randomCharacter();
        }
    }

    public void replacePartyMember(Character c, int i){
        party[i-1] = c;
    }

    public Character[] getParty() {
        return party;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < party.length; i++) {
            temp += party[i] + "\n\n";
        }
        return temp;
    }

    public void saveToFile() {
        ReadFile.writeToFile(ReadFile.prepWriteFile(party));
    }

    public void pullFromFile() {
        Character[] file = ReadFile.fileRead();
        for (int i = 0; i < party.length; i++) {
            party[i] = file[i];
        }
    }
}
