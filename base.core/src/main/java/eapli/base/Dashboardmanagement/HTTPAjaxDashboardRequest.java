package eapli.base.Dashboardmanagement;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HTTPAjaxDashboardRequest extends Thread{
     String baseFolder;
    Socket sock;
    DataInputStream inS;
    DataOutputStream outS;

    public HTTPAjaxDashboardRequest(Socket s,String string ){
        sock=s;
        baseFolder=string;
    }

    public void run(){
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        }
        catch(IOException ex) { System.out.println("Thread error on data streams creation"); }
        try {
            HTTPmessage request = new HTTPmessage(inS);
            HTTPmessage response = new HTTPmessage();

            //codigo

            //pedidos get e put
        }
        catch(IOException ex) { System.out.println("Thread error when reading request"); }
        try { sock.close();}
        catch(IOException ex) { System.out.println("CLOSE IOException"); }
    }
}
