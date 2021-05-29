package eapli.base.Dashboardmanagement;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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

    public static void main(String args[]) throws Exception {
	Socket cliSock;


        
        accessesCounter=0;
        for(int i=0;i<candidatesNumber; i++) {
                candidateName[i] = "Candidate " + i;
                candidateVotes[i] = 0;
            }

        for(int i=0; i<5; i++){
            String string = "2014-2-2"+i+" 12:34";
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

            str[i]= "Atividade number:"+i+" Priorite: "+i +" Estado: " +"Completo "+"DeadLine:"+ string;
        }
	try { sock = new ServerSocket(80); }
	catch(IOException ex) {
            System.out.println("Server failed to open local port " + 80);
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
    private static final String str[] =new String[5];
    private static synchronized void incAccessesCounter() { accessesCounter++; }
    

    public static synchronized String preparactionActivities() {
        String textHtml="<hr><ul><h2> Activitys</h2>";
        for (int i = 0; i < 5; i++) {
            textHtml=textHtml+"<li style=\"color:red\">" +str[i]+"</li>";
        }
        textHtml=textHtml+"</ul></hr>";
        textHtml=textHtml+"<div><hr><ul>";
        textHtml+="<h2> Activity by Priority</h2>";
        for (int i = 4; i >0; i--) {
            textHtml=textHtml+"<li style=\"color:red\">" +str[i]+"</li>";
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
    public static synchronized String preparedbyPriority(){
        String textHtml="<hr><ul>";
        for (int i = 4; i >0; i--) {
            textHtml=textHtml+"<li style=\"color:red\">" +str[i]+"</li>";
        }
        textHtml=textHtml+"</ul></hr>";
        return textHtml;
    }
    
}
