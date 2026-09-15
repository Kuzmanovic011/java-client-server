package B0;
import java.net.*;
import java.io.*;

public class ServerNit extends Thread {
        Socket s;
        BufferedInputStream bis;
        FileOutputStream fos;
        BufferedOutputStream bos;
    public ServerNit(Socket s) throws IOException {
            this.s = s;
            bis = new BufferedInputStream(s.getInputStream());
            File folder = new File("DATA_SERVER");
            if(!folder.mkdirs())
                folder.mkdirs();
            fos = new FileOutputStream(folder.getName() + "/primljen_fajl.bin");
            bos = new BufferedOutputStream(fos);
            start();
    }

    @Override
    public void run(){
        byte[] nizBajtova = new byte[4096];
        int br;
        try{
        while((br=bis.read(nizBajtova))!=-1)
                bos.write(nizBajtova, 0, br);
        bos.flush();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(s.getOutputStream())), true);
        out.println("POslato...");
        bos.close();
        bis.close();
        s.close();
        }catch(IOException ex){
            ex.getLocalizedMessage();
        }
        }

}
