public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        Player test = new Player();
        test.pullFromFile();
        for (int i = 0; i < 3; i++) {
            test.getParty()[i].rollMoves();
        }
        MainFrame t2 = new MainFrame();
        t2.mainGUI(test.getParty());
    }
}
