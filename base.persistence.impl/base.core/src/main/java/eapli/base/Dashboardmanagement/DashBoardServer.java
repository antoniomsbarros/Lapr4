package eapli.base.Dashboardmanagement;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DashBoardServer {
    static private final String BASE_FOLDER="www";
    static private ServerSocket sock;

    public static void main(String args[]) throws IOException {
        Socket cliSock;
        try {
            sock=new ServerSocket(80);
        } catch (IOException e) {
            System.out.println("Server failed to open local port " + 80);
            System.exit(1);
        }
        while (true){
            cliSock=sock.accept();

        }
    }
}
