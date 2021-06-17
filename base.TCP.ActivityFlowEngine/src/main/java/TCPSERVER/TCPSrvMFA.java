package TCPSERVER;

import eapli.base.DashboardManagement.Protocol;
import eapli.base.infrastructure.persistence.PersistenceContext;

import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.*;
import java.util.*;

@UseCaseController
@SuppressWarnings("squid:S106")
public final class TCPSrvMFA {
	static ServerSocket sock;
	static final String TRUSTED_STORE="server.jks";
	static final String KEYSTORE_PASS="forgotten";

	public static void main(String args[]) throws Exception {
		SSLServerSocket sock=null;
		Socket cliSock;
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
				new PlainTextEncoder());


		System.setProperty("javax.net.ssl.trustStore", TRUSTED_STORE);
		System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

		// Use this certificate and private key as server certificate
		System.setProperty("javax.net.ssl.keyStore",TRUSTED_STORE);
		System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);
		SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		try { sock = (SSLServerSocket) sslF.createServerSocket(70);
			sock.setNeedClientAuth(true); }
		catch(IOException ex) {
			System.out.println("Failed to open server socket");
			System.exit(1);
			}
		while(true) {
			cliSock=sock.accept();
			new Thread(new TCPSrvMFAThread(cliSock)).start();
			}
		} 
	}



class TCPSrvMFAThread implements Runnable {
	private Socket s;
	private DataOutputStream sOut;
	private DataInputStream sIn;
	private Dashboardsearch dashboardsearch;
	RequestWorkflow requestWorkflow=new RequestWorkflow();
	TCPSrvMFAThread(Socket cli_s) {
		s=cli_s;
		dashboardsearch=new Dashboardsearch();
		requestWorkflow=new RequestWorkflow();
	}

	public void run() {
		InetAddress clientIP;
		clientIP=s.getInetAddress();
		System.out.println("New client connection from " + clientIP.getHostAddress() + 
			", port number " + s.getPort());
		try {
			sOut = new DataOutputStream(s.getOutputStream());
			sIn = new DataInputStream(s.getInputStream());

			Protocol protocol =new Protocol(sIn);
			int code= protocol.getCode();
			switch (code){
				case 3:
					String[] data=protocol.getData().split(" ");
					protocol.send(sOut, Arrays.toString(dashboardsearch.data(Integer.valueOf(data[0]),data[1])));
					break;
				case 6:
						String data3=protocol.getData();
						requestWorkflow.createWorkflowPedido(data3);
					break;
				default:
					protocol.send(sOut,"Code invalido");
					break;
			}
			System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() + 
				" disconnected");
			s.close();
			}
		catch(IOException ex) { System.out.println("IOException"); }
		}

}



