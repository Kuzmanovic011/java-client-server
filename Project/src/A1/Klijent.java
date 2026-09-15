package A1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Klijent extends JFrame {
    public static final int TCP_PORT =9000;

    private JButton dugme;
    private JLabel labela;
    private JTextField tekstPolje;
    private JPanel panel;
    private JPanel panel1;
    private int vrednost;
    private PrintWriter out;
    private BufferedReader in;
    private static Socket s;
    private boolean prvoPostavljanje = false;

    public Klijent(){
        super("A1Klijent");
        JLabel[] nizLabela = new JLabel[9];
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panel = new JPanel();
        panel.setBackground(new Color(251, 255, 0));
        panel.setLayout(new FlowLayout());
        tekstPolje = new JTextField();
        tekstPolje.setPreferredSize(new Dimension(100, 25));
        dugme = new JButton("Potvrdi");
        dugme.setSize(50, 50);
        panel.add(tekstPolje);
        panel.add(dugme);
        add("North", panel);
        panel1 = new JPanel();
        panel1.setBackground(new Color(255, 58, 0));
        panel1.setLayout(new GridLayout(3, 3));
        add("Center", panel1);
        dugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    vrednost = Integer.parseInt(tekstPolje.getText());
                }catch(NumberFormatException ex){
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "pogresan unos! | " + tekstPolje.getText() + " |");
                    return;
                }
                if(vrednost<5 || vrednost > 30){
                    JOptionPane.showMessageDialog(null, "Ne sme broj biti van dozvoljenih granica!");
                    revalidate();
                    repaint();

                    return;
                }
                    JOptionPane.showMessageDialog(null, "Uspeh! uneli ste broj: " + vrednost);
                try {
                    InetAddress adresa = InetAddress.getByName("127.0.0.1");
                    s = new Socket(adresa, TCP_PORT);
                    out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())), true);
                    in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                    System.out.println("KlijentB0 salje zahtev...");
                    out.println(vrednost);

                    if(!prvoPostavljanje){
                    for(int i=0;i<9;i++){

                        nizLabela[i] = new JLabel("" + in.readLine());
                        nizLabela[i].setHorizontalAlignment(SwingConstants.CENTER);
                        panel1.add(nizLabela[i]);
                        //panel1.add(new Label("" + k));

                    }
                    prvoPostavljanje = true;
                    }
                    else if(prvoPostavljanje){
                        for(int i=0;i<9;i++){
                        nizLabela[i].setText(in.readLine());
                        }
                    }

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                revalidate();
                repaint();
            }
        });


        setVisible(true);
    }
    public static void main(String[] args){
            new Klijent();
    }
}


