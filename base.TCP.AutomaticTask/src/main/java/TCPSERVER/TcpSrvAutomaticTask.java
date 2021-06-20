package TCPSERVER;

import eapli.base.DashboardManagement.Protocol;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.taskmanagement.application.ChangeStatusofActivity;
import eapli.base.taskmanagement.application.SearchAutomaticTask;
import eapli.base.taskmanagement.domain.AutomaticTask;
import eapli.base.taskmanagement.domain.TaskState;
import eapli.base.usermanagement.domain.BasePasswordPolicy;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class TcpSrvAutomaticTask {
	//static ServerSocket sock;

	public static void main(String args[]) throws Exception {       
		Socket cliSock;
		SSLServerSocket sock=null;
		AuthzRegistry.configure(PersistenceContext.repositories().users(), new BasePasswordPolicy(), new PlainTextEncoder());

		SSLServerSocketFactory sslF = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		try { sock = (SSLServerSocket) sslF.createServerSocket(70);
			sock.setNeedClientAuth(true); }
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
	private ChangeStatusofActivity changeStatusofActivity;
	private SearchAutomaticTask searchAutomaticTask=new SearchAutomaticTask();
	public TcpSrvSumThread(Socket cli_s) {
		s=cli_s;
		this.changeStatusofActivity=new ChangeStatusofActivity();
	}
	public void run() {
		InetAddress clientIP;
		clientIP=s.getInetAddress();

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

			//AutomaticTask automaticTask1= searchAutomaticTask.automaticTaskbyid(Long.valueOf(automaticTask[0]));

			protocol.send(sOut, "done");


			System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() +
				" disconnected");
			s.close();
			}
		catch(IOException ex) { System.out.println("IOException"); } catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	}



