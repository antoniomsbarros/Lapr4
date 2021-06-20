package eapli.base.DashboardManagement;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import eapli.base.DashboardManagement.TcpClient;

public class HttpServerAjaxDashboard {
    static private final String BASE_FOLDER= "base.core\\src\\main\\java\\eapli\\base\\DashboardManagement\\www";
    static private ServerSocket sock;
    private static eapli.base.DashboardManagement.TcpClient tcpClient;
    private static  final  String IPAdress="10.9.21.107";
    private static  final  String IPAdressTemp="127.0.0.1";
    public static void main(String args[]) throws Exception {
	Socket cliSock;

        accessesCounter=0;
        for(int i=0;i<candidatesNumber; i++) {
                candidateName[i] = "Candidate " + i;
                candidateVotes[i] = 0;
            }
       /// tcpClient =new TcpClient();
        activityResolucao= tcpClient.tcpConnecting(3, CollaboratorNumber+" 3",IPAdress);

        System.out.println(Arrays.toString(activityResolucao) +" " +activityResolucao.length);
        tcpClient =new TcpClient();
        allactivitys= tcpClient.tcpConnecting(3, CollaboratorNumber+" 4", IPAdress);

        System.out.println(Arrays.toString(allactivitys)+" "+ allactivitys.length);
        tcpClient =new TcpClient();
        activitysremaningbypriority= tcpClient.tcpConnecting(3, CollaboratorNumber+" 5", IPAdress);
        System.out.println(Arrays.toString(activitysremaningbypriority)+ " "+ activitysremaningbypriority.length);



	try { sock = new ServerSocket(70); }
	catch(IOException ex) {
            System.out.println("Server failed to open local port " + 70);
            System.exit(1);
            }
	while(true) {
            cliSock=sock.accept();
            HttpAjaxDashboardRequest req=new HttpAjaxDashboardRequest(cliSock, BASE_FOLDER);
            req.start();
            incAccessesCounter();
            }

        } 
	
    
    // DATA ACCESSED BY THREADS - LOCKING REQUIRED
    
    private static final int candidatesNumber = 4;
    private static final String[] candidateName = new String[candidatesNumber];
    private static final int[] candidateVotes = new int[candidatesNumber];
    private static int accessesCounter;
    private static  int CollaboratorNumber=112345312;
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
        if (activityResolucao.length==1 && activitysremaningbypriority.length==1 && allactivitys.length==1){
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



    public static void castCollaborator(String substring) throws IOException {
        try {
            CollaboratorNumber=Integer.parseInt(substring);
            System.out.println(substring);
        } catch(NumberFormatException ne) { return; }

        activityResolucao= TcpClient.tcpConnecting(3, CollaboratorNumber+" 3",IPAdress);
        activityResolucao[0].replace("[", "");
        activityResolucao[activityResolucao.length-1].replace("]", "");
        System.out.println(Arrays.toString(activityResolucao));

        allactivitys= TcpClient.tcpConnecting(3, CollaboratorNumber+" 4", IPAdress);
        allactivitys[0].replace("[", "");
        allactivitys[allactivitys.length-1].replace("]", "");
        System.out.println(Arrays.toString(allactivitys));

        activitysremaningbypriority= TcpClient.tcpConnecting(3, CollaboratorNumber+" 5", IPAdress);
        activitysremaningbypriority[0].replace("[", "");
        activitysremaningbypriority[activitysremaningbypriority.length-1].replace("]", "");
        System.out.println(Arrays.toString(activitysremaningbypriority));
    }
}
