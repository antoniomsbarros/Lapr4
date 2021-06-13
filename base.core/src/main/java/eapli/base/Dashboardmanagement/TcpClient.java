package eapli.base.DashboardManagement;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.CollaboratorEmail;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserSession;

import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TcpClient {
	static InetAddress serverIP;
	static Socket sock;
	//private  ClientUserRepository clientUserRepository;
	//private  AuthorizationService authorizationService;
	//private static ClientUser collaborator;

	public TcpClient() {
		//this.clientUserRepository = PersistenceContext.repositories().clientUsers();
		//this.authorizationService= AuthzRegistry.authorizationService();
		//collaborator=currentCollaborator();

	}
	public static  String[] tcpConnecting(int code , String data, String IPAdress) throws IOException {
		try { serverIP = InetAddress.getByName(IPAdress); }
		catch(UnknownHostException ex) {
			System.out.println("Invalid server specified: " + IPAdress);
			System.exit(1); }

		try { sock = new Socket(serverIP, 70); }
		catch(IOException ex) {
			System.out.println("Failed to establish TCP connection");
			System.exit(1); }


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
		DataInputStream sIn = new DataInputStream(sock.getInputStream());

		protocol protocol =new protocol(code);
		protocol.send(sOut, data);
		protocol = new protocol(sIn);
		String[] temp=protocol.getData().split(",,");
		String result=temp[0];
		result.replace("[", "");
		result.replace("]", "");
		return result.split(", ");
	}


/*
	private  ClientUser currentCollaborator(){
		UserSession session= authorizationService.session(). get();
		CollaboratorEmail collaboratorEmail=new CollaboratorEmail(session.authenticatedUser().email().toString());
		ClientUser clientUser= clientUserRepository.getClientUserByEmail(collaboratorEmail).get();
		return clientUser;
	}
*/

	}

