import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PartyGUI implements ActionListener{
    public static void main(String[] args) {
        characterDisplay();
    }
    public static void characterDisplay() {
        ImageIcon lolang = new ImageIcon("src/sprites/GSidle.png");//rightclick on image, copy path from source root

        JPanel lolangpanel = new JPanel();
        lolangpanel.setBackground(Color.lightGray);
        lolangpanel.setBounds(880,0,110,330);
        lolangpanel.setLayout(null);

        JLabel roland = new JLabel();
        roland.setText("Lolang");
        roland.setIcon(lolang);
        roland.setForeground(new Color(0, 150, 255));
        roland.setBackground(new Color(255,255,255));
        roland.setOpaque(true);
        roland.setHorizontalTextPosition(JLabel.CENTER);
        roland.setVerticalTextPosition(JLabel.TOP); //above, center, below
//        roland.setIconTextGap(10); //distance from text to image
        roland.setBounds(0,0, 110, 330);//overrides alignments (x,y,wide,height) (needs null


        JFrame frame = new JFrame();
        frame.setTitle("Testing frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.WHITE);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
        lolangpanel.add(roland);
        frame.add(lolangpanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
