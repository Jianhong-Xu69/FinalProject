import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener{
    JButton party1;
    JButton party2;
    JButton party3;
    Character[] party;

    public void mainGUI(Character[] p) {
        party = p;
        for (int i = 0; i < 3; i++) {
            ImageIcon character;
            JLabel partymember;
            if (p[i] instanceof Gunslinger) {
                character = new ImageIcon("src/sprites/GSidle.png");//rightclick on image, copy path from source root
            } else if (p[i] instanceof Melee) {
                character = new ImageIcon("src/sprites/MeleeIdle.png");
            } else {
                character = new ImageIcon("src/sprites/Wizidle.png");
            }

            partymember = new JLabel();
            partymember.setText(p[i].getName());
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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(2000,1100);
        this.setVisible(true);
        this.add(party1);
        this.add(party2);
        this.add(party3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== party1){
            new MovesFrame(party[0]);
        } else if (e.getSource()== party2){
            System.out.println("Test");
        } else if (e.getSource()== party3){
            System.out.println("Ow");
        }
    }
}
