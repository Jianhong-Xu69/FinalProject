import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener{
    JButton party1;
    JButton party2;
    JButton party3;
    Player player;
    JButton enemy1;
    JButton enemy2;
    JButton enemy3;
    Player ai;
    JButton target;
    JButton saveQuit;
    MovesFrame moves;

    MainFrame(Player p) {
        player = p;
        for (int i = 0; i < 3; i++) {
            ImageIcon character;
            JLabel partymember;
            if (player.getParty()[i] instanceof Gunslinger) {
                character = new ImageIcon("src/sprites/GSidle.png");//rightclick on image, copy path from source root
            } else if (player.getParty()[i] instanceof Melee) {
                character = new ImageIcon("src/sprites/MeleeIdle.png");
            } else {
                character = new ImageIcon("src/sprites/Wizidle.png");
            }

            partymember = new JLabel();
            partymember.setText(player.getParty()[i].getName());
            partymember.setIcon(character);
            partymember.setForeground(new Color(0, 0, 0));
            partymember.setBackground(new Color(255, 255, 255));
            partymember.setOpaque(true);
            partymember.setHorizontalTextPosition(JLabel.CENTER);
            partymember.setVerticalTextPosition(JLabel.TOP); //above, center, below
            partymember.setBounds(640-character.getIconWidth(), 305-character.getIconHeight(),  character.getIconWidth(), 330);

            if (i == 0) {
                party1 = new JButton();
                party1.setBounds(1270, 0, 680, 330);
                party1.addActionListener(this);
                party1.add(partymember);
                party1.setFocusable(false);
                party1.setBackground(Color.WHITE);
                party1.setLayout(null);
            } else if (i == 1){
                party2 = new JButton();
                party2.setBounds(1270, 330, 680, 330);
                party2.addActionListener(this);
                party2.add(partymember);
                party2.setFocusable(false);
                party2.setBackground(Color.WHITE);
                party2.setLayout(null);
            } else if (i == 2){
                party3 = new JButton();
                party3.setBounds(1270, 660, 680, 330);
                party3.addActionListener(this);
                party3.add(partymember);
                party3.setFocusable(false);
                party3.setBackground(Color.WHITE);
                party3.setLayout(null);
            }
        }
        for (int i = 0; i < 3; i++) {
            ImageIcon enemy = new ImageIcon("src/sprites/Slime.png");
            JLabel enemymember;
            ai = new Player();
            ai.generateNewParty();
            for (int j = 0; j < 3; j++) {
                enemymember = new JLabel();
                enemymember.setText(ai.getParty()[j].getName());
                enemymember.setIcon(enemy);
                enemymember.setForeground(new Color(0, 0, 0));
                enemymember.setBackground(new Color(255, 255, 255));
                enemymember.setOpaque(true);
                enemymember.setHorizontalTextPosition(JLabel.CENTER);
                enemymember.setVerticalTextPosition(JLabel.TOP); //above, center, below
                enemymember.setBounds(0, 0,  enemy.getIconWidth(), 330);

                if (i == 0) {
                    enemy1 = new JButton();
                    enemy1.setBounds(0, 0, 680, 330);
                    enemy1.addActionListener(this);
                    enemy1.add(enemymember);
                    enemy1.setFocusable(false);
                    enemy1.setBackground(Color.WHITE);
                    enemy1.setLayout(null);
                } else if (i == 1){
                    enemy2 = new JButton();
                    enemy2.setBounds(0, 330, 680, 330);
                    enemy2.addActionListener(this);
                    enemy2.add(enemymember);
                    enemy2.setFocusable(false);
                    enemy2.setBackground(Color.WHITE);
                    enemy2.setLayout(null);
                } else if (i == 2){
                    enemy3 = new JButton();
                    enemy3.setBounds(0, 660, 680, 330);
                    enemy3.addActionListener(this);
                    enemy3.add(enemymember);
                    enemy3.setFocusable(false);
                    enemy3.setBackground(Color.WHITE);
                    enemy3.setLayout(null);
                }
            }
        }
        saveQuit = new JButton();
        saveQuit.addActionListener(this);
        saveQuit.setText("Save and Quit");
        saveQuit.setBounds(900, 950, 200, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(2000,1100);
        this.setVisible(true);
        this.add(party1);
        this.add(party2);
        this.add(party3);
        this.add(enemy1);
        this.add(enemy2);
        this.add(enemy3);
        this.add(saveQuit);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== party1){
            moves = new MovesFrame(player.getParty()[0]);
        } else if (e.getSource()== party2){
            moves = new MovesFrame(player.getParty()[1]);
        } else if (e.getSource()== party3){
            moves = new MovesFrame(player.getParty()[2]);
        } else if (e.getSource()== enemy1){
            target = enemy1;
        } else if (e.getSource()== enemy2){
            target = enemy2;
        } else if (e.getSource()== enemy3) {
            target = enemy3;
        } else if (e.getSource()== saveQuit) {
            player.saveToFile();
            System.exit(0);
        }
    }
}
