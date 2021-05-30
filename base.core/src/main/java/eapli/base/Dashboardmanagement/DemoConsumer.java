package eapli.base.Dashboardmanagement;

import java.io.*;
import java.net.*;

/**
 *
 * @author asc@isep.ipp.pt
 */
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

		try { serverPort = 70; }
		catch(NumberFormatException ex) {
			System.out.println("Invalid SERVER-PORT.");
			System.exit(1);
			}
		System.out.println("Connecting to http://" + "127.0.0.1" + ":" + serverPort + "/");
		HTTPmessage request = new HTTPmessage();
		/*request.setRequestMethod("PUT");
		request.setURI("/votes/1");
            	System.out.println("Casting " + VOTES_TO_CAST + " votes on the first candidate ...");


		for(int i=0; i<VOTES_TO_CAST; i++) {
            		System.out.println("Connecting to http://" + "127.0.0.1" + ":" + serverPort + "/");
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
			System.out.println("Casting a vote");
			request.send(sOut);				// send HTTP request
			HTTPmessage response = new HTTPmessage(sIn);	// receive HTTP response
			System.out.println("HTTP server response status: " + response.getStatus());
			try { sock.close(); } catch(IOException ex2) { System.out.println("Error closing socket."); }
			}
*/
        	} // MAIN METHOD
    	} // CLASS
    
