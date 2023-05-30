import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PartyGUI {
    public static void main(String[] args) {
        ImageIcon lolang = new ImageIcon("src/sprites/GSidle.png");//rightclick on image, copy path from source root
        Border border = BorderFactory.createLineBorder(Color.blue, 4);

        JPanel rpanel = new JPanel();
        rpanel.setBackground(Color.red);
        rpanel.setBounds(0,0,100,100);

        JPanel lolangpanel = new JPanel();
        lolangpanel.setBackground(Color.lightGray);
        lolangpanel.setBounds(100,100,500,500);
        lolangpanel.setLayout(null);

        JLabel label = new JLabel();
        label.setText("Krill");
        label.setIcon(lolang);
        label.setForeground(new Color(0, 150, 255));
        label.setBackground(new Color(255,255,255));
        label.setOpaque(true);
        label.setBorder(border);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP); //above, center, below
//        label.setIconTextGap(10); //distance from text to image
//        label.setVerticalAlignment(JLabel.BOTTOM);
//        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0,0, 110, 330);//overrides alignments (x,y,wide,height) (needs null


        JFrame frame = new JFrame();
        frame.setTitle("Testing frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(1000,1000);
        frame.setLayout(null);
        frame.setVisible(true);
        lolangpanel.add(label);
        frame.add(rpanel);
        frame.add(lolangpanel);
    }
}
