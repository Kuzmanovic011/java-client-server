package B0;

import java.io.*;
import java.net.*;

public class Server {



    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(9000);
        while(true){
            Socket s = ss.accept();
            System.out.println("Prihvaceno....");
            ServerNit srv = new ServerNit(s);

    }
    }

}