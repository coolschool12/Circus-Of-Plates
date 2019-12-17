package eg.edu.alexu.csd.oop.game.world.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class LevelPanel extends JPanel {

    private BufferedImage image;
    private String level;
    public LevelPanel() {
        try {
            image = ImageIO.read(new File("lego.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = Objects.requireNonNull(image).getScaledInstance(500, 700, Image.SCALE_SMOOTH);
        ImageIcon img = new ImageIcon(dimg);
        JLabel picLabel = new JLabel(img);
        picLabel.setBounds(0,0,500,700);

        this.add(picLabel);
        this.setBounds(0,0,500,700);
        this.setLayout(null);

        String[] levelName = {"Easy","Medium","Hard"};
        for(int i=0;i<3;i++){
            JButton button = new JButton(levelName[i]);
            button.setBounds(150,150+(i*110),200,60);
            button.setBackground(Color.YELLOW);
            picLabel.add(button);
            final int f =i;
            button.addActionListener(e -> System.out.println(levelName[f]));
            button.setContentAreaFilled(false);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setForeground(Color.white);
            button.setBorder(BorderFactory.createBevelBorder(1)); // Inner Bevel Border
        }
    }

    public static void main (String []args){

        LevelPanel l = new LevelPanel();
        MainGui g = new MainGui();
        JFrame f =  new JFrame();

        f.add(g);


        f.setLayout(null);
        f.setBounds(0, 0, 500, 700);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Choose Level");

        f.setVisible(true);




    }


}
