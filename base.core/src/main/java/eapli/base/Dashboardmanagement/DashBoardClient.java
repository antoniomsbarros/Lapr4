package eapli.base.Dashboardmanagement;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class DashBoardClient {
    static private Socket sock;
    static private InetAddress serverIP;
    static private int serverPort;
    static private DataOutputStream sOut;
    static private DataInputStream sIn;


    public static void main(String args[]) throws Exception {

      serverIP=InetAddress.getByName("127.0.0.1");
      serverPort=80;
      HTTPmessage request = new HTTPmessage();


    }
}
