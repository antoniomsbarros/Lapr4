package eapli.base.Dashboardmanagement;

import eapli.base.catalogmanagement.domain.Activity;
import eapli.base.catalogmanagement.repository.ActivityRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

import javax.persistence.Persistence;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TCPSrvMFA {
	static ServerSocket sock;


	public static void main(String args[]) throws Exception {
		Socket cliSock;

		try { sock = new ServerSocket(80); }
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
	private ActivityRepository activityRepository;
	TCPSrvMFAThread(Socket cli_s) {
		s=cli_s;
		this.activityRepository = PersistenceContext.repositories().activity();
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



			if (code==3){
				List<Activity> activityList=prepareactivity(Integer.valueOf(protocol.getData()));
				protocol.send(sOut, Arrays.toString(preparelistofActivitysincomplete( activityList)));
			}

			System.out.println("Client " + clientIP.getHostAddress() + ", port number: " + s.getPort() + 
				" disconnected");
			s.close();
			}
		catch(IOException ex) { System.out.println("IOException"); }
		}
		private List<Activity> prepareactivity(Integer collaboratorNumber){
			Iterable<Activity> iterable= activityRepository.getAtivitiebyCollaborator(collaboratorNumber);
			List<Activity> list=new ArrayList<>();
			iterable.forEach(activity -> list.add(activity));
			return list;
		}
		private String[] preparelistofActivitysincomplete(List<Activity>activityList ){
			int cont=0;
			for (Activity a: activityList) {
				if (a.state().toString().equals("EMRESOLUCAO")){
					cont++;
				}
			}
			String[] temp=new String[cont];
			int y=0;
			for (int i = 0; i < activityList.size(); i++) {
				if (activityList.get(i).state().toString().equals("EMRESOLUCAO")){
					Activity activity=activityList.get(i);
					temp[y]="ActivitY N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
							" DeadLine: " +activity.deadline()+"criticality: "+activity.criticalitylevel().print();
				}
			}
			return temp;
		}
	}



