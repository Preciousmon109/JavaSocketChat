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

public class ChatHandlerThread extends Thread {
    private Socket socket;

    public ChatHandlerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String messageLine;
            while ((messageLine = in.readLine()) != null) {
                String[] parts = messageLine.split("#");
                Message message = new Message(parts[0], parts[1]);
                System.out.println("Received message: " + message);

                // Echo the received message back to the client
                out.println("Message received: " + message);
            }
        } catch (IOException ex) {
            Logger.getLogger(ChatHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ChatHandlerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
