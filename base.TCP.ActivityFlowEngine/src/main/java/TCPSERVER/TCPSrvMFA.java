package TCPSERVER;

import eapli.base.DashboardManagement.protocol;
import eapli.base.catalogmanagement.application.SearchActivity;
import eapli.base.catalogmanagement.domain.Activity;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.ordermanagement.application.SearchRequestController;
import eapli.base.ordermanagement.application.SearchTickController;
import eapli.base.taskmanagement.domain.Task;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@UseCaseController
@SuppressWarnings("squid:S106")
public final class TCPSrvMFA {
	static ServerSocket sock;


	public static void main(String args[]) throws Exception {
		Socket cliSock;
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(),
				new PlainTextEncoder());
			//RequestWorkflow requestWorkflow=new RequestWorkflow();
			//requestWorkflow.createWorkflowPedido("22","22");
		//SearchRequestController searchRequestController=new SearchRequestController();
		//searchRequestController.getrequestbyid(1L);
		//System.out.println(searchRequestController.getrequestbyid(1L).toString());

		SearchTickController searchTickController=new SearchTickController();

		System.out.println(searchTickController.searchTickbyRequestid(1L));
		try { sock = new ServerSocket(70); }
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

			protocol protocol =new protocol(sIn);
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



