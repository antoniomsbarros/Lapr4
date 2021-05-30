package eapli.base.Dashboardmanagement;

import java.io.*;
import java.net.*;


public class DemoConsumer {
	static private Socket sock;
	static private InetAddress serverIP;
	static private int serverPort;
	static private DataOutputStream sOut;
	static private DataInputStream sIn;

	// THE NUMBER OF VOTES TO CAST ON THE FIRST CANDIDATE
	static private final int VOTES_TO_CAST = 200;

	public static void main(String args[]) throws Exception {



		try { serverIP = InetAddress.getByName("127.0.0.1"); }
		catch(UnknownHostException ex) {
			System.out.println("Invalid SERVER-ADDRESS.");
			System.exit(1);
			}

		try { serverPort = 80; }
		catch(NumberFormatException ex) {
			System.out.println("Invalid SERVER-PORT.");
			System.exit(1);
			}
		System.out.println("Connecting to http://" + "127.0.0.1" + ":" + serverPort + "/");
		HTTPmessage request = new HTTPmessage();
        	} // MAIN METHOD
    	} // CLASS
    
