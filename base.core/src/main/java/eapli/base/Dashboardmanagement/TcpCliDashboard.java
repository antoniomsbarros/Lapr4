package eapli.base.Dashboardmanagement;

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

class TcpCliDashboard {
	static InetAddress serverIP;
	static Socket sock;
	//private  ClientUserRepository clientUserRepository;
	//private  AuthorizationService authorizationService;
	//private static ClientUser collaborator;

	public TcpCliDashboard() {
		//this.clientUserRepository = PersistenceContext.repositories().clientUsers();
		//this.authorizationService= AuthzRegistry.authorizationService();
		//collaborator=currentCollaborator();

	}

	public static  String[] tcpinfo(int code) throws Exception {

		try { serverIP = InetAddress.getByName("127.0.0.1"); }
		catch(UnknownHostException ex) {
			System.out.println("Invalid server specified: " + "127.0.0.1");
			System.exit(1); }

		try { sock = new Socket(serverIP, 80); }
		catch(IOException ex) {
			System.out.println("Failed to establish TCP connection");
			System.exit(1); }


		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream sOut = new DataOutputStream(sock.getOutputStream());
		DataInputStream sIn = new DataInputStream(sock.getInputStream());


		protocol protocol =new protocol(code);
		protocol.send(sOut, "112345");
		protocol = new protocol(sIn);
		String str=protocol.getData();
		str.replace("[","");
		str.replace("]","");
		String[] result=str.split(",");
		//System.out.println(Arrays.toString(result));

		sock.close();
		return result;
		}

/*
	private  ClientUser currentCollaborator(){
		UserSession session= authorizationService.session().get();
		CollaboratorEmail collaboratorEmail=new CollaboratorEmail(session.authenticatedUser().email().toString());
		ClientUser clientUser= clientUserRepository.getClientUserByEmail(collaboratorEmail).get();
		return clientUser;
	}
*/

	}

