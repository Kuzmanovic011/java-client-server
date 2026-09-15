package A1;
import java.net.*;
import java.io.*;

public class ServerNit extends Thread{

    PrintWriter out;
    BufferedReader in;
    Socket s;
    String podatakOdKlijenta;
    public ServerNit(Socket s){
            this.s = s;
            try{
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())), true);
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            }catch(Exception ex){
                ex.getLocalizedMessage();
            }
        start();
    }

    @Override
    public void run(){
        try {
            podatakOdKlijenta = in.readLine();
            System.out.println("Server je prihvatio: " + podatakOdKlijenta);
            int broj = Integer.parseInt(podatakOdKlijenta);
            int[] niz = {broj + 3, broj - 4, broj + 1, broj-2, broj
            , broj+2, broj-1, broj+4, broj-3};
            for(int i=0;i<niz.length;i++)
                out.println(niz[i]);

            in.close();
            out.close();
            //s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
