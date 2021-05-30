package eapli.base.Dashboardmanagement;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpServerAjaxVoting {
    static private final String BASE_FOLDER="www";
    static private ServerSocket sock;
    private static TcpCliDashboard tcpCliDashboard;

    public static void main(String args[]) throws Exception {
	Socket cliSock;

        tcpCliDashboard=new TcpCliDashboard();
        activityResolucao=tcpCliDashboard.tcpinfo(3);
        System.out.println(Arrays.toString(activityResolucao));
        allactivitys=tcpCliDashboard.tcpinfo(4);
        System.out.println(Arrays.toString(allactivitys));
        activitysremaningbypriority=tcpCliDashboard.tcpinfo(5);
        System.out.println(Arrays.toString(activitysremaningbypriority));
	try { sock = new ServerSocket(70); }
	catch(IOException ex) {
            System.out.println("Server failed to open local port " +70);
            System.exit(1);
            }
	while(true) { 
            cliSock=sock.accept();
            HttpAjaxVotingRequest req=new HttpAjaxVotingRequest(cliSock, BASE_FOLDER);
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
