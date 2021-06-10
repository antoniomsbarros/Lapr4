package eapli.base.DashboardManagement;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;


public class HttpServerAjaxVoting {
    static private final String BASE_FOLDER= "C:\\Lapr4\\base.core\\src\\main\\java\\eapli\\base\\DashboardManagement\\www";
    static private ServerSocket sock;
    private static TcpCliDashboard tcpCliDashboard;
    public static void main(String args[]) throws Exception {
	Socket cliSock;


        accessesCounter=0;
        for(int i=0;i<candidatesNumber; i++) {
                candidateName[i] = "Candidate " + i;
                candidateVotes[i] = 0;
            }
        tcpCliDashboard=new TcpCliDashboard();
        activityResolucao=tcpCliDashboard.tcpinfo(3);
        System.out.println(Arrays.toString(activityResolucao));
        tcpCliDashboard=new TcpCliDashboard();
        allactivitys=tcpCliDashboard.tcpinfo(4);
        System.out.println(Arrays.toString(allactivitys));
        tcpCliDashboard=new TcpCliDashboard();
        activitysremaningbypriority=tcpCliDashboard.tcpinfo(5);
        System.out.println(Arrays.toString(activitysremaningbypriority));


        /*activityResolucao[0]="ActivitY N: 1 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activityResolucao[1]="ActivitY N: 2 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activityResolucao[2]="ActivitY N: 3 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        allactivitys=new String[3];
        allactivitys[0]="ActivitY N: 1 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        allactivitys[1]="ActivitY N: 2 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        allactivitys[2]="ActivitY N: 3 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activitysremaningbypriority=new String[3];
        activitysremaningbypriority[0]="ActivitY N: 1 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activitysremaningbypriority[1]="ActivitY N: 2 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";
        activitysremaningbypriority[2]="ActivitY N: 3 Priority: 1 DeadLine: Fri Nov 15 07:59:52 GMT 2030";*/
	try { sock = new ServerSocket(70); }
	catch(IOException ex) {
            System.out.println("Server failed to open local port " + 70);
            System.exit(1);
            }
	while(true) { 
            cliSock=sock.accept();
            HttpAjaxVotingRequest req=new HttpAjaxVotingRequest(cliSock, BASE_FOLDER);
            req.start();
            incAccessesCounter();
            }

        } 
	
    
    // DATA ACCESSED BY THREADS - LOCKING REQUIRED
    
    private static final int candidatesNumber = 4;
    private static final String[] candidateName = new String[candidatesNumber];
    private static final int[] candidateVotes = new int[candidatesNumber];
    private static int accessesCounter;
    private static String[] activityResolucao =new String[5];
    private static String[] allactivitys =new String[5];
    private static String[] activitysremaningbypriority =new String[5];
    private static synchronized void incAccessesCounter() { accessesCounter++; }
    
    public static synchronized String getVotesStandingInHTML() {
        String textHtml = "<hr><ul>";
        for(int i=0; i<candidatesNumber; i++) {
            textHtml = textHtml + "<li><button type=button onclick=voteFor(" + (i+1) +
                    ")>Vote for " + candidateName[i] + "</button> " +
                    " - " + candidateVotes[i] + " votes </li>";            
            }
        textHtml = textHtml + "</ul><hr><p>HTTP server accesses counter: " + accessesCounter + "</p><hr>";
        return textHtml;
        }
    public static synchronized String preparactionActivities() {
        String textHtml="";
        if (activityResolucao.length==0 && activitysremaningbypriority.length==0 && allactivitys.length==0){
            textHtml="<div><h1 align=center >The Collaborator has no activities</h1></div>";
            return textHtml;
        }
        textHtml="<hr><ul><h2> Activitys in resolution</h2>";
        for (int i = 0; i < activityResolucao.length; i++) {
            textHtml=textHtml+"<li style=\"color:red\">" +activityResolucao[i]+"</li>";
        }
        textHtml=textHtml+"</ul></hr>";
        textHtml=textHtml+"<div>";
        textHtml=textHtml+"<hr><ul><h2> Activitys Remaning by Priority </h2>";
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
    public static synchronized void castVote(String i) {
        int cN;
        try { cN=Integer.parseInt(i); }
        catch(NumberFormatException ne) { return; }
        cN--;
        if(cN >= 0 && cN < candidatesNumber) candidateVotes[cN]++;
    }
    
    
    
}
