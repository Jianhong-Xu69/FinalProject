import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovesFrame extends JFrame implements ActionListener {

    JButton move1;
    JButton move2;
    JButton move3;
    Character character;
    MovesFrame(Character character){
        this.character = character;
        character.rollMoves();
        JLabel buttonLabel;
        for (int i = 0; i < 3; i++) {
            buttonLabel = new JLabel();
            int move = character.getMoves()[i];
            if (character instanceof Gunslinger){
                if (move == 0){
                    buttonLabel.setText("Reload (Cost: 0)");
                } else if (move == 1){
                    buttonLabel.setText("Shot (Cost: 1)");
                } else if (move == 2){
                    buttonLabel.setText("Focused Fire (Cost: 2)");
                } else if (move == 3){
                    buttonLabel.setText("Rapid Fire (Cost: 5)");
                }
                this.setTitle("Ammunition: " + character.getResource());
                buttonLabel.setBackground(new Color((int) (Math.random()*50)+100, (int) (Math.random()*50)+100, 255));
            } else if (character instanceof Melee){
                if (move == 0){
                    buttonLabel.setText("Slash (Cost: 0)");
                } else if (move == 1){
                    buttonLabel.setText("Cleave (Cost: 1)");
                } else if (move == 2){
                    buttonLabel.setText("Parry (Cost: 2)");
                } else if (move == 3){
                    buttonLabel.setText("Bludgeon (Cost: 5)");
                }
                buttonLabel.setBackground(new Color(255, (int) (Math.random()*50)+100, (int) (Math.random()*50)+100));
                this.setTitle("Stamina: " + character.getResource());
            } else if (character instanceof Wizard){
                if (move == 0){
                    buttonLabel.setText("Heal (Cost: 0)");
                } else if (move == 1){
                    buttonLabel.setText("Fireball (Cost: 1)");
                } else if (move == 2){
                    buttonLabel.setText("Acid Storm (Cost: 2)");
                } else if (move == 3){
                    buttonLabel.setText("Ensnare (Cost: 3)");
                }
                this.setTitle("Mana: " + character.getResource());
                buttonLabel.setBackground(new Color((int) (Math.random()*50)+100, 255, (int) (Math.random()*50)+100));
            } else {
                buttonLabel.setText("Placeholder");
            }
            buttonLabel.setHorizontalTextPosition(JLabel.CENTER);
            buttonLabel.setVerticalTextPosition(JLabel.CENTER);
            buttonLabel.setForeground(new Color(0, 0, 0));
            buttonLabel.setOpaque(true);
            buttonLabel.setBounds(0,0,300,100);

            if (i == 0) {
                move1 = new JButton();
                move1.setBounds(0, 0, 300, 100);
                move1.addActionListener(this);
                move1.add(buttonLabel);
                move1.setFocusable(true);
                move1.setBackground(Color.WHITE);
                move1.setLayout(null);
            } else if (i == 1){
                move2 = new JButton();
                move2.setBounds(0, 100, 300, 100);
                move2.addActionListener(this);
                move2.add(buttonLabel);
                move2.setFocusable(true);
                move2.setBackground(Color.WHITE);
                move2.setLayout(null);
            } else if (i == 2){
                move3 = new JButton();
                move3.setBounds(0, 200, 300, 100);
                move3.addActionListener(this);
                move3.add(buttonLabel);
                move3.setFocusable(true);
                move3.setBackground(Color.WHITE);
                move3.setLayout(null);
            }
        }

        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(300,330);
        this.setVisible(true);
        this.add(move1);
        this.add(move2);
        this.add(move3);

    }

    public int movePerformed(int i){
        return character.getMoves()[i];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == move1){
            movePerformed(0);
            dispose();
        } else if (e.getSource() == move2) {
            movePerformed(1);
            dispose();
        } else if (e.getSource() == move3){
            movePerformed(2);
            dispose();
        }
    }
}
