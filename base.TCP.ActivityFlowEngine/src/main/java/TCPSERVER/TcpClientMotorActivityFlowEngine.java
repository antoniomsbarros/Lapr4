package TCPSERVER;

import eapli.base.DashboardManagement.Protocol;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClientMotorActivityFlowEngine {
	static InetAddress serverIP;
	static SSLSocket sock;
	static final String KEYSTORE_PASS="forgotten";
	static final int SERVER_PORT=80;
	static final String IPAdress="10.9.21.116";//endereço do servidor gestor de tarefas automaticas
	static final String IP="127.0.0.1";
	public TcpClientMotorActivityFlowEngine() {
	}
	public static  String[] tcpConnecting(int code , String data) throws IOException {
		try { serverIP = InetAddress.getByName(IPAdress); }
		catch(UnknownHostException ex) {
			System.out.println("Invalid server specified: " + IPAdress);
			System.exit(1); }

		// Trust these certificates provided by servers
		System.setProperty("javax.net.ssl.trustStore", "server.jks");
		System.setProperty("javax.net.ssl.trustStorePassword",KEYSTORE_PASS);

		// Use this certificate and private key for client certificate when requested by the server
		System.setProperty("javax.net.ssl.keyStore","server.jks");
		System.setProperty("javax.net.ssl.keyStorePassword",KEYSTORE_PASS);
		SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();

		try { serverIP = InetAddress.getByName(IPAdress); }
		catch(UnknownHostException ex) {
			System.out.println("Invalid server specified: " + IPAdress);
			System.exit(1); }
		try { sock = (SSLSocket) sf.createSocket(serverIP,SERVER_PORT); }
		catch(IOException ex) {
			System.out.println("Failed to establish TCP connection");
			System.exit(1); }
		sock.startHandshake();

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
		DataInputStream sIn = new DataInputStream(sock.getInputStream());

		Protocol protocol =new Protocol(code);
		protocol.send(sOut, data);
		protocol = new Protocol(sIn);
		String[] temp=protocol.getData().split(",,");
		String result=temp[0];
		result.replace("[", "");
		result.replace("]", "");
		return result.split(", ");
	}


	}

