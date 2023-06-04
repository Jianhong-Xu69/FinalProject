import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovesFrame extends JFrame implements ActionListener {

    JButton move1;
    JButton move2;
    JButton move3;
    MovesFrame(Character c){
        JLabel buttonLabel;
        for (int i = 0; i < 3; i++) {
            buttonLabel = new JLabel();
            int move = c.getMoves()[i];
            if (c instanceof Gunslinger){
                if (move == 0){
                    buttonLabel.setText("Reload (Cost: 0)");
                } else if (move == 1){
                    buttonLabel.setText("Shot (Cost: 1)");
                } else if (move == 2){
                    buttonLabel.setText("Focused Fire (Cost: 2)");
                } else if (move == 3){
                    buttonLabel.setText("Rapid Fire (Cost: 5)");
                }
            } else if (c instanceof Melee){
                if (move == 0){
                    buttonLabel.setText("Slash (Cost: 0)");
                } else if (move == 1){
                    buttonLabel.setText("Cleave (Cost: 1)");
                } else if (move == 2){
                    buttonLabel.setText("Parry (Cost: 2)");
                } else if (move == 3){
                    buttonLabel.setText("Bludgeon (Cost: 5)");
                }
            } else if (c instanceof Wizard){
                if (move == 0){
                    buttonLabel.setText("Heal (Cost: 0)");
                } else if (move == 1){
                    buttonLabel.setText("Fireball (Cost: 1)");
                } else if (move == 2){
                    buttonLabel.setText("Acid Storm (Cost: 2)");
                } else if (move == 3){
                    buttonLabel.setText("Ensnare (Cost: 3)");
                }
            } else {
                buttonLabel.setText("Placeholder");
            }
            buttonLabel.setHorizontalTextPosition(JLabel.CENTER);
            buttonLabel.setVerticalTextPosition(JLabel.TOP);
            buttonLabel.setForeground(new Color(0, 0, 0));
            buttonLabel.setBackground(new Color(255, 255, 255));
            buttonLabel.setOpaque(true);
            buttonLabel.setBounds(0,0,200,110);

            if (i == 0) {
                move1 = new JButton();
                move1.setBounds(0, 0, 200, 110);
                move1.addActionListener(this);
                move1.add(buttonLabel);
                move1.setFocusable(true);
                move1.setBackground(Color.WHITE);
                move1.setLayout(null);
            } else if (i == 1){
                move2 = new JButton();
                move2.setBounds(0, 110, 200, 110);
                move2.addActionListener(this);
                move2.add(buttonLabel);
                move2.setFocusable(true);
                move2.setBackground(Color.WHITE);
                move2.setLayout(null);
            } else if (i == 2){
                move3 = new JButton();
                move3.setBounds(0, 220, 200, 110);
                move3.addActionListener(this);
                move3.add(buttonLabel);
                move3.setFocusable(true);
                move3.setBackground(Color.WHITE);
                move3.setLayout(null);
            }
        }

        this.setLayout(null);
        this.setResizable(false);
        this.setSize(200,330);
        this.setVisible(true);
        this.add(move1);
        this.add(move2);
        this.add(move3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
