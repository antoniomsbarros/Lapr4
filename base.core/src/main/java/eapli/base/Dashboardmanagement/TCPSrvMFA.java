package eapli.base.Dashboardmanagement;

import eapli.base.catalogmanagement.application.SearchActivity;
import eapli.base.catalogmanagement.domain.Activity;
import eapli.base.catalogmanagement.domain.Criticalitylevel;
import eapli.base.catalogmanagement.repository.ActivityRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import javax.persistence.Persistence;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
@UseCaseController
public
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
	private SearchActivity searchActivity;

	TCPSrvMFAThread(Socket cli_s) {
		s=cli_s;
		searchActivity=new SearchActivity();
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
					String data=protocol.getData();
					List<Activity> activityList=searchActivity.prepareactivity(Integer.valueOf(data));
					protocol.send(sOut, Arrays.toString(preparelistofActivitysincomplete( activityList)));
					System.out.println(Arrays.toString(preparelistofActivitysincomplete( activityList)));
					break;
				case 4:
					String data1=protocol.getData();
					List<Activity> activityList1=searchActivity.prepareactivity(Integer.valueOf(data1));
					String[] str=allActivitys( activityList1);
					protocol.send(sOut,Arrays.toString(str));
					System.out.println(Arrays.toString(str));

					break;
				case 5:
					String data2=protocol.getData();
					List<Activity> activityList2=searchActivity.prepareactivity(Integer.valueOf(data2));
					String[] str1=activitysByPriority( activityList2);
					protocol.send(sOut,Arrays.toString(str1));
					System.out.println(Arrays.toString(str1));

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
					if (activity.criticalitylevel()==null){
						temp[y]="ActivitY N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
								" DeadLine: " +activity.deadline();
					}else{
						temp[y]="ActivitY N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
								" DeadLine: " +activity.deadline()+"criticality: "+activity.criticalitylevel().print();
					}
y++;
				}
			}
			return temp;
		}
		private List<Activity> prepareremaningTestbydate(List<Activity>activityList){
			List<Activity> temp=new ArrayList<>();
			for (Activity a: activityList) {
				if (a.date().after(Calendar.getInstance()) && a.state().equals("EMRESOLUCAO")){
					temp.add(a);
				}
			}
			return temp;
		}
		private List<Activity>prepareactitivityByPriority(List<Activity>activityList){
			List<Activity> temp=prepareremaningTestbydate(activityList);
			List<Activity> resoluction=new ArrayList<>();
			Activity tempactivity=null;
			Long priority=99999L;
			for (Activity a: activityList) {
				for (Activity a1:activityList) {
					if (a1.priorityofActivity()<priority && !resoluction.contains(a1)){
						priority=a1.priorityofActivity();
						tempactivity=a1;
					}
				}
				resoluction.add(tempactivity);
			}
			return resoluction;
		}
		private String[] activitysByPriority(List<Activity>activityList){

			List<Activity> listofactivitysbypriority=prepareactitivityByPriority(activityList);
			String[] result=new String[activityList.size()];
			int i=0;
			for (Activity activity:listofactivitysbypriority) {
				if (activity.criticalitylevel()==null){
					result[i]="Activity N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
							" DeadLine: " +activity.deadline();
				}else {
					result[i]="Activity N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
							" DeadLine: " +activity.deadline()+"criticality: "+activity.criticalitylevel().print();
				}
				i++;
			}
			return result;
		}
		private String[] allActivitys(List<Activity>activityList){

		String[] temp=new String[activityList.size()];
		int i=0;
		for (Activity activity:activityList) {
			if (activity.criticalitylevel()==null){
				temp[i]="Activity N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
						" DeadLine: " +activity.deadline();
			}else {
				temp[i]="Activity N: " +activity.identity()+" Priority: "+activity.priorityofActivity()+
						" DeadLine: " +activity.deadline()+"criticality: "+activity.criticalitylevel().print();
			}
			i++;
			}
		return temp;
		}

	}



