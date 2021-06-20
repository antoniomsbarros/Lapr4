package TCPSERVER;

import eapli.base.DashboardManagement.Protocol;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.application.SearchAutomaticTask;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class TcpSrvAutomaticTask {
	static ServerSocket sock;

	public static void main(String args[]) throws Exception {       
		Socket cliSock;
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());


		try { sock = new ServerSocket(9999); }
		catch(IOException ex) {
			System.out.println("Failed to open server socket");
			System.exit(1);
			}


		while(true) {
			cliSock=sock.accept();
			new Thread(new TcpSrvSumThread(cliSock)).start();
		}
	}
}



class TcpSrvSumThread implements Runnable {
	private Socket s;
	private DataOutputStream sOut;
	private DataInputStream sIn;
	public TcpSrvSumThread(Socket cli_s) {
		s=cli_s;
	}

	public void run() {
		InetAddress clientIP;
		clientIP=s.getInetAddress();
		SearchAutomaticTask searchAutomaticTask=new SearchAutomaticTask();
		System.out.println("New client connection from " + clientIP.getHostAddress() +
			", port number " + s.getPort());
		try {
			sOut = new DataOutputStream(s.getOutputStream());
			sIn = new DataInputStream(s.getInputStream());

			//AQUI vou buscar e executar o script da atividade automatica
			Protocol protocol =new Protocol(sIn);
			String data= protocol.getData();
			String[] automaticTask=data.split(", ");
			LinkedList<AutomaticTask> automaticTasks=new LinkedList<>();
			for (String str: automaticTask) {
				automaticTasks.add(searchAutomaticTask.automaticTaskbyid(Long.valueOf(str)));
			}
			FirstComeFirstServedAlgoritm firstComeFirstServedAlgoritm=new FirstComeFirstServedAlgoritm();

				firstComeFirstServedAlgoritm.firstComeFirstServerd(automaticTasks);




			System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
				" disconnected");
			s.close();
			}
		catch(IOException | InterruptedException ex) { System.out.println("IOException"); }
		}

	}



