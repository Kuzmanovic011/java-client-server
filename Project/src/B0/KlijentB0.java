package B0;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class KlijentB0 extends JFrame {

    private JLabel labela;
    private JButton dugme;
    private FileDialog fajlDijalog;

    public KlijentB0() {
        super("KlijentB0");
        setLayout(new FlowLayout());
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dugme = new JButton("Odaberite fajl");
        dugme.addActionListener( e ->{
            fajlDijalog = new FileDialog(this, "Izaberite fajl");
            fajlDijalog.setVisible(true);
            fajlDijalog.setDirectory("DATA_KLIJENT");
            String dir = fajlDijalog.getDirectory();
            String fl = fajlDijalog.getFile();
            if(fl!=null){
            File dat = new File(dir, fl);
                try {
                    Socket s = new Socket("127.0.0.1", 9000);
                    //cita bajtove iz fajla
                    FileInputStream fis = new FileInputStream(dat);
                    //cita u blokovima = brze citanje
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    //salje bajtove serveru preko soketa
                    BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());

                    byte[] nizBajtova = new byte[4096];
                    int br;

                    while((br=bis.read(nizBajtova))!=-1)
                        bos.write(nizBajtova, 0, br);
                    bos.flush();
                    s.shutdownOutput();
                    labela.setText("Uspesno je primljen fajl!");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }else{
                labela.setText("Niste izabrali fajl!");
                return;
            }
        });
        add(dugme);
        labela = new JLabel("LABELA");
        add(labela);
        setVisible(true);
    }
    public static void main(String[] args){
        new KlijentB0();
    }
}
