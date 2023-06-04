public class FrontDoor {//Misc Test class
    public static void main(String[] args) {
        Player test = new Player();
        test.pullFromFile();
        test.getParty()[0].rollMoves();
        MainFrame t2 = new MainFrame();
        t2.mainGUI(test.getParty());
    }
}
