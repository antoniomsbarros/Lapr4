package eapli.base.Dashboardmanagement;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author ANDRE MOREIRA (asc@isep.ipp.pt)
 */
public class HttpAjaxVotingRequest extends Thread {
	String baseFolder;
	Socket sock;
	DataInputStream inS;
	DataOutputStream outS;
    
	public HttpAjaxVotingRequest(Socket s, String f) {
		baseFolder=f; sock=s;
		}	
    
	public void run() {
		try {
			outS = new DataOutputStream(sock.getOutputStream());
			inS = new DataInputStream(sock.getInputStream());
			}
		catch(IOException ex) { System.out.println("Thread error on data streams creation"); }
        	try {
        		HTTPmessage request = new HTTPmessage(inS);
        		HTTPmessage response = new HTTPmessage();
        		// System.out.println(request.getURI());
                    
        		if(request.getMethod().equals("GET")) {
        			if(request.getURI().equals("atividade")) {
					response.setContentFromString(
						HttpServerAjaxVoting.preparactionActivities(), "text/html");
					response.setResponseStatus("200 Ok");
					}
				else {
                            		String fullname="\\Lapr4\\base.core\\src\\main\\java\\eapli\\base\\Dashboardmanagement\\www\\index.html";
                            		if(response.setContentFromFile(fullname)) {
                                		response.setResponseStatus("200 Ok");
                                		}
                            		else {
                                		response.setContentFromString(
                                    			"<html><body><h1>404 File not found</h1></body></html>",
                                    			"text/html");
                                		response.setResponseStatus("404 Not Found"); 
                                		}
                            		}
                        	response.send(outS);                        
                        	}
                    	else { // NOT GET

                        	response.send(outS);
                        	}
                    	}
                catch(IOException ex) { System.out.println("Thread error when reading request"); }
		try { sock.close();}
		catch(IOException ex) { System.out.println("CLOSE IOException"); }
		}
	}

