package chatserverapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.bl.ChatHandlerThread;

public class ChatServerApp {
	
	    public static void main(String[] args) {
	        // TODO code application logic here
	        ServerSocket s;
	        Socket socket;
	        
	        try {
	            s = new ServerSocket(9090);
	            
	            while(true){
	                System.out.println("Waiting for client request....");
	                socket = s.accept();
	                
	                ChatHandlerThread ct = new ChatHandlerThread(socket);
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(ChatServerApp.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
	    
}
