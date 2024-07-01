package chatserverapp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.bl.ChatHandlerThread;

public class ChatServerApp {
	
	ServerSocket serverSocket = null;

    try {
        serverSocket = new ServerSocket(9090);
        System.out.println("Waiting for client request....");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Communication established: " + socket);

            // Create a new thread for each client
            ChatHandlerThread chatHandler = new ChatHandlerThread(socket);
            chatHandler.start();
        }
    } catch (IOException ex) {
        Logger.getLogger(ChatServerApp.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatServerApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
	    
}
