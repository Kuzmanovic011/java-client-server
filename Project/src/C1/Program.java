package C1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


public class Program extends JFrame {

    public static final int brojDugmadi = 16;
    ArrayList<JButton> listaDugmadi = new ArrayList<>();
    public Program(){
        super("C1");
        setSize(500, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JButton dugmeStart = new JButton("START");
        JLabel labelaPoruka = new JLabel("PORUKA CESTITKE!");
        labelaPoruka.setFont(new Font("Arial", Font.BOLD, 25));
        labelaPoruka.setForeground(new Color(255, 19, 0));
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(4, 4));
        dugmeStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.shuffle(listaDugmadi);
                for(JButton b: listaDugmadi)
                    panel2.add(b);
            }
        });
        panel1.add(dugmeStart);
        //panel1.add(labelaPoruka);
        add("North", panel1);

        for(int i=0;i<brojDugmadi;i++){
            JButton dugme = new JButton(""+ i);
            listaDugmadi.add(dugme);
            panel2.add(dugme);

        }
        add("Center", panel2);
        setVisible(true);
    }


    public static void main(String[] args) {
            new Program();
    }

}
