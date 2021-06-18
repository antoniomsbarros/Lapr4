package eapli.base.DashboardManagement;

import java.io.*;
import java.net.*;


public class HTTPCLientDashboard {
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

		try { serverPort = 70; }
		catch(NumberFormatException ex) {
			System.out.println("Invalid SERVER-PORT.");
			System.exit(1);
			}

		HTTPmessage request = new HTTPmessage();
		System.out.println("Connecting to http://" + "127.0.0.1" + ":" + serverPort + "/");
			request.setRequestMethod("PUT");
		request.setURI("/votes/"+args[0]);
            	System.out.println("Casting " + args[0] + " Manual Tasks ...");
			try { sock = new Socket(serverIP, serverPort); }
			catch(IOException ex) {
            			System.out.println("Failed to connect to provided SERVER-ADDRESS and SERVER-PORT.");
            			System.out.println("Application aborted.");
            			System.exit(1);
            			}

			try {
				sOut = new DataOutputStream(sock.getOutputStream());
				sIn = new DataInputStream(sock.getInputStream());
				}
			catch(IOException ex) {
            			System.out.println("Error accessing socket's streams. Aborted.");
				try { sock.close(); } catch(IOException ex2) { System.out.println("Error closing socket."); }
            			System.out.println("Application aborted.");
            			System.exit(1);
            			}
			request.send(sOut);				// send HTTP request
	//		HTTPmessage response = new HTTPmessage(sIn);	// receive HTTP response
			try { sock.close(); } catch(IOException ex2) { System.out.println("Error closing socket."); }
			}


    	}
    
