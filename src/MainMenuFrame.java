import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame implements ActionListener {
    JButton play;
    JButton load;
    JButton quit;
    Player player;
    MainFrame mainFrame;

    MainMenuFrame(Player p){
        player = p;
        JLabel textLabel = new JLabel();
        textLabel.setText("Randomly Generated Battles");
        textLabel.setVisible(true);
        textLabel.setForeground(new Color(0,0,0));
        textLabel.setBackground(new Color(255,255,255));
        textLabel.setBounds(175,0,500,100);
        textLabel.setHorizontalTextPosition(JLabel.CENTER);
        textLabel.setVerticalTextPosition(JLabel.CENTER);
        play = new JButton();
        load = new JButton();
        quit = new JButton();
        play.setBounds(100, 120, 300, 100);
        play.setText("Play");
        load.setBounds(100, 240, 300, 100);
        load.setText("Load");
        quit.setBounds(100, 360, 300, 100);
        quit.setText("Quit");
        play.addActionListener(this);
        load.addActionListener(this);
        quit.addActionListener(this);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(textLabel);
        this.add(play);
        this.add(load);
        this.add(quit);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play){
            if (!load.getText().equals("Data loaded")) {
                player.generateNewParty();
            }
            mainFrame = new MainFrame(player);
            dispose();
        } else if (e.getSource() == load) {
            player.pullFromFile();
            load.setText("Data loaded");
        } else if (e.getSource() == quit) {
            System.exit(0);
        }
    }
}
