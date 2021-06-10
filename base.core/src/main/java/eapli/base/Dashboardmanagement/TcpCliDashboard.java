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

	public static  String[] tcpinfo(int code, String data) throws Exception {

		try { serverIP = InetAddress.getByName("10.9.21.107"); }
		catch(UnknownHostException ex) {
			System.out.println("Invalid server specified: " + "10.9.21.107");
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
		String[] temp=protocol.getData().split(" ");
		String str=temp[0];
		sock.close();
		String result1[]=new String[Integer.parseInt(str)];
		for (int i = 0; i < Integer.parseInt(str); i++) {
			sock=new Socket(serverIP, 70);
			BufferedReader in1 = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream sOut1 = new DataOutputStream(sock.getOutputStream());
			DataInputStream sIn1 = new DataInputStream(sock.getInputStream());
			protocol protocol1 =new protocol(code);
			protocol1.send(sOut1, "112345"+" "+i);
			protocol1 = new protocol(sIn1);
			result1[i]=protocol1.getData();
			System.out.println(result1[i]);
			sock.close();
		}
		str.replace("[","");
		str.replace("]","");
		String[] result=str.split(",");



		return result1;
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

