package A1;
import java.net.*;


public class Server {
    public static final int TCP_PORT = 9000;
    public static void main(String[] args){
        try{
            ServerSocket sS = new ServerSocket(TCP_PORT);
            System.out.println("Server se pokrece...");
            while(true){
                Socket s = sS.accept();
                ServerNit nitSer = new ServerNit(s);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
