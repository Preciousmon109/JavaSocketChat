package za.ac.tut.bl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.tut.entity.Message;

public class ChatHandlerThread implements Runnable{
	
	private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ChatHandlerThread(Socket socket) throws IOException {
        this.socket = socket;
        in =new BufferedReader (new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
    }    

    @Override
    public void run() {
        
        String data,msg,name;
        Message message;
        
        try {
            data = in.readLine();
            
        } catch (IOException ex) {
            Logger.getLogger(ChatHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
