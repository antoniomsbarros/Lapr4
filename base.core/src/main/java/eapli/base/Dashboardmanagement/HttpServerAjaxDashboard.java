package eapli.base.Dashboardmanagement;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class HttpServerAjaxDashboard {
    static private final String BASE_FOLDER="www";
    static private ServerSocket sock;
    private static TcpCliDashboard tcpCliDashboard;

    public static void main(String args[]) throws Exception {
	Socket cliSock;

        /*tcpCliDashboard=new TcpCliDashboard();
        activityResolucao=tcpCliDashboard.tcpinfo(3);
        System.out.println(Arrays.toString(activityResolucao));
        allactivitys=tcpCliDashboard.tcpinfo(4);
        System.out.println(Arrays.toString(allactivitys));
        activitysremaningbypriority=tcpCliDashboard.tcpinfo(5);
        System.out.println(Arrays.toString(activitysremaningbypriority));*/
        activityResolucao=new String[3];
        activityResolucao[0]="ActivitY N: 1 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activityResolucao[1]="ActivitY N: 2 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activityResolucao[2]="ActivitY N: 3 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        allactivitys=new String[3];
        allactivitys[0]="ActivitY N: 1 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        allactivitys[1]="ActivitY N: 2 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        allactivitys[2]="ActivitY N: 3 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activitysremaningbypriority=new String[3];
        activitysremaningbypriority[0]="ActivitY N: 1 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activitysremaningbypriority[1]="ActivitY N: 2 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activitysremaningbypriority[2]="ActivitY N: 3 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";

	try { sock = new ServerSocket(80); }
	catch(IOException ex) {
            System.out.println("Server failed to open local port " +80);
            System.exit(1);
            }
	while(true) { 
            cliSock=sock.accept();
            HttpAjaxDashboardRequest req=new HttpAjaxDashboardRequest(cliSock, BASE_FOLDER);
            req.start();

            }
        } 
	
    
    // DATA ACCESSED BY THREADS - LOCKING REQUIRED

    private static String[] activityResolucao =new String[5];
    private static String[] allactivitys =new String[5];
    private static String[] activitysremaningbypriority =new String[5];

    

    public static synchronized String preparactionActivities() {
        String textHtml="<hr><ul><h2> Activitys in resolution</h2>";
        for (int i = 0; i < activityResolucao.length; i++) {
            textHtml=textHtml+"<li style=\"color:red\">" +activityResolucao[i]+"</li>";
        }
        textHtml=textHtml+"</ul></hr>";
        textHtml=textHtml+"<div><hr><ul>";
         textHtml="<hr><ul><h2> Activitys Remaning by Priority </h2>";
        for (int i = 0; i < activitysremaningbypriority.length; i++) {
            textHtml=textHtml+"<li style=\"color:red\">" +activitysremaningbypriority[i]+"</li>";
        }
        textHtml=textHtml+"</ul></hr></div>";
        textHtml=textHtml+"<div><hr><ul>";
        textHtml+="<h2>All Activitys</h2>";
        for (int i = 0; i<allactivitys.length; i++) {
            textHtml=textHtml+"<li style=\"color:red\">" +allactivitys[i]+"</li>";
        }
        textHtml=textHtml+"</ul></hr></div>";
        return textHtml;
    }


    
}
